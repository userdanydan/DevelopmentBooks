package be.daniel.kata.basket;

import be.daniel.kata.books.Book;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BasketTest {
    final String CLEAN_CODE = "Clean Code";
    final String CLEAN_CODER = "The Clean Coder";
    final String CLEAN_ARCHITECTURE = "Clean Architecture";
    final String TDD_BY_EXAMPLE = "Test Driven Development by Example";
    final String WORKING_WITH_LEGACY_CODE = "Working Effectively With Legacy Code";

    final double BOOK_PRICE = 50;

    @Test
    void aBasketHasBooks() {
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
    void aBasketShouldApplyADiscountOf5PCRT() {
        Basket basket = new Basket();
        var book1 = new Book();
        book1.setTitle("test1");
        book1.setPrice(50.0);
        var book2 = new Book();
        book2.setTitle("test2");
        book2.setPrice(50.0);
        basket.setBooks(List.of(book1, book2));
        var expected = 95.0;
        var actual = basket.getTotalPrice();
        assertEquals(expected, actual);
    }

    @Test
    void aBasketShouldApplyADiscountof10PCRTForThreeDifferentBooks() {
        Basket basket = new Basket();
        var book1 = new Book();
        book1.setTitle("test1");
        book1.setPrice(50.0);

        var book2 = new Book();
        book2.setTitle("test2");
        book2.setPrice(50.0);

        var book3 = new Book();
        book3.setTitle("test3");
        book3.setPrice(50.0);

        basket.setBooks(List.of(book1, book2, book3));
        var expected = 135.0;
        var actual = basket.getTotalPrice();
        assertEquals(expected, actual);
    }

    @Test
    void aBasketShouldApplyNotADiscountof10PCRTForThreeSameBooks() {
        Basket basket = new Basket();
        var book1 = new Book();
        book1.setTitle("test1");
        book1.setPrice(50.0);

        var book2 = new Book();
        book2.setTitle("test1");
        book2.setPrice(50.0);

        var book3 = new Book();
        book3.setTitle("test1");
        book3.setPrice(50.0);

        basket.setBooks(List.of(book1, book2, book3));
        var expected = 150.0;
        var actual = basket.getTotalPrice();
        assertEquals(expected, actual);
    }

    @Test
    void aBasketShouldApplyADiscountof20PCRTForForDifferentBooks() {
        Basket basket = new Basket();
        var book1 = new Book();
        book1.setTitle("test1");
        book1.setPrice(50.0);

        var book2 = new Book();
        book2.setTitle("test2");
        book2.setPrice(50.0);

        var book3 = new Book();
        book3.setTitle("test3");
        book3.setPrice(50.0);

        var book4 = new Book();
        book4.setTitle("test4");
        book4.setPrice(50.0);

        basket.setBooks(List.of(book1, book2, book3, book4));
        var expected = 160.0;
        var actual = basket.getTotalPrice();
        assertEquals(expected, actual);
    }

    @Test
    void aBasketShouldApplyADiscountof25PCRTForFiveDifferentBooks() {
        Basket basket = new Basket();
        var book1 = new Book();
        book1.setTitle("test1");
        book1.setPrice(50.0);

        var book2 = new Book();
        book2.setTitle("test2");
        book2.setPrice(50.0);

        var book3 = new Book();
        book3.setTitle("test3");
        book3.setPrice(50.0);

        var book4 = new Book();
        book4.setTitle("test4");
        book4.setPrice(50.0);

        var book5 = new Book();
        book5.setTitle("test5");
        book5.setPrice(50.0);

        basket.setBooks(List.of(book1, book2, book3, book4, book5));
        var expected = 187.5;
        var actual = basket.getTotalPrice();
        assertEquals(expected, actual);
    }

    @Test
    void aBasketShoulOptimizeDiscounts() {

        //Arrange
        Basket basket = new Basket();
        basket.addBook(new Book(CLEAN_CODE, BOOK_PRICE));
        basket.addBook(new Book(CLEAN_CODE, BOOK_PRICE));
        basket.addBook(new Book(CLEAN_CODER, BOOK_PRICE));
        basket.addBook(new Book(CLEAN_CODER, BOOK_PRICE));
        basket.addBook(new Book(CLEAN_ARCHITECTURE, BOOK_PRICE));
        basket.addBook(new Book(CLEAN_ARCHITECTURE, BOOK_PRICE));
        basket.addBook(new Book(TDD_BY_EXAMPLE, BOOK_PRICE));
        basket.addBook(new Book(WORKING_WITH_LEGACY_CODE, BOOK_PRICE));

        // Act
        double price = basket.getTotalPrice();

        // Assert
        assertEquals(320, price, 0.01);
    }

}
