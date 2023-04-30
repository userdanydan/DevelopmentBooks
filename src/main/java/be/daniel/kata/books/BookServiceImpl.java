package be.daniel.kata.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(@Autowired BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}
