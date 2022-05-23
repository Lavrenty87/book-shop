package ru.learnup.bookshop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.learnup.bookshop.entity.Author;
import ru.learnup.bookshop.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorRestController {
    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    public List<Author> getAuthor(
            @RequestParam(value = "fio", required = false) String fio){
        return authorService.getAuthors();
    }
}
