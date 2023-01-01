package com.BookStore.bookstore;

import com.BookStore.bookstore.utils.readDataFromFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String args[]){
        SpringApplication.run(BookstoreApplication.class, args);
    }
}
