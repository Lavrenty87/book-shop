package ru.learnup.bookshop.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private long id;
    private long book_id;
    private long author_id;
    private int count;
    private int prise;
}
