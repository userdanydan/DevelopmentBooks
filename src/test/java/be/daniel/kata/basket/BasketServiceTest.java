package be.daniel.kata.basket;

import be.daniel.kata.books.Book;
import be.daniel.kata.books.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BasketServiceTest {

    @Mock
    private BasketRepository basketRepository;

    @InjectMocks
    private BasketServiceImpl basketService;

    private Basket basket;
    private Book book;

    @BeforeEach
    void setUp(){
        basket = new Basket();
        book = new Book();
        book.setTitle("test");
    }
    @Test
    void testBasketServiceIsAnInterace(){
        BasketService basketService1 = new BasketServiceImpl();
        assertTrue(basketService1 instanceof BasketServiceImpl);
    }

    @Test
    void testFindBasketById(){
        when(basketRepository.findById(1L)).thenReturn(Optional.of(basket));
        basket.setBooks(List.of(book));
        var id = basketRepository.save(basket);
        var expected = basketService.findById(id).getBooks().get(0).getTitle();
        var actual = book.getTitle();
        assertEquals(expected, actual);
    }

}
