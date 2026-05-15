package com.example.book.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "pages", nullable = false)
    private Integer pages;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre", nullable = false)
    private BookStatus genre;

    public Book() {
    }

    public Book(String title, String author, Integer pages, BookStatus genre) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.genre = genre;
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

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public BookStatus getGenre() {
        return genre;
    }

    public void setGenre(BookStatus genre) {
        this.genre = genre;
    }
}