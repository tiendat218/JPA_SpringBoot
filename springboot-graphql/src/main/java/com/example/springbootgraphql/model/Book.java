package com.example.springbootgraphql.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    private String isn;
    private String  title;
    private String publisher;
    private String[] author;
    private String publishedDate;
}
