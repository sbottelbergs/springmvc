package be.syntra.java.advanced.springmvc.books;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private List<Book> books;

    public BookRepositoryImpl() {
        books = new ArrayList<>();
        books.add(
                Book.builder()
                        .isbn("1")
                        .author("J.K. Rowling")
                        .title("Harry Potter And The Philosopher’s Stone")
                        .price(15.0d)
                        .build()
        );
        books.add(
                Book.builder()
                        .isbn("2")
                        .author("Michelle Obama")
                        .title("Becoming - A Guided Journal for Discovering Your Voice")
                        .price(10.0d)
                        .build()
        );
        books.add(
                Book.builder()
                        .isbn("3")
                        .author("Irma S. Rombauer")
                        .title("Joy of Cooking")
                        .price(24.95d)
                        .build()
        );
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Optional<Book> getBookByIsbn(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst();
    }
}
