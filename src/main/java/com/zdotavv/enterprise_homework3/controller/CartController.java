package com.zdotavv.enterprise_homework3.controller;

import com.zdotavv.enterprise_homework3.model.Cart;
import com.zdotavv.enterprise_homework3.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping(path="/cart")
@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/create")
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Cart updateCart(@RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCart(@RequestBody Cart cart) {
        cartService.deleteCart(cart);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cart findById(@PathVariable Integer id) {
        return cartService.getById(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Set<Cart> getAll() {
        return cartService.getAll();
    }

    @PutMapping("/{id}/add/{idProduct}")
    @ResponseStatus(HttpStatus.OK)
    public Cart addProduct(@PathVariable Integer id, @PathVariable Integer idProduct) {
        return cartService.addProductToCart(id, idProduct);
    }

    @DeleteMapping("/{id}/delete/{idProduct}")
    @ResponseStatus(HttpStatus.OK)
    public Cart deleteProduct(@PathVariable Integer id, @PathVariable Integer idProduct) {
        return cartService.deleteProductFromCart(id, idProduct);
    }

    @GetMapping("/price/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Double getPriceFromCart(@PathVariable int id) {
        return cartService.getPriceInCard(id);
    }
}

