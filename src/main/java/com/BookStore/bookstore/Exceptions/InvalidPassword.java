package com.BookStore.bookstore.Exceptions;

public class InvalidPassword extends Exception{
    public InvalidPassword() {
    }

    public InvalidPassword(String message) {
        super(message);
    }
}
