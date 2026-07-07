package com.library.library_management_api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


//marking class book as a database entity using @Entity annotation. This tells the JPA provider that this class should be mapped to a database table.
@Entity
public class Book {

    //primary key
    @Id
    //tells JPA that a fields value should be automatically generated. The strategy attribute specifies the primary key generation strategy. GenerationType.IDENTITY indicates that the database should generate the primary key value, typically using an auto-increment column.
    //generation type define how id should be generated. GenerationType.IDENTITY means that the database will automatically generate a unique identifier for each new entity instance, typically using an auto-incrementing column.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String genre;

    private String isbn;

    private boolean available;


    public Book() {
    }


    public Book(String title, String author, String genre, String isbn, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.available = available;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}