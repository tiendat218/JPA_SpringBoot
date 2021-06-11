package com.example.emi_application.repository;

import com.example.emi_application.model.Emi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmiRepository extends JpaRepository<Emi, Long> {
    @Query("SELECT p FROM Emi p WHERE cust_id=?1")
    List<Emi> getEmiByCust(Long cust_id);
}
