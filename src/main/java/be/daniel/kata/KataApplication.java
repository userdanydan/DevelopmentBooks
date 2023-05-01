package be.daniel.kata;

import be.daniel.kata.books.Book;
import be.daniel.kata.books.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class KataApplication {

    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(KataApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData() {
        return (args) -> {
            List<Book> books = List.of(
                    bookRepository.save(new Book("test", 50.0)),
                    bookRepository.save(new Book("Clean Code", 50.0)),
                    bookRepository.save(new Book("The Clean Coder", 50.0)),
                    bookRepository.save(new Book("Working Effectively With Legacy Code", 50.0)),
                    bookRepository.save(new Book("Clean Architecture", 50.0)),
                    bookRepository.save(new Book("Test Driven Development by Example", 50.0))
            );
        };
    }

}
