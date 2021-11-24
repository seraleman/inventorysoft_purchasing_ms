package com.seraleman.purchasing_ms_be.components.suplier;

import com.seraleman.purchasing_ms_be.components.suplier.dao.services.ISuplierService;

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
@RequestMapping("/ms/api/supliers")
public class SuplierRestController {

    @Autowired
    private ISuplierService suplierService;

    @GetMapping("/")
    public ResponseEntity<?> list() {
        return suplierService.list();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable String id) {
        return suplierService.show(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody Suplier suplier) {
        return suplierService.create(suplier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Suplier suplier) {
        return suplierService.update(id, suplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return suplierService.delete(id);
    }
}
