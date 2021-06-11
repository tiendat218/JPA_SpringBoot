package com.example.jpaonetoone.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class CCCD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)// khong cho rỗng
    private String Code = UUID.randomUUID().toString();// sinh ra code ngẫu nhiên
    @OneToOne(mappedBy = "idCard")
    private Person person;
}

