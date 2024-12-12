package com.clientui.microservicecommandes.controllers;

import com.clientui.microserviceproduits.models.Product;
import com.clientui.microserviceproduits.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> Products() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product Products(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }
}
