package com.seraleman.purchasing_ms_be.components.purchase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.seraleman.purchasing_ms_be.components.suplier.Suplier;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "purchases")
public class Purchase {

    @Id
    private String id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;

    @DBRef
    private Suplier suplier;

    private List<PurchaseItem> items;

    public Purchase() {
        this.items = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Suplier getSuplier() {
        return suplier;
    }

    public void setSuplier(Suplier suplier) {
        this.suplier = suplier;
    }

    public List<PurchaseItem> getItems() {
        return items;
    }

    public void setItems(List<PurchaseItem> items) {
        this.items = items;
    }

    public Integer getTotalPurchaseCost() {

        Integer totalPurchaseCost = 0;
        for (PurchaseItem item : items) {
            totalPurchaseCost += item.getTotalItemCost();
        }
        return totalPurchaseCost;
    }
}
