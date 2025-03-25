package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductReposiotry;

@Service
public class ProductService {
    private final ProductReposiotry productReposiotry;

    public ProductService(ProductReposiotry productReposiotry) {
        this.productReposiotry = productReposiotry;
    }

    // save 1
    public void saveProduct(Product product) {
        this.productReposiotry.save(product);
    }

    // get all
    public List<Product> getAllPr() {
        return this.productReposiotry.findAll();
    }
}
