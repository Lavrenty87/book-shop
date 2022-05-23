package ru.learnup.bookshop;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.bookshop.entity.Book;

@SpringBootApplication
public class BookShopApplication {

    private static final Logger log = LoggerFactory.getLogger(BookShopApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BookShopApplication.class, args);

        Gson gson =new Gson();
        Book book = new Book();

        String json = gson.toJson(book);
        log.info("json book {}", json);
        Book serBook = gson.fromJson(json, Book.class);
        log.info("book is gson {}", serBook );


      /*  Author author = context.getBean(AuthorService.class).getAuthorById(4L);
       // Optional<Author> author = context.getBean(AuthorService.class).getAuthor(4L);
        log.info("author {}",author);

       // Book book = context.getBean(BookService.class).getBookById(2L);
        Optional<Book> book = context.getBean(BookService.class).getBook(2L);
        log.info("Book - {}", book);
        log.info("book with author id - {}",  context.getBean(BookService.class).findAllBookByAuthor(3L));

      //  log.info("Author - {}", context.getBean(AuthorService.class).getAuthorById(3L));
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
