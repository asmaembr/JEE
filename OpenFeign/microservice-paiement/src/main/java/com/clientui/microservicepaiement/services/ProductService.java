package com.clientui.microservicepaiement.services;

import com.clientui.microserviceproduits.models.Product;
import com.clientui.microserviceproduits.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }
    public Product save(Product product) {
      return  productRepository.save(product);
    }
}
