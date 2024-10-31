package com.mddw.readers.THE_READERS.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;


@Entity
@Table(name = "books")
public record Book(@Id @GeneratedValue(strategy = GenerationType.AUTO) Integer id, @NotBlank
        @NotEmpty
        @NotEmpty String name, String description, @NotEmpty String image, @Positive
        Integer price) {

}