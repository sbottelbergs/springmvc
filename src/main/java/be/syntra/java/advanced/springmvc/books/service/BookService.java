package be.syntra.java.advanced.springmvc.books.service;

import be.syntra.java.advanced.springmvc.books.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookByIsbn(String isbn);
}
