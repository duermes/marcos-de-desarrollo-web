package com.mddw.readers.THE_READERS.controller;


import com.mddw.readers.THE_READERS.model.Book;
import com.mddw.readers.THE_READERS.model.Category;
import com.mddw.readers.THE_READERS.model.Publisher;
import com.mddw.readers.THE_READERS.repository.BookRepository;
import com.mddw.readers.THE_READERS.repository.CategoryRepository;
import com.mddw.readers.THE_READERS.repository.PublisherRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final PublisherRepository publisherRepository;

    public AdminController(BookRepository bookRepository, CategoryRepository categoryRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.publisherRepository = publisherRepository;
    }

    @GetMapping("/books")
    public String adminBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("publishers", publisherRepository.findAll());
        return "admin/books";
    }

    @PostMapping("/books")
    public String addBook(@ModelAttribute Book book,
                          @RequestParam("category.id") Integer categoryId,
                          @RequestParam("publisher.id") Integer publisherId,
                          BindingResult result,
                          RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Error al agregar el libro. Por favor, verifica los datos.");
            return "redirect:/admin/books";
        }

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Categoría inválida"));
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new IllegalArgumentException("Editorial inválida"));

        book.setCategory(category);
        book.setPublisher(publisher);

        bookRepository.save(book);
        redirectAttributes.addFlashAttribute("success", "Libro agregado exitosamente.");
        return "redirect:/admin/books";
    }

    @PostMapping("/books/edit/{id}")
    public String updateBook(@PathVariable Integer id,
                             @ModelAttribute Book book,
                             @RequestParam("category.id") Integer categoryId,
                             @RequestParam("publisher.id") Integer publisherId,
                             BindingResult result,
                             RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar el libro. Por favor, verifica los datos.");
            return "redirect:/admin/books";
        }

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Categoría inválida"));
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new IllegalArgumentException("Editorial inválida"));

        book.setId(id);
        book.setCategory(category);
        book.setPublisher(publisher);

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

    @GetMapping("/books/{id}")
    @ResponseBody
    public ResponseEntity<Book> getBook(@PathVariable Integer id) {
        try {
            System.out.println("Recibida solicitud para el libro ID: " + id);

            Book book = bookRepository.findById(id)
                    .orElseThrow(() -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "No se encontró el libro con ID: " + id
                    ));

            System.out.println("Libro encontrado: " + book);
            System.out.println("Categoría: " + book.getCategory());
            System.out.println("Editorial: " + book.getPublisher());

            return ResponseEntity.ok(book);

        } catch (Exception e) {
            System.err.println("Error al buscar el libro: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
