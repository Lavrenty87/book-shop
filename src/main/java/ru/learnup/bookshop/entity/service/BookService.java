package ru.learnup.bookshop.entity.service;

import org.springframework.stereotype.Service;
import ru.learnup.bookshop.entity.Book;
import ru.learnup.bookshop.entity.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book createBook(Book book){
        return repository.save(book);
    }

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public Book getBookById(Long id){
        return repository.getById(id);
    }

}
