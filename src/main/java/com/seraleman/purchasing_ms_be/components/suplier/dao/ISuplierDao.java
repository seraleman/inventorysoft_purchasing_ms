package com.seraleman.purchasing_ms_be.components.suplier.dao;

import com.seraleman.purchasing_ms_be.components.suplier.Suplier;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISuplierDao extends MongoRepository<Suplier, String> {

}
