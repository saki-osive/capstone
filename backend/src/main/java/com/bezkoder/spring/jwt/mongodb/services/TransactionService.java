package com.bezkoder.spring.jwt.mongodb.services;

import com.bezkoder.spring.jwt.mongodb.models.TransactionAudit;
import com.bezkoder.spring.jwt.mongodb.repository.TransactionAuditRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {


    @Autowired
    TransactionAuditRepository repository;


    public void log(String hashCode,String eventName,String eventDetails,Object data){

        String uniqueID = UUID.randomUUID().toString();
        TransactionAudit audit = new TransactionAudit();
        audit.setEventDetails(eventDetails);
        audit.setHashCode(uniqueID);
        audit.setEventName(eventName);

        ObjectMapper Obj = new ObjectMapper();
        try {
            String jsonStr = Obj.writeValueAsString(data);
            audit.setBlob(jsonStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        repository.save(audit);
    }

    public void log(String hashCode,String eventName,String eventDetails){

        String uniqueID = UUID.randomUUID().toString();
        TransactionAudit audit = new TransactionAudit();
        audit.setEventDetails(eventDetails);
        audit.setHashCode(uniqueID);
        audit.setEventName(eventName);

        repository.save(audit);
    }
}
