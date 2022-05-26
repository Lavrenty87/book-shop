package ru.learnup.bookshop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.learnup.bookshop.entity.Book;
import ru.learnup.bookshop.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "prise", required = false) Integer prise
    ){
        return bookService.findAllBookByAuthor(3L);
        //return bookService.getBookByFilter(new BookFilter(name, prise));
    }
}

