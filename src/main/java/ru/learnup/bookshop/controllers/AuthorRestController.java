package ru.learnup.bookshop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.learnup.bookshop.entity.Author;
import ru.learnup.bookshop.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorRestController {
    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }
}

