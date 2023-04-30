package be.daniel.kata.books;

import java.util.Optional;

interface BookService{
    Optional<Book> findBookByTitle(String title);
}
