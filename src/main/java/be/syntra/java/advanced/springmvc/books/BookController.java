package be.syntra.java.advanced.springmvc.books;

import be.syntra.java.advanced.springmvc.books.model.Book;
import be.syntra.java.advanced.springmvc.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(/*@Qualifier("feignBookService")*/ BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ModelAndView handleGet() {
        return new ModelAndView("books/bookList", "books", bookService.getAllBooks());
    }

    @GetMapping("/detail")
    public ModelAndView handleGet(@RequestParam("isbn") String isbn) {
        Book book = bookService.getBookByIsbn(isbn);
        if (book != null) {
            return new ModelAndView("books/bookDetail", "book", book);
        } else {
            return new ModelAndView("redirect:books/bookList");
        }
    }


}
