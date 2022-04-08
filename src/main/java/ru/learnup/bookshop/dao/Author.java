package ru.learnup.bookshop.dao;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Author {
    private long id;
    private String name;
    private String surname;
    private LocalDate birth_date;
}
