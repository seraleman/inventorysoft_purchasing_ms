package com.seraleman.purchasing_ms_be.components.suplier.dao.services;

import com.seraleman.purchasing_ms_be.components.suplier.Suplier;

import org.springframework.http.ResponseEntity;

public interface ISuplierService {

    public ResponseEntity<?> list();

    public ResponseEntity<?> show(String id);

    public ResponseEntity<?> create(Suplier suplier);

    public ResponseEntity<?> update(String id, Suplier suplier);

    public ResponseEntity<?> delete(String id);
}
