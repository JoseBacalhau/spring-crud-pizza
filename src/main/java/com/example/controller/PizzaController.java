package com.example.controller;

import com.example.model.Pizza;
import com.example.service.PizzaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    private PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public List<Pizza> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getPizzaById(@PathVariable Long id) {
        Pizza pizza = pizzaService.getPizzaById(id);
        if (pizza != null) {
            return ResponseEntity.ok(pizza);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> createPizza(@RequestBody Pizza pizza) {
        pizzaService.createPizza(pizza);
        return ResponseEntity.created(URI.create("/api/pizzas/" + pizza.getId())).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePizza(@PathVariable Long id, @RequestBody Pizza pizza) {
        Pizza existingPizza = pizzaService.getPizzaById(id);
        if (existingPizza != null) {
            pizza.setId(id);
            pizzaService.updatePizza(pizza);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable Long id) {
        Pizza existingPizza = pizzaService.getPizzaById(id);
        if (existingPizza != null) {
            pizzaService.deletePizza(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
