package com.mddw.readers.THE_READERS.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;


@Entity
@Table(name = "books")
public class Book {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(nullable = false)
        private String name;

        @Column(length = 1000)
        private String description;

        @Column(nullable = false)
        private String image;

        private Integer price;

        public Book() {
        }

        public Book(Integer id, String name, String description, String image, Integer price) {
                this.id = id;
                this.name = name;
                this.description = description;
                this.image = image;
                this.price = price;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getImage() {
                return image;
        }

        public void setImage(String image) {
                this.image = image;
        }

        public Integer getPrice() {
                return price;
        }

        public void setPrice(Integer price) {
                this.price = price;
        }
}