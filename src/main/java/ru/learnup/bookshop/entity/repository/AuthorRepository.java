package ru.learnup.bookshop.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.bookshop.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorById (Long id);

}
