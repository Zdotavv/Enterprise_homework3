package com.zdotavv.enterprise_homework3.service;

import com.zdotavv.enterprise_homework3.collection.ProductCollection;
import com.zdotavv.enterprise_homework3.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework3.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductServiceImpl implements ProductService {
    private static Integer productCounter = 0;
    private final ProductCollection productCollection;

    public ProductServiceImpl(ProductCollection productCollection) {
        this.productCollection = productCollection;
    }
    @Override
    public Product createProduct(Product product) {
        product.setIdProduct(++productCounter);
        productCollection.getProducts().put(product.getIdProduct(), product);
        return product;
    }

    @Override
    public Product updateProduct(Integer idProduct, Product product)throws NotFoundException {
        if (productCollection.getProducts().containsKey(idProduct)) {
            Product tmp = productCollection.getProducts().get(idProduct);
            tmp.setName(product.getName());
            tmp.setPrice(product.getPrice());
            return tmp;
        } else {
            throw new NotFoundException("Person with ID #" + idProduct + " is not found");
        }
    }

    @Override
    public void deleteProduct(Integer idProduct) throws NotFoundException {
        if (productCollection.getProducts().containsKey(idProduct)) {
            productCollection.getProducts().remove(idProduct);
        } else {
            throw new NotFoundException("Product with ID #" + idProduct + " is not found");
        }
    }

    @Override
    public Product getById(Integer idProduct)throws NotFoundException  {
        if (productCollection.getProducts().containsKey(idProduct)) {
            return productCollection.getProducts().get(idProduct);
        } else {
            throw new NotFoundException("Product with ID #" + idProduct + " is not found");
        }
    }

    @Override
    public Collection<Product> getAllProducts() {
        return productCollection.getProducts().values();
    }


}
