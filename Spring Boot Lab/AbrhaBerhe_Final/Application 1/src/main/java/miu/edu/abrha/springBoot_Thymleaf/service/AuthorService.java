package miu.edu.abrha.springBoot_Thymleaf.service;

import miu.edu.abrha.springBoot_Thymleaf.dao.AuthorDao;
import miu.edu.abrha.springBoot_Thymleaf.dao.EmployeeDao;
import miu.edu.abrha.springBoot_Thymleaf.model.Address;
import miu.edu.abrha.springBoot_Thymleaf.model.Author;
import miu.edu.abrha.springBoot_Thymleaf.model.Book;
import miu.edu.abrha.springBoot_Thymleaf.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorDao authorDao;

    public ResponseEntity<Author> addAuthor(Author author) {
//        Address address = new Address( "Fairfield", "Iowa");
//        List<Book> books = Arrays.asList(
//                new Book("Title 1", 110),
//                new Book( "Title 2", 120),
//                new Book( "Title 3", 130)
//        );
//        author.setAddress(address);
//        author.setBooks(books);
        authorDao.save(author);
        return ResponseEntity.status(200).build();
    }

    public List<Author> getAllAuthors() {
        return authorDao.findAll();
    }

    public Author getOneAuthor(Long id) {
        return authorDao.findById(id).orElse(null);
    }

    public ResponseEntity<Author> updateAuthor(Author author) {
        authorDao.save(author);
        return ResponseEntity.status(201).build();
    }

    public ResponseEntity<Author> deleteAuthor(Long id) {
        authorDao.deleteById(id);
        return ResponseEntity.status(201).build();
    }
}
