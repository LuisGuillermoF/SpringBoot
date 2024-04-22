package com.riwi.products.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.products.entity.Product;

@Repository
public interface ProductRepositorie extends JpaRepository<Product,Long>{
    public List<Product> findByName(String name);
}
