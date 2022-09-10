package com.zdotavv.enterprise_homework3.controller;

import com.zdotavv.enterprise_homework3.model.Product;
import com.zdotavv.enterprise_homework3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping(path="/product")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete")
    public void deleteProduct(@RequestBody Product product) {
        productService.deleteProduct(product);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @GetMapping("/all")
    public Set<Product> getAll() {
        return productService.getAll();
    }
}
