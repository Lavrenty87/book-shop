package ru.learnup.bookshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.bookshop.dao.Author;
import ru.learnup.bookshop.dao.AuthorDao;

import java.time.LocalDate;

@SpringBootApplication
public class BookShopApplication {

    private static final Logger log = LoggerFactory.getLogger(BookShopApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BookShopApplication.class, args);
        AuthorDao authorDao = context.getBean(AuthorDao.class);

        Author author = authorDao.findById(1);
        log.info("{}", author);
        Author app = Author.builder()
                .name("Jo")
                .surname("Baiden")
                .birth_date(LocalDate.of(1991,1,1))
                .build();
       // authorDao.save(app);
        log.info("{}", authorDao.findById(2));
    }
}
