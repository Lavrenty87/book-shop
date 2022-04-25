package ru.learnup.bookshop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.bookshop.entity.Author;
import ru.learnup.bookshop.entity.service.AuthorService;
import ru.learnup.bookshop.entity.service.BookService;

import java.time.LocalDate;

@SpringBootApplication
public class BookShopApplication {

    private static final Logger log = LoggerFactory.getLogger(BookShopApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BookShopApplication.class, args);

        AuthorService authorService = context.getBean(AuthorService.class);
        Author author = new Author("Fio2Create", context.getBean(BookService.class).getBookById(1L),
                LocalDate.of(2005,04,04));
        authorService.createAuthor(author);
        log.info("Author - {}", context.getBean(AuthorService.class).getAuthors());
       /* AuthorDao authorDao = context.getBean(AuthorDao.class);

        Author author = authorDao.findById(1);
        log.info("{}", author);
        Author app = Author.builder()
                .name("Jo")
                .surname("Baiden")
                .birth_date(LocalDate.of(1991,1,1))
                .build();
       // authorDao.save(app);
        log.info("{}", authorDao.findById(2));*/
    }
}
