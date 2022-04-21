package ru.learnup.bookshop.entity.service;

import ru.learnup.bookshop.entity.repository.AuthorRepository;

public class AuthorService {
    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }
}
