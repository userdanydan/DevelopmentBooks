package be.daniel.kata.basket;

import be.daniel.kata.books.Book;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Basket {
    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "books_id")
    private List<Book> books=new ArrayList<>();
    private Double totalPrice;

    public Double getTotalPrice() {
        return getBestPrice(books);
    }

    public double getBestPrice(List<Book> books) {
        // Define the constants for the price and the discounts
        final double PRICE = 50;
        final double[] DISCOUNTS = {0, 0.05, 0.1, 0.2, 0.25};

        // Initialize the total price to zero
        double totalPrice = 0;

        // Use a hash map to count the number of copies of each book title
        HashMap<String, Integer> counts = new HashMap<>();
        for (Book book : books) {
            counts.put(book.getTitle(), counts.getOrDefault(book.getTitle(), 0) + 1);
        }

        // Loop until the map is empty
        while (!counts.isEmpty()) {
            // Initialize the current price and the number of different books
            double currentPrice = 0;
            int differentBooks = 0;

            // Loop through each entry in the map
            for (Iterator<Map.Entry<String, Integer>> iterator = counts.entrySet().iterator(); iterator.hasNext();) {
                // Get the next entry
                Map.Entry<String, Integer> entry = iterator.next();
                // Add the book price to the current price
                currentPrice += PRICE;
                // Increment the number of different books
                differentBooks++;
                // Decrement the number of copies of this book
                entry.setValue(entry.getValue() - 1);
                // Remove the entry from the map if there are no more copies
                if (entry.getValue() == 0) {
                    iterator.remove();
                }
            }

            // Apply the discount to the current price based on the number of different books
            currentPrice *= (1 - DISCOUNTS[differentBooks - 1]);
            // Add the current price to the total price
            totalPrice += currentPrice;
        }

        // Return the total price rounded to two decimal places
        return Math.round(totalPrice * 100) / 100.0;
    }

    public boolean addBook(Book book) {
       return this.books.add(book);
    }


}
