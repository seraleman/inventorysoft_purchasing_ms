package com.seraleman.purchasing_ms_be.components.purchase;

import com.seraleman.purchasing_ms_be.components.purchase.dao.services.IPurchaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms/api/purchases")
public class PurchaseRestController {
    
    @Autowired
    private IPurchaseService purchaseService;

    @GetMapping("/")
    public ResponseEntity<?> list() {
        return purchaseService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable String id) {
        return purchaseService.show(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Purchase purchase) {
        return purchaseService.create(purchase);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Purchase purchase) {
        return purchaseService.update(id, purchase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return purchaseService.delete(id);
    }
}
