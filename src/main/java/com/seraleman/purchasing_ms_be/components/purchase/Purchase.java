package com.seraleman.purchasing_ms_be.components.purchase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.seraleman.purchasing_ms_be.components.purchaseItems.PurchaseItem;
import com.seraleman.purchasing_ms_be.components.suplier.Suplier;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "purchases")
public class Purchase {

    @Id
    private String id;

    private Date date;

    @DBRef
    private Suplier suplier;

    @DBRef
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
