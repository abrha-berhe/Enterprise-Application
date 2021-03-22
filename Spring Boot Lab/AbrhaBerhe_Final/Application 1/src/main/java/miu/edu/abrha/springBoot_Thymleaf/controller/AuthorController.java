package miu.edu.abrha.springBoot_Thymleaf.controller;


import miu.edu.abrha.springBoot_Thymleaf.model.Address;
import miu.edu.abrha.springBoot_Thymleaf.model.Author;
import miu.edu.abrha.springBoot_Thymleaf.model.Book;
import miu.edu.abrha.springBoot_Thymleaf.model.Employee;
import miu.edu.abrha.springBoot_Thymleaf.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/author")
@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("/")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping("/")

    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
//        Address address = new AddressController().getOneAddress(1L);
//        List<Book> books = Arrays.asList(
//                new BookController().getOneBook(1L),
//                new BookController().getOneBook(2L));
//
        return ResponseEntity.ok(author);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getOneAuthor(@PathVariable Long id) {
        Author author = authorService.getOneAuthor(id);
        if (author == null)
            return ResponseEntity.status(404).build();
        return ResponseEntity.ok(author);
    }

    @GetMapping("/{id}/address")
    public ResponseEntity<Address> getAuthorAddress(@PathVariable Long id) {
        Author author = authorService.getOneAuthor(id);
        if (author == null)
            return ResponseEntity.status(404).build();
        return ResponseEntity.ok(author.getAddress());
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<List<Book>> getAuthorBooks(@PathVariable Long id) {
        Author author = authorService.getOneAuthor(id);
        if (author == null)
            return ResponseEntity.status(404).build();
        return ResponseEntity.ok(author.getBooks());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Author> deleteAuthor(@PathVariable Long id) {
        Author author = authorService.getOneAuthor(id);
        if (author == null)
            return ResponseEntity.status(404).build();
        return authorService.deleteAuthor(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author author, @PathVariable Long id) {
        Author existingAuthor = authorService.getOneAuthor(id);
        if (existingAuthor == null)
            return authorService.addAuthor(author);
        Author convertedAuthor = convertAuthor(existingAuthor, author);
        return authorService.addAuthor(convertedAuthor);
    }

    private Author convertAuthor(Author existingAuthor, Author newAuthor) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.map(newAuthor, existingAuthor);
        return existingAuthor;
    }
}

