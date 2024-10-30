package com.mddw.readers.THE_READERS.controller;

import com.mddw.readers.THE_READERS.repository.BookRepository;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class LibraryController {

    private BookRepository bookRepository;

    public LibraryController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/libros-infantiles")
    public String catalog(Model model) {
        model.addAttribute("title", "Libros Infantiles");
        model.addAttribute("books", bookRepository.findAll());
        return "library/libros-infantiles";
    }
}