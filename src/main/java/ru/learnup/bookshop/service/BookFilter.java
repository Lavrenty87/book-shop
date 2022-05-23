package ru.learnup.bookshop.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookFilter {

    private final String name;
    private final Integer prise;
}
