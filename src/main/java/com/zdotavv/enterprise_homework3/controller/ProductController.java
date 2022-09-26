package com.zdotavv.enterprise_homework3.controller;

import com.zdotavv.enterprise_homework3.exceptions.NotFoundException;
import com.zdotavv.enterprise_homework3.model.Product;
import com.zdotavv.enterprise_homework3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping(path="/product")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@RequestParam Integer idProduct) throws NotFoundException {
        return productService.getById(idProduct);
    }

    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@RequestParam Integer idProduct, @RequestBody Product product) throws NotFoundException {
        return productService.updateProduct(idProduct, product);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@RequestParam Integer idProduct) throws NotFoundException {
        productService.deleteProduct(idProduct);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Product> getAll() {
        return productService.getAllProducts();
    }
}
