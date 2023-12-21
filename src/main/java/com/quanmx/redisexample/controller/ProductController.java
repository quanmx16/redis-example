package com.quanmx.redisexample.controller;

import com.quanmx.redisexample.entity.Product;
import com.quanmx.redisexample.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/products")
    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/products")
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    @Cacheable(key = "#id", value = "Product")
    public Product getById(@PathVariable("id") int id) {
        return productRepository.findProductById(id);
    }

    @DeleteMapping("/products/{id}")
    public String deleteById(@PathVariable("id") int id) {
        return productRepository.deleteProduct(id);
    }
}
