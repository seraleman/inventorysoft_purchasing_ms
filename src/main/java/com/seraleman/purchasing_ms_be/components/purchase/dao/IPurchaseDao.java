package com.seraleman.purchasing_ms_be.components.purchase.dao;

import com.seraleman.purchasing_ms_be.components.purchase.Purchase;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPurchaseDao extends MongoRepository<Purchase, String> {

}
