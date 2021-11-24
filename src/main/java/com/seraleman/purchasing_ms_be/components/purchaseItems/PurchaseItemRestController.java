package com.seraleman.purchasing_ms_be.components.purchaseItems;

import com.seraleman.purchasing_ms_be.components.purchaseItems.dao.services.IPurchaseItemService;

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
@RequestMapping("/ms/api/purchaseItems")
public class PurchaseItemRestController {

    @Autowired
    private IPurchaseItemService purchaseItemService;

    @GetMapping("/")
    public ResponseEntity<?> list() {
        return purchaseItemService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable String id) {
        return purchaseItemService.show(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody PurchaseItem purchaseItem) {
        return purchaseItemService.create(purchaseItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody PurchaseItem purchaseItem) {
        return purchaseItemService.update(id, purchaseItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return purchaseItemService.delete(id);
    }
}
