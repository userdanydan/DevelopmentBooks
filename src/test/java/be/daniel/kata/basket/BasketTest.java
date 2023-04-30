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
    @Test
    void aBasketHasATotalPrice(){
        Basket basket = new Basket();
        var book1 = new Book();
        book1.setTitle("test1");
        book1.setPrice(.0);
        var book2 = new Book();
        book2.setTitle("test2");
        book2.setPrice(.0);
        basket.setBooks(List.of(book1, book2));
        var expected = .0;
        var actual = basket.getTotalPrice();
        assertEquals(expected, actual);
    }
}