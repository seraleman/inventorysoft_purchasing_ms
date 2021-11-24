package com.seraleman.purchasing_ms_be.components.purchaseItems.dao.services;

import com.seraleman.purchasing_ms_be.components.purchaseItems.PurchaseItem;

import org.springframework.http.ResponseEntity;

public interface IPurchaseItemService {

    public ResponseEntity<?> list();

    public ResponseEntity<?> show(String id);

    public ResponseEntity<?> create(PurchaseItem purchaseItem);

    public ResponseEntity<?> update(String id, PurchaseItem purchaseItem);

    public ResponseEntity<?> delete(String id);
}
