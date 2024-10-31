package com.mddw.readers.THE_READERS.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "categories")
public class Category {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @Getter
    @Column(nullable = false)
    private String name;

    @Getter
    @Setter
    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Book> books;

    public Category() {
    }
    public Category(Integer id, List<Book> books) {
        this.id = id;
        this.books = books;
    }

}