package com.riwi.products.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(this.objIProductService.getAll());
    }

    @PostMapping
    public ResponseEntity<Product> agregarProducto(@RequestBody Product objProduct){       
        return ResponseEntity.ok(this.objIProductService.save(objProduct));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id){
        return ResponseEntity.ok(this.objIProductService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarproducto(@PathVariable Long id){
        Product obProduct = objIProductService.getById(id);
        this.objIProductService.delete(obProduct.getId());
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> delete(@PathVariable Long id){
    //     this.objIProductService.delete(id);

    //     return ResponseEntity.noContent().build();
    // }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@RequestBody Product objProduct,@PathVariable Long id){
        objProduct.setId(id);
        return ResponseEntity.ok(this.objIProductService.update(objProduct));
    }
}

