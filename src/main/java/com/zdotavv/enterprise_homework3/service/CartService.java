package com.zdotavv.enterprise_homework3.service;

import com.zdotavv.enterprise_homework3.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework3.model.Cart;

import java.util.List;

public interface CartService {
    Cart createCartByPersonId(Integer id) throws NotFoundException;

    Cart addProductByProductIdAndCartId(Integer productId, Integer idCart) throws NotFoundException;

    Cart removeProductByProductIdAndCartId(Integer productId, Integer idCart) throws NotFoundException;

    void removeAllProductsFromCartById(Integer idCart) throws NotFoundException;

    List<Cart> getAllByPersonId(Integer id) throws NotFoundException;

    Cart getCartById(Integer id) throws NotFoundException;

    void removeCartById(Integer id) throws NotFoundException;
}
