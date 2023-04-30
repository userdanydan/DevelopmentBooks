package books;

import org.junit.jupiter.api.Test;

class BookTest {

    @Test
    void aBookHasATittle(){
        Book book = new Book();
        var expected = "testTitle";
        book.setTitle(expected);
        var actual = book.getTitle();
        assetEquals(expected, actual);
    }
}
