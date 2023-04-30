package be.daniel.kata.books;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@Transactional(propagation = Propagation.REQUIRED)
class BookRepositoryTest {
    private final TestEntityManager entityManager;

    private final BookRepository repository;

    public BookRepositoryTest(@Autowired TestEntityManager entityManager,@Autowired BookRepository repository) {
        this.entityManager = entityManager;
        this.repository = repository;
    }

    @Test
    void entityManagerIsThere(){
        assertNotNull(entityManager);
    }
    @Test
    void booksHasARepositoryForPersistence() {
        assertNotNull(repository);
    }

    @Test
    void aBookIsPersisted(){
        Book book = new Book();
        book.setTitle("test1");
        var id = this.entityManager.persist(book).getId();
        Book bookFromPeristence = repository.findById(id).orElseThrow();
        assertEquals(book.getTitle(), bookFromPeristence.getTitle());
    }
}
