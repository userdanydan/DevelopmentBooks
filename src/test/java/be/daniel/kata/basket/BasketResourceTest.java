package be.daniel.kata.basket;

import be.daniel.kata.books.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BasketResource.class)
class BasketResourceTest {
    private final ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;
    @MockBean
    BasketServiceImpl basketService;
    private Book book;
    private Basket basket;

    BasketResourceTest(@Autowired ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @BeforeEach
    void setUp() {
        book = new Book();
        book.setId(1L);
        book.setTitle("test");
        book.setPrice(50.0);

        basket = new Basket();
        basket.setBooks(List.of(book));
    }

    @Test
    void getABasketById() throws Exception {
        given(basketService.findById(1L)).willReturn(Optional.ofNullable(basket));
        mockMvc.perform(get("/basket/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(basket)));
    }

}
