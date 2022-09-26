package com.zdotavv.enterprise_homework3.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Product {
    private Integer idProduct;
    private String name;
    private double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getIdProduct().equals(product.getIdProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProduct());
    }
}
