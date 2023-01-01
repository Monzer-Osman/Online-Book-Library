package com.BookStore.bookstore.Services;

import com.BookStore.bookstore.Models.Book;
import com.BookStore.bookstore.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }

    public Page<Book> searchResultPaginated(String bookName, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        if(bookName == null)
            bookName = "";
        return bookRepository.findBooksByName(bookName.toLowerCase(), pageable);
    }

    public Page<Book> findPaginated(int pageNumber, int pageSize){
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return bookRepository.findAll(pageable);
    }

    public void updateBooks(){
        List<Book> books = bookRepository.findAll();
        for(Book book: books) {
            if (book.getDescription().length() > 2){
                book.setDescription(book.getDescription().substring(2));
           }
        }
        bookRepository.saveAll(books);
    }

    public Book getBookById(String bookId) {
        return bookRepository.getById(bookId);
    }
}
