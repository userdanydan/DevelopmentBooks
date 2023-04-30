package be.daniel.kata.books;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    private Book book1;

    @BeforeEach
    void setUp(){
        book1 = new Book();
        book1.setTitle("test1");
    }


    @Test
    void testFindingABook(){
        when(bookRepository.findByName("test1")).thenReturn(Optional.of(book1));
    }


}
