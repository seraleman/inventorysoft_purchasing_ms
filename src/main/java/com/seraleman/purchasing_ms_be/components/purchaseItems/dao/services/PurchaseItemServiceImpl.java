package com.seraleman.purchasing_ms_be.components.purchaseItems.dao.services;

import java.util.ArrayList;
import java.util.List;

import com.seraleman.purchasing_ms_be.components.purchaseItems.PurchaseItem;
import com.seraleman.purchasing_ms_be.components.purchaseItems.dao.IPurchaseItemDao;
import com.seraleman.purchasing_ms_be.services.response.IResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PurchaseItemServiceImpl implements IPurchaseItemService {

    @Autowired
    private IPurchaseItemDao purchaseItemDao;

    @Autowired
    private IResponseService response;

    @Override
    public ResponseEntity<?> list() {

        List<PurchaseItem> purchaseItems = new ArrayList<>();

        try {
            purchaseItems = purchaseItemDao.findAll();
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (purchaseItems.size() == 0) {
            return response.empty();
        }
        return response.list(purchaseItems);
    }

    @Override
    public ResponseEntity<?> show(String id) {

        PurchaseItem purchaseItem = null;

        try {
            purchaseItem = purchaseItemDao.findById(id.toString()).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (purchaseItem == null) {
            return response.notFound(id.toString());
        }
        return response.found(purchaseItem);
    }

    @Override
    public ResponseEntity<?> create(PurchaseItem purchaseItem) {

        PurchaseItem purchaseItemNew = null;

        try {
            purchaseItemNew = purchaseItemDao.save(purchaseItem);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.created(purchaseItemNew);
    }

    @Override
    public ResponseEntity<?> update(String id, PurchaseItem purchaseItem) {

        PurchaseItem purchaseItemCurrent = null;

        try {
            purchaseItemCurrent = purchaseItemDao.findById(id).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (purchaseItemCurrent == null) {
            return response.notFound(id);
        }

        try {
            purchaseItemCurrent.setProductoId(purchaseItem.getProductoId());
            purchaseItemCurrent.setQuantity(purchaseItem.getQuantity());
            purchaseItemCurrent.setUnitCost(purchaseItem.getUnitCost());
            purchaseItemDao.save(purchaseItemCurrent);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.updated(purchaseItemCurrent);
    }

    @Override
    public ResponseEntity<?> delete(String id) {

        PurchaseItem purchaseItem = null;

        try {
            purchaseItem = purchaseItemDao.findById(id).orElse(null);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }

        if (purchaseItem == null) {
            return response.notFound(id);
        }

        try {
            purchaseItemDao.deleteById(id);
        } catch (DataAccessException e) {
            return response.errorDataAccess(e);
        }
        return response.deleted();
    }

}
