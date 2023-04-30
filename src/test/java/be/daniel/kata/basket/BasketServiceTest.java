package be.daniel.kata.basket;

import be.daniel.kata.books.Book;
import be.daniel.kata.books.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BasketServiceTest {

    @Mock
    private BasketRepository basketRepository;

    @InjectMocks
    private BasketService basketService;

    private Basket basket;
    private Book book;

    @BeforeEach
    void setUp(){
        basket = new Basket();
        book = new Book();
    }
    @Test
    void testBasketServiceIsAnInterace(){
        BasketService basketService1 = new BasketServiceImpl();
        assertTrue(basketService1 instanceof BasketServiceImpl);
    }

}
