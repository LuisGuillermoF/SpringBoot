package com.riwi.products.services.abtract_service;

import java.util.List;

import com.riwi.products.entity.Product;

public interface IProductService {
    public List<Product> getAll();

    public Product save(Product objProduct);

    public Product getById(Long id);

    public Boolean delete(Long Id);
    
    public Product update(Product objProduct);
}
