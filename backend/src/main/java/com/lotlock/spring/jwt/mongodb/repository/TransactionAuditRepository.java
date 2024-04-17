package com.lotlock.spring.jwt.mongodb.repository;

import com.lotlock.spring.jwt.mongodb.models.TransactionAudit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionAuditRepository extends MongoRepository<TransactionAudit, String> {

}
