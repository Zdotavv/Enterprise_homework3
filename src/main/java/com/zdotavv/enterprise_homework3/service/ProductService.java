package com.zdotavv.enterprise_homework3.service;

import com.zdotavv.enterprise_homework3.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework3.model.Product;

import java.util.Collection;

public interface ProductService {
    Product createProduct(Product product);

    Product updateProduct(Integer idProduct, Product product) throws NotFoundException;

    void deleteProduct(Integer idProduct) throws NotFoundException;

    Product getById(Integer id) throws NotFoundException;;

    Collection<Product> getAllProducts();

}
