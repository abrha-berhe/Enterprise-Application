package miu.edu.abrha.springBoot_Thymleaf.controller;

import miu.edu.abrha.springBoot_Thymleaf.model.Address;
 import miu.edu.abrha.springBoot_Thymleaf.model.Book;
 import miu.edu.abrha.springBoot_Thymleaf.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/")
    public ResponseEntity<Book> addBooks(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/{id}")
    public Book getOneBook(@PathVariable Long id) {
        Book auth = bookService.getOneBook(id);
        return auth;
    }
}
