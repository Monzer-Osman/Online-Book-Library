package com.BookStore.bookstore.Models;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book {
    @Id
    String bookId;
    String title;
    String series;
    String author;
    String rating;
    String description;
    String language;
    String isbn;
    String publisher;
    String imgSrc;
    String [] genres;
    String pages;
    String price;

    public Book() {}

    public Book(String bookId, String title, String series,
                String author, String rating, String description,
                String language, String isbn, String publisher,
                String imgSrc, String[] genres, String pages, String price) {
        this.bookId = bookId;
        this.title = title;
        this.series = series;
        this.author = author;
        this.rating = rating;
        this.description = description;
        this.language = language;
        this.isbn = isbn;
        this.publisher = publisher;
        this.imgSrc = imgSrc;
        this.genres = genres;
        this.pages = pages;
        this.price = price;
    }

    public Book(String bookId, String title, String rating,
                String language, String isbn, String imgSrc,
                String pages, String price) {
        this.bookId = bookId;
        this.title = title;
        this.rating = rating;
        this.language = language;
        this.isbn = isbn;
        this.imgSrc = imgSrc;
        this.pages = pages;
        this.price = price;
    }

    public Book(String [] columns){
        this.bookId = columns[0];
        this.title = columns[1];
        this.rating = columns[2];
        this.language = columns[3];
        this.isbn = columns[4];
        this.pages = columns[5];
        if(columns.length > 6)
            this.imgSrc = columns[6];
        if(columns.length > 7){
            this.price = columns[7];
        }
        else {
            this.price = "0";
        }
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
