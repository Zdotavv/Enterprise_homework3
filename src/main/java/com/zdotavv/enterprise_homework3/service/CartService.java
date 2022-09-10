package com.zdotavv.enterprise_homework3.service;

import com.zdotavv.enterprise_homework3.model.Cart;

import java.util.List;
import java.util.Set;

public interface CartService {
    Cart createCart(Cart cart);

    Cart updateCart(Cart cart);

    void deleteCart(Cart cart);

    Cart getById(Integer id);

    Set<Cart> getAll();

    Cart addProductToCart(Integer id, Integer idProduct);

    Cart deleteProductFromCart(Integer id, Integer idProduct);

    Double getPriceInCard(Integer id);
}
