package com.BookStore.bookstore.Repositories;

import com.BookStore.bookstore.Models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository
        extends JpaRepository<Book, String> {
    @Query(value = "SELECT * FROM books WHERE position(?1 in LOWER(title))>0", nativeQuery = true)
    Page<Book> findBooksByName(@Param("book") String bookName, Pageable pageable);
}
