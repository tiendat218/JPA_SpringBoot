package com.example.japmanytomanyprimarykey.model;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor

public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Publisher(String name) {
        this.name = name;
    }

}
