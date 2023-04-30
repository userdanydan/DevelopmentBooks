package be.daniel.kata.basket;

import be.daniel.kata.books.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
class Basket {
    private List<Book> books;
}
