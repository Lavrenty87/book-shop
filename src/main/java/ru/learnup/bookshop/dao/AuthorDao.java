package ru.learnup.bookshop.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.ZoneOffset;

@Repository
public class AuthorDao {

    private static final String FIND_BY_ID = "select * from author where id = :id";
    private static final String SAVE = "insert into author (name, surname, birth_date) " +
            "values (:name, :surname, :birth_date)";

    private final NamedParameterJdbcTemplate template;

    public AuthorDao(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public Author findById(long id){
        return template.query(FIND_BY_ID,
                new MapSqlParameterSource("id", id),
                (rs, rn) -> Author.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .surname(rs.getString("surname"))
                        .birth_date(rs.getDate("birth_date").toLocalDate())
                        .build()
                ).stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException("author with id " + id + " is not found"));
    }

    public void save(Author author){
        template.update(SAVE, new MapSqlParameterSource()
                .addValue("name", author.getName())
                .addValue("surname", author.getSurname())
                .addValue("birth_date", new Date(author.getBirth_date()
                        .atStartOfDay()
                        .toInstant(ZoneOffset.UTC)
                        .toEpochMilli())
                )
        );
    }
}
