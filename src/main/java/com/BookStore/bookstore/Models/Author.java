package com.BookStore.bookstore.Models;
import javax.persistence.*;
@Entity
@Table(name = "authors")
public class Author {
    @Id()
    @SequenceGenerator(
            name = "id_generator",
            sequenceName = "id_generator",
            allocationSize = 1,
            initialValue = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "id_generator"
    )
    @Column(name="id")
    Integer authorId;
    String name;
    String booksId;

    public Author(){}

    public Author(Integer authorId, String name, String booksId) {
        this.authorId = authorId;
        this.name = name;
        this.booksId = booksId;
    }

    public Author(String name, String booksId) {
        this.name = name;
        this.booksId = booksId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBooksId() {
        return booksId;
    }

    public void setBooksId(String booksId) {
        this.booksId = booksId;
    }
}
