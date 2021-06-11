package com.example.japmanytomanyprimarykey.model;

import lombok.*;


import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class BookPublisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    private Date publishDate;

    public BookPublisher(Book book, Publisher publisher, Date publishDate) {
        this.book = book;
        this.publisher=publisher;
        this.publishDate=publishDate;
    }

}
