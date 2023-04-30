package be.daniel.kata.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BookResource.class)
class BookResourceTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    BookServiceImpl bookService;
}
