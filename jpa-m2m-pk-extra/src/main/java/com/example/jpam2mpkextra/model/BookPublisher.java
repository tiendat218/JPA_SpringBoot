package com.example.jpam2mpkextra.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Book_Publisher")
public class BookPublisher {

//    @Id
//    private Integer id;

    @EmbeddedId
    private BookPublisherId id;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @MapsId("publisherId")
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Column(name = "published_date")
    private Date publishDate;


    public BookPublisher(Book book, Publisher publisher, Date publishDate) {
        this.id = new BookPublisherId(book.getId(),publisher.getId());
        this.book = book;
        this.publisher = publisher;
        this.publishDate = publishDate;
    }
}
