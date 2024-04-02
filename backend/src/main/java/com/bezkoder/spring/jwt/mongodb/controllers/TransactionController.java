package com.bezkoder.spring.jwt.mongodb.controllers;


import com.bezkoder.spring.jwt.mongodb.models.TenderModel;
import com.bezkoder.spring.jwt.mongodb.models.TransactionAudit;
import com.bezkoder.spring.jwt.mongodb.network.response.BaseResponse;
import com.bezkoder.spring.jwt.mongodb.repository.TransactionAuditRepository;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    TransactionAuditRepository transactionAuditRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        ResponseEntity<?> result = null;
        List<TransactionAudit> allAudits = transactionAuditRepository.findAll();
        result = new ResponseEntity<>(allAudits, HttpStatus.CREATED);
        return result;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTransaction(@Valid @RequestBody TransactionAudit transactionAudit) {
        ResponseEntity<?> result = null;

        try {
            TransactionAudit _transactionAudit = transactionAuditRepository.save(transactionAudit);
            BaseResponse baseResponse = new BaseResponse("Created",true,transactionAudit);
            result = new ResponseEntity<>(baseResponse, HttpStatus.CREATED);

        }catch (Exception e){
            e.printStackTrace();
            result = ResponseEntity
                    .badRequest()
                    .body(new BaseResponse("Bad Response.",false));
        }

        return result;
    }

}
