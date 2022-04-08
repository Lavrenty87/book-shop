package ru.learnup.bookshop.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private long id;
    private String book_name;
    private long author_id;
}
