package be.daniel.kata.books;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {

    @Test
    void aBookHasATittle() {
        Book book = new Book();
        var expected = "testTitle";
        book.setTitle(expected);
        var actual = book.getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void aBookHasAPrice() {
        Book book = new Book();
        var expected = 50.0;
        book.setPrice(expected);
        var actual = book.getPrice();
        assertEquals(expected, actual);
    }

    @Test
    void twoBooksWithSameTitleIsTheSameBook() {
        Book book1 = new Book();
        book1.setTitle("title1");
        Book book2 = new Book();
        book2.setTitle("title1");
        assertEquals(book1, book2);
    }


}
