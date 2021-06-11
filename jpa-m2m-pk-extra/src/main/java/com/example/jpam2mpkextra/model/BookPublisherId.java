package com.example.jpam2mpkextra.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class BookPublisherId implements Serializable {
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "publisher_id")
    private Integer publisherId;
}
