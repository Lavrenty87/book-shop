package ru.learnup.bookshop.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.learnup.bookshop.entity.Book;
import ru.learnup.bookshop.repository.BookRepository;
import ru.learnup.bookshop.service.BookService;

import java.util.List;


@Controller
@Slf4j
@RequestMapping("/bookController")
public class BookController {
    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    // http://localhost:8080/books/home
    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }

    // http://localhost:8080/books/catalog
    @GetMapping("/catalog")
    public String books(Model model) {

        List<Book> books = new BookService(repository).getBooks();
        model.addAttribute(
                "books", books);

        return "books";
    }

    @GetMapping("/book")
    public String createPage(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/addBook")
    public String createBook(@ModelAttribute Book book, Model model) {
        log.debug("{}", book);
        model.addAttribute("book", book);
        return "addBook";
    }
}
