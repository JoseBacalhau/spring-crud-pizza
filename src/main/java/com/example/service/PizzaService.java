package com.example.service;

import com.example.model.Pizza;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaService {
    private List<Pizza> pizzas = new ArrayList<>();
    private Long nextId = 1L;

    public List<Pizza> getAllPizzas() {
        return pizzas;
    }

    public Pizza getPizzaById(Long id) {
        return pizzas.stream()
                .filter(pizza -> pizza.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void createPizza(Pizza pizza) {
        pizza.setId(nextId++);
        pizzas.add(pizza);
    }

    public void updatePizza(Pizza pizza) {
        for (int i = 0; i < pizzas.size(); i++) {
            if (pizzas.get(i).getId().equals(pizza.getId())) {
                pizzas.set(i, pizza);
                return;
            }
        }
    }

    public void deletePizza(Long id) {
        pizzas.removeIf(pizza -> pizza.getId().equals(id));
    }
}
