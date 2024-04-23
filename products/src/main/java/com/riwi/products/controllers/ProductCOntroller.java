package com.riwi.products.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.products.entity.Product;
import com.riwi.products.services.abtract_service.IProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductCOntroller {

    @Autowired
    private final IProductService objIProductService;

    @GetMapping("/lista")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(this.objIProductService.getAll());
    }

    @PostMapping("/agregar")
    public ResponseEntity<Product> agregarProducto(@RequestBody Product objProduct){       
        return ResponseEntity.ok(this.objIProductService.save(objProduct));
    }
}
