package be.daniel.kata.books;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookResource.class)
class BookResourceTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    BookServiceImpl bookService;

    private final ObjectMapper objectMapper;

    private Book book;

    BookResourceTest(@Autowired ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @BeforeEach
    void setUp() {
        book = new Book();
        book.setId(1L);
        book.setTitle("test");
        book.setPrice(50.0);
    }

    @Test
    void getABookByTitle() throws Exception {
        given(bookService.findBookByTitle("test")).willReturn(Optional.of(book));
        mockMvc.perform(get("/books/{title}", "test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(book)));
    }


}