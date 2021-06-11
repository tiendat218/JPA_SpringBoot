package com.example.restcontroller.service;

import com.example.restcontroller.jpa.Product;
import com.example.restcontroller.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    /*@Autowired
    ProductRepository productRepository; */

    private  final ProductRepository productRepository;

    public List<Product> fillAllProduct(){
        return productRepository.findAll();
    }
    public Optional<Product> findById(Integer id){
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    public void deleteProductById(Integer id){
        productRepository.deleteById(id);
    }
}
