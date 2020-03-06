package be.syntra.java.advanced.springmvc.books.service;

import be.syntra.java.advanced.springmvc.books.model.Book;
import be.syntra.java.advanced.springmvc.books.model.BookList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "bookServiceFeignClient", url = "${baseUrl}/books")
public interface BookServiceFeignClient {
    @GetMapping
    BookList getBooks();

    @GetMapping("/{isbn}")
    Book getBookByIsbn(@PathVariable String isbn);
}
