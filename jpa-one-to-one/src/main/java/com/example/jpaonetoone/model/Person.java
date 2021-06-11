package com.example.jpaonetoone.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "id_card_id")
    private  CCCD   idCard;
    public Person(String name, CCCD idCard) {
        this.name = name;
        this.idCard = idCard;
    }
}
