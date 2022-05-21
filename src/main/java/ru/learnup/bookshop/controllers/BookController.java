package ru.learnup.bookshop.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.learnup.bookshop.entity.Book2;

import java.util.List;


@Controller
@Slf4j
@RequestMapping("/bookController")
public class BookController {
    // http://localhost:8080/books/home
    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }

    // http://localhost:8080/books/catalog
    @GetMapping("/catalog")
    public String books(Model model) {

        Book2 book = Book2.builder()
                .count(1L)
                .description("Olol")
                .name("Book")
                .price(100L)
                .imageUrl("https://img2.freepng.ru/20180417/zjw/kisspng-computer-icons-literature-book-clip-art-column-5ad5a011d369f9.580985541523949585866.jpg")
                .build();

        model.addAttribute(
                "books",
                List.of(book, book, book, book, book, book, book, book)
        );

        return "books";
    }

    @GetMapping("/book")
    public String createPage(Model model) {
        model.addAttribute("book", new Book2());
        return "addBook";
    }

    @PostMapping("/addBook")
    public String createBook(@ModelAttribute Book2 book, Model model) {
        log.debug("{}", book);
        model.addAttribute("book", book);
        return "addBook";
    }
}
