package com.example.book.repository;

import com.example.book.model.Book;
import com.example.book.model.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByGenre(BookStatus genre);

    List<Book> findByPagesGreaterThan(Integer pages);

    List<Book> findByTitleContainingIgnoreCase(String keyword);
}