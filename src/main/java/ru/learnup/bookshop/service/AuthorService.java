package ru.learnup.bookshop.service;

import org.springframework.stereotype.Service;
import ru.learnup.bookshop.entity.Author;
import ru.learnup.bookshop.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public Author createAuthor(Author author){
        return repository.save(author);
    }

    public List<Author> getAuthors() {
        return repository.findAll();
    }

    public Author getAuthorById(Long id){
        return repository.findAuthorById(id);
    }
    public Optional<Author> getAuthor(Long id){
        return repository.findById(id);
    }
}