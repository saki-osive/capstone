package com.bezkoder.spring.jwt.mongodb.repository;

import com.bezkoder.spring.jwt.mongodb.models.Bid;
import com.bezkoder.spring.jwt.mongodb.models.BidItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BidItemRepository extends MongoRepository<BidItem, String> {

}
