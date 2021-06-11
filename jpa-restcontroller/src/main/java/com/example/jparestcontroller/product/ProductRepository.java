package com.example.jparestcontroller.product;

import com.example.jparestcontroller.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
