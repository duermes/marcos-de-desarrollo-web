package com.mddw.readers.THE_READERS.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column(nullable = false)
    private String name;

    @Getter
    @Setter
    @OneToMany(mappedBy = "publisher")
    @JsonBackReference
    private List<Book> books;

    public Publisher() {
    }

    public Publisher(Integer id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }
}