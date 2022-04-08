package ru.learnup.bookshop.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {

    private static final String FIND_BI_ID = "select * from order where id = :id";
    private final NamedParameterJdbcTemplate template;

    public OrderDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public Order findById(long id) {
        return template.query(FIND_BI_ID,
                new MapSqlParameterSource("id", id),
                (rs, rm) -> Order.builder()
                        .id(rs.getLong("id"))
                        .book_id(rs.getLong("book_id"))
                        .author_id(rs.getLong("author_id"))
                        .count(rs.getInt("count"))
                        .prise(rs.getInt("prise"))
                        .build()
                ).stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException("order with id " + id + " is not found")
                );
    }
}
