package com.zdotavv.enterprise_homework3.collection;

import com.zdotavv.enterprise_homework3.model.Product;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
@Getter
public class ProductCollection {
    private final Map<Integer, Product> products = new HashMap<>();
}
