package com.zdotavv.enterprise_homework3.service;

import com.zdotavv.enterprise_homework3.collection.CartCollection;
import com.zdotavv.enterprise_homework3.collection.ProductCollection;
import com.zdotavv.enterprise_homework3.model.Cart;
import com.zdotavv.enterprise_homework3.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class CartServiceImpl implements CartService{
    @Override
    public Cart createCart(Cart cart) {
        CartCollection.carts.add(cart);
        return cart;
    }

    @Override
    public Cart updateCart(Cart cart) {
        Cart newCart = new Cart();
        for (Cart tmp : CartCollection.carts) {
            if (tmp.getId().equals(cart.getId())) {
                tmp.setSum(cart.getSum());
                newCart = tmp;
            } else {
                System.err.println("Cannot find cart for update");
            }
        }
        return newCart;
    }

    @Override
    public void deleteCart(Cart cart) {
        CartCollection.carts.removeIf(tmp -> tmp.getId().equals(cart.getId()));
    }

    @Override
    public Cart getById(Integer id) {
        Cart cart = new Cart();
        for (Cart tmp : CartCollection.carts) {
            if (tmp.getId() == id) {
                cart = tmp;
            } else {
                System.err.println("Cannot find cart id");
            }
        }
        return cart;
    }

    @Override
    public Set<Cart> getAll() {
        return CartCollection.carts;
    }

    @Override
    public Cart addProductToCart(Integer id, Integer idProduct) {
        Cart cart = new Cart();
        for (Cart tmp : CartCollection.carts) {
            if (id == tmp.getId()) {
                for (Product tmpProduct : ProductCollection.products) {
                    if (idProduct == tmpProduct.getId()) {
                        double sum = tmp.getSum() + tmpProduct.getPrice();
                        tmp.setSum(sum);
                        cart = tmp;
                    }
                }
            }
        }
        return cart;
    }

    @Override
    public Cart deleteProductFromCart(Integer id, Integer idProduct) {
        Cart cart = new Cart();
        for (Cart tmp : CartCollection.carts) {
            if (id == tmp.getId()) {
                for (Product tmpProduct : ProductCollection.products) {
                    if (idProduct == tmpProduct.getId()) {
                        double sum = tmp.getSum() - tmpProduct.getPrice();
                        tmp.setSum(sum);
                        cart = tmp;
                    }
                }
            }
        }
        return cart;
    }

    @Override
    public Double getPriceInCard(Integer id) {
        double sum = 0.0;
        for (Cart tmp : CartCollection.carts) {
            if (tmp.getId() == id) {
                sum = tmp.getSum();
            }
        }
        return sum;
    }
}
