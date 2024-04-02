package com.bezkoder.spring.jwt.mongodb.repository;

import com.bezkoder.spring.jwt.mongodb.models.TenderModel;
import com.bezkoder.spring.jwt.mongodb.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TenderRepository extends MongoRepository<TenderModel, String> {

    List<TenderModel> findAllByApproved(Boolean approved);
    List<TenderModel> findAllByDraft(Boolean draft);
}
