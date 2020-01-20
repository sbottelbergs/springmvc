package be.syntra.java.advanced.springmvc.books;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> getBooks();
    Optional<Book> getBookByIsbn(String isbn);
}
