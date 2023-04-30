package be.daniel.kata.basket;

import be.daniel.kata.books.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
class Basket {
    private List<Book> books;
    private Double totalPrice;

    public Double getTotalPrice() {
        double discount = 0.05;
        var total = books.stream()
                .mapToDouble(Book::getPrice)
                .sum();
        return total*(1.0-discount);
    }
}
