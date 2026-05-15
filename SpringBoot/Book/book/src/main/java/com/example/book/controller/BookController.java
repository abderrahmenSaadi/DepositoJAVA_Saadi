package com.example.book.controller;

import com.example.book.model.Book;
import com.example.book.model.BookStatus;
import com.example.book.repository.BookRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // GET ALL BOOKS
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // GET BOOK BY ID
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    // CREATE BOOK
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // UPDATE BOOK
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id,
                           @RequestBody Book updatedBook) {

        return bookRepository.findById(id)
                .map(book -> {

                    book.setTitle(updatedBook.getTitle());
                    book.setAuthor(updatedBook.getAuthor());
                    book.setPages(updatedBook.getPages());
                    book.setGenre(updatedBook.getGenre());

                    return bookRepository.save(book);

                }).orElseThrow(() ->
                        new RuntimeException("Book not found with id: " + id));
    }

    // DELETE BOOK
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {

        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Book not found with id: " + id);
        }

        bookRepository.deleteById(id);

        return "Book deleted successfully";
    }

    // GET BY TITLE
    @GetMapping("/title")
    public Optional<Book> getBookByTitle(@RequestParam String title) {
        return bookRepository.findByTitle(title);
    }

    // GET BY AUTHOR
    @GetMapping("/author")
    public List<Book> getBooksByAuthor(@RequestParam String author) {
        return bookRepository.findByAuthor(author);
    }

    // GET BY GENRE
    @GetMapping("/genre")
    public List<Book> getBooksByGenre(@RequestParam BookStatus genre) {
        return bookRepository.findByGenre(genre);
    }

    // GET BOOKS WITH PAGES GREATER THAN
    @GetMapping("/pages")
    public List<Book> getBooksWithPagesGreaterThan(
            @RequestParam Integer pages) {

        return bookRepository.findByPagesGreaterThan(pages);
    }

    // SEARCH BY TITLE
    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String keyword) {
        return bookRepository.findByTitleContainingIgnoreCase(keyword);
    }
}