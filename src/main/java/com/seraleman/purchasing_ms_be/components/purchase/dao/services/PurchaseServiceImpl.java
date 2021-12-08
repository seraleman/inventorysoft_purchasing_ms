package com.seraleman.purchasing_ms_be.components.purchase.dao.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import com.seraleman.purchasing_ms_be.components.purchase.Purchase;
import com.seraleman.purchasing_ms_be.components.purchase.dao.IPurchaseDao;
import com.seraleman.purchasing_ms_be.services.response.IResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements IPurchaseService {

    @Autowired
    private IPurchaseDao purchaseDao;

    @Autowired
    private IResponseService response;

    @Override
    public ResponseEntity<?> list() {

        List<Purchase> purchases = new ArrayList<>();

        try {
            purchases = purchaseDao.findAll();
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (purchases.size() == 0) {
            return response.empty();
        }
        return response.list(purchases);
    }

    @Override
    public ResponseEntity<?> show(String id) {

        Purchase purchase = null;

        try {
            purchase = purchaseDao.findById(id.toString()).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (purchase == null) {
            return response.notFound(id.toString());
        }
        return response.found(purchase);
    }

    @Override
    public ResponseEntity<?> create(Purchase purchase) {

        Purchase purchaseNew = null;
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        LocalDateTime bogotaLocal = zdt.toLocalDateTime();
        purchase.setDate(bogotaLocal);

        try {
            purchaseNew = purchaseDao.save(purchase);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.created(purchaseNew);
    }

    @Override
    public ResponseEntity<?> update(String id, Purchase purchase) {

        Purchase purchaseCurrent = null;

        try {
            purchaseCurrent = purchaseDao.findById(id).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (purchaseCurrent == null) {
            return response.notFound(id);
        }

        try {
            purchaseCurrent.setDate(purchase.getDate());
            purchaseCurrent.setItems(purchase.getItems());
            purchaseCurrent.setSuplier(purchase.getSuplier());
            purchaseDao.save(purchaseCurrent);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.updated(purchaseCurrent);
    }

    @Override
    public ResponseEntity<?> delete(String id) {

        Purchase purchase = null;

        try {
            purchase = purchaseDao.findById(id).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (purchase == null) {
            return response.notFound(id);
        }

        try {
            purchaseDao.deleteById(id);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.deleted();
    }

}
