package be.syntra.java.advanced.springmvc.books.service;

import be.syntra.java.advanced.springmvc.books.model.Book;
import be.syntra.java.advanced.springmvc.books.model.BookList;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Primary
public class BookServiceRestImpl implements BookService {

    private RestTemplate template;

    public BookServiceRestImpl(RestTemplate template) {
        this.template = template;
    }

    @Override
    public List<Book> getAllBooks() {
        ResponseEntity<BookList> response = template.getForEntity("/books", BookList.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody().getBooks();
        } else {
            return null;
        }
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        ResponseEntity<Book> response = template.getForEntity("/books/{isbn}", Book.class, isbn);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
