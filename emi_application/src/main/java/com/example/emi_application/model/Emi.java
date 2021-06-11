package com.example.emi_application.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Emi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long emi_id;
    private String employeeName;
    private double loan_amount;
    private double rate_of_interest;
    private double team_of_the_loan;
    private double emi_total;
    private String status;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    private Date timeEnd;
    @ManyToOne
    @JoinColumn(name = "cust_id", referencedColumnName = "cust_id")
    private Customer customer;


}
