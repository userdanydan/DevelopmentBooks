package be.daniel.kata.books;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByName(String name);
}

