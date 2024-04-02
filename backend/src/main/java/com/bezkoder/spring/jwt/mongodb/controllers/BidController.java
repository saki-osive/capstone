package com.bezkoder.spring.jwt.mongodb.controllers;

import com.bezkoder.spring.jwt.mongodb.events.Events;
import com.bezkoder.spring.jwt.mongodb.models.Bid;
import com.bezkoder.spring.jwt.mongodb.models.BidItem;
import com.bezkoder.spring.jwt.mongodb.models.TenderModel;
import com.bezkoder.spring.jwt.mongodb.network.response.BaseResponse;
import com.bezkoder.spring.jwt.mongodb.repository.BidItemRepository;
import com.bezkoder.spring.jwt.mongodb.repository.BidRepository;
import com.bezkoder.spring.jwt.mongodb.repository.TenderRepository;
import com.bezkoder.spring.jwt.mongodb.services.TransactionService;
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
@RequestMapping("/api/bid")
public class BidController {

    @Autowired
    BidRepository bidRepository;

    @Autowired
    TransactionService transactionService;

    @Autowired
    BidItemRepository bidItemRepository;

    @Autowired
    private MinioService minioService;

    private final String folderPath = "";

    @GetMapping("/all")
    public ResponseEntity<?> getAllDraftTenders() {
        ResponseEntity<?> result = null;

        List<Bid> allBids = bidRepository.findAll();
        result = new ResponseEntity<>(allBids, HttpStatus.CREATED);

        return result;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST,consumes = MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createBid(@RequestParam(value = "technicalDoc",required = false) MultipartFile technicalDoc,
                                       @RequestParam(value = "financialDoc", required = false) MultipartFile financialDoc,
                                       @RequestParam("bid") String bidModelString) {

        ResponseEntity<?> result = null;

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {

            Bid bidModel = objectMapper.readValue(bidModelString, Bid.class);
            List<BidItem> bidItems = bidModel.getBidItems();
            for (BidItem item:bidItems){
                item = bidItemRepository.save(item);
            }

            //upload financial and tech docs to minio
            if (technicalDoc != null){
                Path technicalDocumentPath = Path.of(folderPath+technicalDoc.getOriginalFilename());
                minioService.upload(technicalDocumentPath, technicalDoc.getInputStream(), technicalDoc.getContentType());
                bidModel.setTechnicalDocumentPath(folderPath+technicalDocumentPath.toString());
            }

            if (financialDoc != null){
                Path financialDocPath = Path.of(folderPath+financialDoc.getOriginalFilename());
                minioService.upload(financialDocPath, financialDoc.getInputStream(), financialDoc.getContentType());
                bidModel.setFinancialDocumentPath(folderPath+financialDocPath.toString());
            }

            //save bid
            Bid _bid = bidRepository.save(bidModel);

            transactionService.log("", Events.BID_CREATED,"",_bid);
            result = ResponseEntity.ok(new BaseResponse("Bid created successfully.",true,_bid));

        }catch (Exception e){
            e.printStackTrace();
            result = ResponseEntity
                    .badRequest()
                    .body(new BaseResponse("Bad Response.",false));
        }

        return result;
    }

}
