package be.syntra.java.advanced.springmvc.books;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private String isbn;
    private String title;
    private String author;
    private double price;
}
