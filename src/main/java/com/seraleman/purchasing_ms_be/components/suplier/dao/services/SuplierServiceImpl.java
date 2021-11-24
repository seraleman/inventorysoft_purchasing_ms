package com.seraleman.purchasing_ms_be.components.suplier.dao.services;

import java.util.ArrayList;
import java.util.List;

import com.seraleman.purchasing_ms_be.components.suplier.Suplier;
import com.seraleman.purchasing_ms_be.components.suplier.dao.ISuplierDao;
import com.seraleman.purchasing_ms_be.services.response.IResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SuplierServiceImpl implements ISuplierService {

    @Autowired
    private IResponseService response;

    @Autowired
    private ISuplierDao suplierDao;

    @Override
    public ResponseEntity<?> list() {

        List<Suplier> supliers = new ArrayList<>();

        try {
            supliers = suplierDao.findAll();
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (supliers.size() == 0) {
            return response.empty();
        }
        return response.list(supliers);
    }

    @Override
    public ResponseEntity<?> show(String id) {

        Suplier suplier = null;

        try {
            suplier = suplierDao.findById(id.toString()).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (suplier == null) {
            return response.notFound(id.toString());
        }
        return response.found(suplier);
    }

    @Override
    public ResponseEntity<?> create(Suplier suplier) {

        Suplier suplierNew = null;

        try {
            suplierNew = suplierDao.save(suplier);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.created(suplierNew);
    }

    @Override
    public ResponseEntity<?> update(String id, Suplier suplier) {

        Suplier providerCurrent = null;

        try {
            providerCurrent = suplierDao.findById(id).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (providerCurrent == null) {
            return response.notFound(id);
        }

        try {
            providerCurrent.setBusinessName(suplier.getBusinessName());
            providerCurrent.setName(suplier.getName());
            providerCurrent.setNit(suplier.getNit());
            suplierDao.save(providerCurrent);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.updated(providerCurrent);
    }

    @Override
    public ResponseEntity<?> delete(String id) {

        Suplier suplier = null;

        try {
            suplier = suplierDao.findById(id).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (suplier == null) {
            return response.notFound(id);
        }

        try {
            suplierDao.deleteById(id);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.deleted();
    }

}
