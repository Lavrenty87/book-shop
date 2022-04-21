package ru.learnup.bookshop.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.learnup.bookshop.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
