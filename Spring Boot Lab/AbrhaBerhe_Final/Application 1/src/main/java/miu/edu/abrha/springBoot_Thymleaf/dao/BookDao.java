package miu.edu.abrha.springBoot_Thymleaf.dao;

import miu.edu.abrha.springBoot_Thymleaf.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Long> {
}
