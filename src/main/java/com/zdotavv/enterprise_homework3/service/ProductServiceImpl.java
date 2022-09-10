package com.zdotavv.enterprise_homework3.service;

import com.zdotavv.enterprise_homework3.collection.ProductCollection;
import com.zdotavv.enterprise_homework3.model.Product;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {
    private static Integer PRODUCT_COUNT = 0;
    @Override
    public Product createProduct(Product product) {
        product.setId(++PRODUCT_COUNT);
        ProductCollection.products.add(product);
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        Product newProduct = new Product();
        for (Product tmp : ProductCollection.products) {
            if (tmp.getId().equals(product.getId())) {
                tmp.setPrice(product.getPrice());
                tmp.setName(product.getName());
                newProduct = tmp;
            }
        }
        return newProduct;
    }

    @Override
    public void deleteProduct(Product product) {
        ProductCollection.products.removeIf(tmp -> tmp.getId().equals(product.getId()));
    }

    @Override
    public Product getById(Integer id) {
        Product product = new Product();
        for (Product tmp : ProductCollection.products) {
            if (tmp.getId().equals(id)) {
                product = tmp;
            }
        }
        return product;
    }

    @Override
    public Set<Product> getAll() {
        return ProductCollection.products;
    }


}
