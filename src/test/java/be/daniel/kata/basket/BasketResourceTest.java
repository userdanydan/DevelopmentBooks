package be.daniel.kata.basket;

import be.daniel.kata.books.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BasketResource.class)
class BasketResourceTest {
    @Autowired
    MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    private Book book;
    private Basket basket;

    BasketResourceTest(@Autowired ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
