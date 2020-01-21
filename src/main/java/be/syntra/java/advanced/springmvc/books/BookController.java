package be.syntra.java.advanced.springmvc.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public ModelAndView handleGet() {
        return new ModelAndView("books/bookList", "books", bookRepository.getBooks());
    }

    @GetMapping("/detail")
    public ModelAndView handleGet(@RequestParam("isbn") String isbn) {
        Optional<Book> book = bookRepository.getBookByIsbn(isbn);
        if (book.isPresent()) {
            return new ModelAndView("books/bookDetail", "book", book.get());
        } else {
            return new ModelAndView("redirect:books/bookList");
        }
    }


}
