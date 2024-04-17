package com.lotlock.spring.jwt.mongodb.repository;

import com.lotlock.spring.jwt.mongodb.models.ProductItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductItemRepository extends MongoRepository<ProductItem, String> {

}
