package com.mddw.readers.THE_READERS.controller;


import com.mddw.readers.THE_READERS.model.Book;
import com.mddw.readers.THE_READERS.repository.BookRepository;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    private final BookRepository bookRepository;

    public AdminController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public String adminBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "admin/books";
    }

    @PostMapping("/books")
    public String addBook(@ModelAttribute @Valid Book book, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Error al agregar el libro. Por favor, verifica los datos.");
            return "redirect:/admin/books";
        }
        bookRepository.save(book);
        redirectAttributes.addFlashAttribute("success", "Libro agregado exitosamente.");
        return "redirect:/admin/books";
    }

    @PostMapping("/books/edit/{id}")
    public String updateBook(@PathVariable Integer id, @ModelAttribute @Valid Book book, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar el libro. Por favor, verifica los datos.");
            return "redirect:/admin/books";
        }
        book.setId(id);
        bookRepository.save(book);
        redirectAttributes.addFlashAttribute("success", "Libro actualizado exitosamente.");
        return "redirect:/admin/books";
    }

    @PostMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        bookRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Libro eliminado exitosamente.");
        return "redirect:/admin/books";
    }
}
