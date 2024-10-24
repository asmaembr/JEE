package ma.sigma.rest.service;

import ma.sigma.rest.model.Product;

import java.util.List;

public interface IProductService {
    Product getById(Long id);
    List<Product> getAll();
    void create(Product product);
    void update(Long id, Product product);
    void delete(Long id);}

