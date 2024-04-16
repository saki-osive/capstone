package com.lotlock.spring.jwt.mongodb.repository;

import com.lotlock.spring.jwt.mongodb.models.LotModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LotRepository extends MongoRepository<LotModel, String> {

    List<LotModel> findAllByApproved(Boolean approved);
    List<LotModel> findAllByDraft(Boolean draft);
}
