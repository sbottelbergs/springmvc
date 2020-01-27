package be.syntra.java.advanced.springmvc.books.service;

import be.syntra.java.advanced.springmvc.books.Book;
import be.syntra.java.advanced.springmvc.books.BookList;
import be.syntra.java.advanced.springmvc.restclient.model.Message;
import be.syntra.java.advanced.springmvc.restclient.model.MessageList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookServiceRestImpl implements BookService {

    @Value("${baseUrl}")
    private String baseUrl;
    private RestTemplate template;

    public BookServiceRestImpl(RestTemplate template) {
        this.template = template;
    }

    @Override
    public List<Book> getAllBooks() {
        ResponseEntity<BookList> response = template.getForEntity(baseUrl + "/books", BookList.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody().getBooks();
        } else {
            return null;
        }
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        ResponseEntity<Book> response = template.getForEntity(baseUrl + "/books/{isbn}", Book.class, isbn);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
