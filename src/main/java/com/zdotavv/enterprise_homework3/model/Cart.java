package com.zdotavv.enterprise_homework3.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Cart {
    private Integer idCart;
    private BigDecimal sum = new BigDecimal("0.0");
    private final List<Product> products = new ArrayList<>();
    private Person person;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return getIdCart().equals(cart.getIdCart());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCart());
    }
}
