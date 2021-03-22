package miu.edu.abrha.springBoot_Thymleaf.service;

import miu.edu.abrha.springBoot_Thymleaf.dao.AuthorDao;
import miu.edu.abrha.springBoot_Thymleaf.dao.BookDao;
import miu.edu.abrha.springBoot_Thymleaf.model.Author;
import miu.edu.abrha.springBoot_Thymleaf.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public ResponseEntity<Book> addBook(Book book) {
        bookDao.save(book);
        return ResponseEntity.status(200).build();
    }

    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    public Book getOneBook(Long id) {
        return bookDao.findById(id).get();
    }

    public ResponseEntity<Book> updateBook(Book book) {
        bookDao.save(book);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity<Book> deleteBook(Long id) {
        bookDao.deleteById(id);
        return ResponseEntity.status(201).build();
    }
}
