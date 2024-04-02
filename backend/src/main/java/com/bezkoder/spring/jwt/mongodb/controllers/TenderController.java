package com.bezkoder.spring.jwt.mongodb.controllers;

import com.bezkoder.spring.jwt.mongodb.events.Events;
import com.bezkoder.spring.jwt.mongodb.models.TenderModel;
import com.bezkoder.spring.jwt.mongodb.models.User;
import com.bezkoder.spring.jwt.mongodb.network.response.BaseResponse;
import com.bezkoder.spring.jwt.mongodb.payload.request.ForgotPasswordRequest;
import com.bezkoder.spring.jwt.mongodb.payload.response.MessageResponse;
import com.bezkoder.spring.jwt.mongodb.repository.TenderRepository;
import com.bezkoder.spring.jwt.mongodb.services.TransactionService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jlefebure.spring.boot.minio.MinioException;
import com.jlefebure.spring.boot.minio.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tender")
public class TenderController {

    @Autowired
    TenderRepository tenderRepository;

    @Autowired
    private MinioService minioService;

    @Autowired
    TransactionService transactionService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        ResponseEntity<?> result = null;

        List<TenderModel> allTenders = tenderRepository.findAll();
        result = new ResponseEntity<>(allTenders, HttpStatus.CREATED);
        return result;
    }

    @GetMapping("/approvedTenders")
    public ResponseEntity<?> getAllApprovedTenders() {
        ResponseEntity<?> result = null;

        List<TenderModel> allTenders = tenderRepository.findAllByApproved(true);
        result = new ResponseEntity<>(allTenders, HttpStatus.CREATED);
        return result;
    }

    @GetMapping("/pastTenders")
    public ResponseEntity<?> getAllPastTenders() {
        ResponseEntity<?> result = null;

        List<TenderModel> allTenders = tenderRepository.findAllByApproved(true);
        result = new ResponseEntity<>(allTenders, HttpStatus.CREATED);
        return result;
    }

    @GetMapping("/allTendersSentForApproval")
    public ResponseEntity<?> getAllSentForApproval() {
        ResponseEntity<?> result = null;

        List<TenderModel> allTenders = tenderRepository.findAllByApproved(false);
        result = new ResponseEntity<>(allTenders, HttpStatus.CREATED);
        return result;
    }

    @GetMapping("/allDraftTenders")
    public ResponseEntity<?> getAllDraftTenders() {
        ResponseEntity<?> result = null;

        List<TenderModel> allTenders = tenderRepository.findAllByDraft(true);
        result = new ResponseEntity<>(allTenders, HttpStatus.CREATED);

        return result;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTender(@Valid @RequestBody TenderModel tenderModel) {
        ResponseEntity<?> result = null;

        try {
            TenderModel _tender = tenderRepository.save(tenderModel);
            result = new ResponseEntity<>(_tender, HttpStatus.CREATED);
            transactionService.log("", Events.TENDER_CREATED,"",_tender);
        }catch (Exception e){
            e.printStackTrace();
            result = ResponseEntity
                    .badRequest()
                    .body(new BaseResponse("Bad Response.",false));
        }

        return result;
    }

    @RequestMapping(value = "/uploadAndSave", method = RequestMethod.POST,consumes = MULTIPART_FORM_DATA_VALUE)
    public @ResponseBody ResponseEntity<?> upload( @RequestParam(value = "tenderDocument",required = false) MultipartFile tenderDocument,
                                                  @RequestParam(value = "sorDocument", required = false) MultipartFile sorDocument,
                                                  @RequestParam("tender") String tenderModelString) throws Exception {
        ResponseEntity<?> result = null;

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        TenderModel tenderModel = objectMapper.readValue(tenderModelString, TenderModel.class);

        try {

            if (tenderDocument != null){
                Path tenderDocumentPath = Path.of(tenderDocument.getOriginalFilename());
                minioService.upload(tenderDocumentPath, tenderDocument.getInputStream(), tenderDocument.getContentType());
                tenderModel.setTenderFileDocumentPath(tenderDocumentPath.toString());
            }

            if (sorDocument != null){
                Path sorDocumentPath = Path.of(sorDocument.getOriginalFilename());
                minioService.upload(sorDocumentPath, sorDocument.getInputStream(), sorDocument.getContentType());
                tenderModel.setSorFilePath(sorDocumentPath.toString());
            }

            //save tender after uploading files to mminio
            tenderRepository.save(tenderModel);
            transactionService.log("", Events.TENDER_CREATED,"",tenderModel);
            result = new ResponseEntity<>(new BaseResponse("Tender saved successfully.",true), HttpStatus.CREATED);
        } catch (Exception e) {
            result = ResponseEntity
                    .badRequest()
                    .body(new BaseResponse("Bad Response.",false));
        }

        return result;
    }




}
