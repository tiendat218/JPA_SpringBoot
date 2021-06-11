package com.example.japmanytomanyprimarykey.model;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Book(String name) {
        this.name = name;
    }

}
