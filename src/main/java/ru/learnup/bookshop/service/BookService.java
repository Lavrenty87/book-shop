package ru.learnup.bookshop.service;

import org.springframework.stereotype.Service;
import ru.learnup.bookshop.entity.Book;
import ru.learnup.bookshop.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

   /* public Book getBook(String name){
        return repository.findBookByBook_name(name);
    }*/

    public Book createBook(Book book){
        return repository.save(book);
    }

    public List<Book> getBooks() {
        return repository.findAll();
    }

//    public List<Book> getBookByFilter(BookFilter bookFilter){
//        return repository.findAllByBook_nameContainsAndPriseContains(bookFilter.getName(), bookFilter.getPrise());
//    }

    public Book getBookById(Long id){
        return repository.getById(id);
    }

    public Optional<Book> getBook(Long id) {
        return repository.findById(id);
    }

    public List<Book> findAllBookByAuthor(Long id){
        return repository.findAllBookByAuthor(id);
    }

}
