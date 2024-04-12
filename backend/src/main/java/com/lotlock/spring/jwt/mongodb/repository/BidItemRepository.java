package com.lotlock.spring.jwt.mongodb.repository;

import com.lotlock.spring.jwt.mongodb.models.Bid;
import com.lotlock.spring.jwt.mongodb.models.BidItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BidItemRepository extends MongoRepository<BidItem, String> {

}
