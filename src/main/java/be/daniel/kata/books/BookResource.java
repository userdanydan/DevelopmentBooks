package be.daniel.kata.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
class BookResource {
    private final BookService bookService;

    public BookResource(@Autowired final BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{title}")
    Book getBook(@PathVariable(name = "title") final String title) {
        return bookService.findBookByTitle(title).orElseThrow();
    }


}
