package be.daniel.kata.books;


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
    void testBookServiceIsAInterface(){
        BookService bookService1 = new BookServiceImpl(bookRepository);
        assertTrue(bookService1 instanceof BookServiceImpl);
    }


    @Test
    void testFindingABook(){
        when(bookRepository.findByTitle("test1")).thenReturn(Optional.of(book1));
        bookRepository.save(book1);
        var expected = book1.getTitle();
        var actual = bookService.findBookByTitle("test1").orElseThrow().getTitle();
        assertEquals(expected, actual);
    }

    @Test
    void testFindingAllBooks(){
        when(bookRepository.findAll()).thenReturn(List.of(book1));
        bookRepository.save(book1);
        var expected = List.of(book1);
        var actual = bookService.findAllBooks();
        assertEquals(expected, actual);
    }


}
