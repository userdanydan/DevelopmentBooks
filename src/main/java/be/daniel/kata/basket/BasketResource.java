package be.daniel.kata.basket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/basket", produces = MediaType.APPLICATION_JSON_VALUE)
class BasketResource {

    private final BasketService basketService;

    BasketResource(@Autowired final BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/{id}")
    Basket getBasket(@PathVariable(name="id") final Long id){
        return basketService.findById(id).orElseThrow();
    }
}
