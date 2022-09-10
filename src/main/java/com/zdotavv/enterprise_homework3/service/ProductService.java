package com.zdotavv.enterprise_homework3.service;

import com.zdotavv.enterprise_homework3.model.Product;

import java.util.Set;

public interface ProductService {
    Product createProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Product product);

    Product getById(Integer id);

    Set<Product> getAll();

}
