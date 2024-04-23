package com.riwi.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.products.entity.Product;
import com.riwi.products.repositories.ProductRepositorie;
import com.riwi.products.services.abtract_service.IProductService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServicie  implements IProductService {

    @Autowired
    private final ProductRepositorie objProductRepositorie;
    
    @Override
    public List<Product> getAll() {
        return this.objProductRepositorie.findAll();
    }

    @Override
    public Product save(Product objProduct) {
        return this.objProductRepositorie.save(objProduct);
    }

    @Override
    public Product getById(Long id) {
        return this.objProductRepositorie.findById(id).orElseThrow();
    }

    @Override
    public Boolean delete(Long Id) {
        Product obProduct = this.objProductRepositorie.findById(Id).orElse(null);
        if (obProduct != null) {
            this.objProductRepositorie.delete(obProduct);
            return true;
        }
        return false;
    }

    @Override
    public Product update(Product objProduct) {
        return this.objProductRepositorie.save(objProduct);
    }
    
}
