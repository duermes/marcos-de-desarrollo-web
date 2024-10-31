package com.mddw.readers.THE_READERS.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "books")
public class Book {
        @Setter
        @Getter
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Setter
        @Getter
        @Column(nullable = false)
        private String name;

        @Getter
        @Column(length = 1000)
        private String description;

        @Setter
        @Getter
        @Column(nullable = false)
        private String image;

        @Getter
        private Integer price;

        @Getter
        @Setter
        @ManyToOne
        @JoinColumn(name = "category_id")
        @JsonBackReference
        private Category category;

        @Getter
        @Setter
        @ManyToOne
        @JoinColumn(name = "publisher_id")
        @JsonBackReference
        private Publisher publisher;

        public Book() {
        }

        public Book(Integer id, String name, String description, String image, Integer price, Category category, Publisher publisher) {
                this.id = id;
                this.name = name;
                this.description = description;
                this.image = image;
                this.price = price;
                this.category = category;
                this.publisher = publisher;
        }

        public void setDescription(String description) {
                this.description = description;
        }

    public void setPrice(Integer price) {
                this.price = price;
        }
}