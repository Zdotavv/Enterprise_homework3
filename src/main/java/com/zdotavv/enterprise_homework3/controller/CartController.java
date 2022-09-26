package com.zdotavv.enterprise_homework3.controller;

import com.zdotavv.enterprise_homework3.dto.CartDto;
import com.zdotavv.enterprise_homework3.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework3.model.Cart;
import com.zdotavv.enterprise_homework3.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/cart")
@RestController
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @PostMapping("/create")
    public Cart createCart(@RequestParam Integer id)throws NotFoundException {
        return cartService.createCartByPersonId(id);
    }

    @PutMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public Cart addProductByProductIdAndCartId(@RequestBody CartDto cartDto) throws NotFoundException {
        return cartService.addProductByProductIdAndCartId(cartDto.getIdProduct(), cartDto.getIdCart());
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Cart removeProductByProductIdAndCartId(@RequestBody CartDto cartDto) throws NotFoundException {
        return cartService.removeProductByProductIdAndCartId(cartDto.getIdProduct(), cartDto.getIdCart());
    }
    @DeleteMapping("/{cartId}/clean")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllProductsFromCartById(@PathVariable Integer cartId) throws NotFoundException {
        cartService.removeAllProductsFromCartById(cartId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Cart> getAllByPersonId(@RequestParam Integer id) throws NotFoundException {
        return cartService.getAllByPersonId(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Cart getCartById(@RequestParam Integer idCart) throws NotFoundException {
        return cartService.getCartById(idCart);
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeCartById(@RequestParam Integer idCart) throws NotFoundException {
        cartService.removeCartById(idCart);
    }
}

