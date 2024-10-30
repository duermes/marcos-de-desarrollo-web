package com.mddw.readers.THE_READERS.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Book(Integer id, @NotBlank
        @NotEmpty
        String name, String description, String image, @Positive
        Integer price) {

}