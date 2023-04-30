package be.daniel.kata.basket;

import java.util.Optional;

public interface BasketService {
    Optional<Basket> findById(Long id);
}
