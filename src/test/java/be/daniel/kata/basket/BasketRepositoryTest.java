package be.daniel.kata.basket;

import be.daniel.kata.books.BookRepository;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
@Transactional(propagation = Propagation.REQUIRED)

class BasketRepositoryTest {
    private final TestEntityManager entityManager;
    private final BasketRepository repository;

    public BasketRepositoryTest(TestEntityManager entityManager, BasketRepository repository) {
        this.entityManager = entityManager;
        this.repository = repository;
    }
}
