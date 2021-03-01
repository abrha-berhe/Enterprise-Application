/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.edu.abrha.HW04_queryAndLocking;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Mabshura
 */
@Entity
public class Book_4 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int pageNumber;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private Author_4 Author;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    private Publisher_4 publisher;

    public Author_4 getAuthor() {
        return Author;
    }

    public Book_4() {
    }

    public Book_4(String title, int pageNumber, Author_4 Author, Publisher_4 publisher) {
        this.title = title;
        this.pageNumber = pageNumber;
        this.Author = Author;
        this.publisher = publisher;
    }

    
    public void setAuthor(Author_4 Author) {
        this.Author = Author;
    }

    public Publisher_4 getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher_4 publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book_4)) {
            return false;
        }
        Book_4 other = (Book_4) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "miu.edu.abrha.queryAndLocking.Book_4[ id=" + id + " ]";
    }

}
