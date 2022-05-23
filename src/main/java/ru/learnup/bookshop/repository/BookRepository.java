package ru.learnup.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.learnup.bookshop.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select * from book join author_book ab on book.id = ab.book_id where author_id = ?1", nativeQuery = true)
    List<Book> findAllBookByAuthor(Long id);



    List<Book> findAllByBook_nameContainsAndPriseContains(String name, Integer prise);
}
