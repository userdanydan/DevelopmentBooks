package be.daniel.kata.basket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {
    private final BasketRepository basketRepository;

    public BasketServiceImpl(@Autowired BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Override
    public Optional<Basket> findById(Long id) {
        return basketRepository.findById(id);
    }
}
