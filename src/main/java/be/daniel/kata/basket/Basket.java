package be.daniel.kata.basket;

import be.daniel.kata.books.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
class Basket {
    private List<Book> books;
    private Double totalPrice;

    public Double getTotalPrice() {
        double discount = .0;
        var set = new HashSet<>(books);
        if(set.size()==books.size()){
            if (books.size() == 2) {
                discount = 0.05;
            } else if (books.size() == 3) {
                discount = 0.1;
            } else if (books.size()==4) {
                discount = 0.2;
            }
        }
        var total = books.stream()
                .mapToDouble(Book::getPrice)
                .sum();
        return total * (1.0 - discount);
    }
}
