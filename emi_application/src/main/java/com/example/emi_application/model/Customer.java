package com.example.emi_application.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cust_id;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String identification;
    private double amount;
    @CreationTimestamp
    private Date createdAt;
    @OneToMany(mappedBy = "customer")
    private Set<Emi> emis;
}
