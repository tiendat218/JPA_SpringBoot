package com.example.restcontroller.api;

import com.example.restcontroller.jpa.Product;
import com.example.restcontroller.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductAPI {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> fillAll(){
        return ResponseEntity.ok(productService.fillAllProduct());
    }

    @PostMapping
    public ResponseEntity createProduct(@Valid @RequestBody Product product){
        return ResponseEntity.ok(productService.saveProduct(product));
}
    @GetMapping("/id")
    public ResponseEntity<Product> findById(@PathVariable Integer id){
        Optional<Product> product = productService.findById(id);
        if(!product.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(product.get());
    }

    @PutMapping
    public ResponseEntity update(@PathVariable Integer id, @Valid @RequestBody Product newProduct){
        Optional<Product> product = productService.findById(id);
        if(!product.isPresent()){
            ResponseEntity.badRequest().build();
        }
        productService.saveProduct(newProduct);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity delete(@PathVariable Integer id){
        Optional<Product> product = productService.findById(id);
        if(!product.isPresent()){
            ResponseEntity.badRequest().build();
        }
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }

}
