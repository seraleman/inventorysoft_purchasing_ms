package com.seraleman.purchasing_ms_be.components.purchaseItems.dao;

import com.seraleman.purchasing_ms_be.components.purchaseItems.PurchaseItem;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPurchaseItemDao extends MongoRepository<PurchaseItem, String> {

}
