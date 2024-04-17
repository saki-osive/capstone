package com.lotlock.spring.jwt.mongodb.controllers;

import com.lotlock.spring.jwt.mongodb.events.Events;
import com.lotlock.spring.jwt.mongodb.models.LotModel;
import com.lotlock.spring.jwt.mongodb.network.response.BaseResponse;
import com.lotlock.spring.jwt.mongodb.repository.LotRepository;
import com.lotlock.spring.jwt.mongodb.services.TransactionService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jlefebure.spring.boot.minio.MinioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.nio.file.Path;
import java.util.List;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/lot")
public class LotController {

    @Autowired
    LotRepository lotRepository;

    @Autowired
    private MinioService minioService;

    @Autowired
    TransactionService transactionService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        ResponseEntity<?> result = null;

        List<LotModel> allLots = lotRepository.findAll();
        result = new ResponseEntity<>(allLots, HttpStatus.CREATED);
        return result;
    }

    @GetMapping("/approvedLots")
    public ResponseEntity<?> getAllApprovedLots() {
        ResponseEntity<?> result = null;

        List<LotModel> allLots = lotRepository.findAllByApproved(true);
        result = new ResponseEntity<>(allLots, HttpStatus.CREATED);
        return result;
    }

    @GetMapping("/pastLots")
    public ResponseEntity<?> getAllPastLots() {
        ResponseEntity<?> result = null;

        List<LotModel> allLots = lotRepository.findAllByApproved(true);
        result = new ResponseEntity<>(allLots, HttpStatus.CREATED);
        return result;
    }

    @GetMapping("/allLotsSentForApproval")
    public ResponseEntity<?> getAllSentForApproval() {
        ResponseEntity<?> result = null;

        List<LotModel> allLots = lotRepository.findAllByApproved(false);
        result = new ResponseEntity<>(allLots, HttpStatus.CREATED);
        return result;
    }

    @GetMapping("/allDraftLots")
    public ResponseEntity<?> getAllDraftLots() {
        ResponseEntity<?> result = null;

        List<LotModel> allLots = lotRepository.findAllByDraft(true);
        result = new ResponseEntity<>(allLots, HttpStatus.CREATED);

        return result;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createLot(@Valid @RequestBody LotModel lotModel) {
        ResponseEntity<?> result = null;

        try {
            LotModel _lot = lotRepository.save(lotModel);
            result = new ResponseEntity<>(_lot, HttpStatus.CREATED);
            transactionService.log("", Events.LOT_CREATED,"",_lot);
        }catch (Exception e){
            e.printStackTrace();
            result = ResponseEntity
                    .badRequest()
                    .body(new BaseResponse("Bad Response.",false));
        }

        return result;
    }

    @RequestMapping(value = "/uploadAndSave", method = RequestMethod.POST,consumes = MULTIPART_FORM_DATA_VALUE)
    public @ResponseBody ResponseEntity<?> upload( @RequestParam(value = "lotDocument",required = false) MultipartFile lotDocument,
                                                  @RequestParam(value = "sorDocument", required = false) MultipartFile sorDocument,
                                                  @RequestParam("lot") String lotModelString) throws Exception {
        ResponseEntity<?> result = null;

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        LotModel lotModel = objectMapper.readValue(lotModelString, LotModel.class);

        try {

            if (lotDocument != null){
                Path lotDocumentPath = Path.of(lotDocument.getOriginalFilename());
                minioService.upload(lotDocumentPath, lotDocument.getInputStream(), lotDocument.getContentType());
                lotModel.setLotFileDocumentPath(lotDocumentPath.toString());
            }

            if (sorDocument != null){
                Path sorDocumentPath = Path.of(sorDocument.getOriginalFilename());
                minioService.upload(sorDocumentPath, sorDocument.getInputStream(), sorDocument.getContentType());
                lotModel.setSorFilePath(sorDocumentPath.toString());
            }

            //save lot after uploading files to minio
            lotRepository.save(lotModel);
            transactionService.log("", Events.LOT_CREATED,"",lotModel);
            result = new ResponseEntity<>(new BaseResponse("Lot saved successfully.",true), HttpStatus.CREATED);
        } catch (Exception e) {
            result = ResponseEntity
                    .badRequest()
                    .body(new BaseResponse("Bad Response.",false));
        }

        return result;
    }




}
