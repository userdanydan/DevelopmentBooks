package be.daniel.kata.basket;

import be.daniel.kata.books.Book;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasketTest {

    @Test
    void aBasketHasBooks(){
        Basket basket = new Basket();
        var book1 = new Book();
        book1.setTitle("test1");
        var book2 = new Book();
        book2.setTitle("test2");
        basket.setBooks(List.of(book1, book2));
        var actual = basket.getBooks();
        var expected = List.of(book1, book2);
        assertEquals(expected, actual);
    }
}
