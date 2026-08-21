package com.example.managingbooks.service;

import com.example.managingbooks.model.Book;
import com.example.managingbooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Create Book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    // Get Book by ID
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Book not found with ID: " + id));
    }

    // List all Books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Update Book
    public Book updateBook(Long id, Book bookDetails) {
        Book book = getBookById(id);
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setIsbn(bookDetails.getIsbn());
        book.setPublishedYear(bookDetails.getPublishedYear());
        return bookRepository.save(book);
    }

    // Delete Book
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new NoSuchElementException("Book not found with ID: " + id);
        }
        bookRepository.deleteById(id);
    }
}