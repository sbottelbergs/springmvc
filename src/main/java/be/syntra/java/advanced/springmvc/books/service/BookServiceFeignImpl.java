package be.syntra.java.advanced.springmvc.books.service;

import be.syntra.java.advanced.springmvc.books.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("feignBookService")
public class BookServiceFeignImpl implements BookService {

    private final BookServiceFeignClient bookService;

    public BookServiceFeignImpl(BookServiceFeignClient bookService) {
        this.bookService = bookService;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookService.getBooks().getBooks();
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        return bookService.getBookByIsbn(isbn);
    }
}
