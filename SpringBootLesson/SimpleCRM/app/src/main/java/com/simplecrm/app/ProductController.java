package com.simplecrm.app;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/products")
public class ProductController {
    private ArrayList<Product> products = new ArrayList<>();

    public ProductController() {
        products.add(new Product("Shorts", "It's short.", 3.99));
        products.add(new Product("Hat", "Stylish and hatty.", 10.50));
        products.add(new Product("Soul", "Wait, whose soul is this?", 9999));
    }

    @GetMapping("")
    public ResponseEntity<ArrayList<Product>> getProducts() {
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable String id){
        try {
        int index = getProductIndex(id);
        Product product = products.get(index);
        return new ResponseEntity<>(product, HttpStatus.OK);
        } catch(ProductNotFoundException e) {
            throw new ProductNotFoundException(id);
        }
    }
    @PostMapping("")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        products.add(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
        try {
            int index = getProductIndex(id);
            products.set(index, product);
            return new ResponseEntity<>(product, HttpStatus.NO_CONTENT);
        } catch(ProductNotFoundException e) {
            throw new ProductNotFoundException(id);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deletProduct(@PathVariable String id) {
        try {
            int index = getProductIndex(id);
            return new ResponseEntity<>(products.remove(index), HttpStatus.NO_CONTENT);
        } catch(ProductNotFoundException e) {
            throw new ProductNotFoundException(id);
        }
    }

    private int getProductIndex(String id) {
        for(Product product: products) {
            if(product.getId().equals(id)){
                return products.indexOf(product);
            }
        }
        throw new CustomerNotFoundException(id);
    }
    
}
