package miu.edu.abrha.springBoot_Thymleaf.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private float experience;

    @OneToOne(cascade=CascadeType.ALL,fetch= FetchType.EAGER)
    private Address address;


    @OneToMany(cascade=CascadeType.ALL,fetch= FetchType.EAGER)
    private List<Book> books;

}
