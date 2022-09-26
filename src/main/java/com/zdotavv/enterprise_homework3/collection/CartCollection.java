package com.zdotavv.enterprise_homework3.collection;

import com.zdotavv.enterprise_homework3.model.Cart;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class CartCollection {
    private final Map<Integer, Cart> carts = new HashMap<>();
}
