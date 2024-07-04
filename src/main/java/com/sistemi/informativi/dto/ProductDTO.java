package com.sistemi.informativi.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {

    private String name;

    private float price;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductDTO(String name, float price) {
        this.name = name;
        this.price = price;
    }
}
