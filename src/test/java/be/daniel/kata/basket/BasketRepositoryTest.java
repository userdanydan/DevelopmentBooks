package be.daniel.kata.basket;

import be.daniel.kata.books.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@Transactional(propagation = Propagation.REQUIRED)
class BasketRepositoryTest {
    private final TestEntityManager entityManager;
    private final BasketRepository repository;

    public BasketRepositoryTest(@Autowired TestEntityManager entityManager,
                                @Autowired BasketRepository repository) {
        this.entityManager = entityManager;
        this.repository = repository;
    }

    @Test
    void entityManagerIsThere() {
        assertNotNull(entityManager);
    }

    @Test
    void booksHasARepositoryForPersistence() {
        assertNotNull(repository);
    }

    @Test
    void aBasketIsPersisted() {
        Book book = new Book();
        book.setTitle("test1");
        Basket basket = new Basket();
        basket.setBooks(List.of(book));
        var id = this.entityManager.persist(basket).getId();
        Basket basketFromPeristence = repository.findById(id).orElseThrow();
        assertEquals(basket.getBooks().get(0).getTitle(), basketFromPeristence.getBooks().get(0).getTitle());
    }


}
