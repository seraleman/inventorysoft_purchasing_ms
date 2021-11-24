package com.seraleman.purchasing_ms_be.components.purchase.dao.services;

import com.seraleman.purchasing_ms_be.components.purchase.Purchase;

import org.springframework.http.ResponseEntity;

public interface IPurchaseService {
    
    public ResponseEntity<?> list();

    public ResponseEntity<?> show(String id);

    public ResponseEntity<?> create(Purchase suplier);

    public ResponseEntity<?> update(String id, Purchase suplier);

    public ResponseEntity<?> delete(String id);
}
