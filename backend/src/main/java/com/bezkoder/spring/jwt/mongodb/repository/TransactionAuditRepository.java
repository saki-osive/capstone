package com.bezkoder.spring.jwt.mongodb.repository;

import com.bezkoder.spring.jwt.mongodb.models.TenderModel;
import com.bezkoder.spring.jwt.mongodb.models.TransactionAudit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionAuditRepository extends MongoRepository<TransactionAudit, String> {

}
