package com.example.model;

public class Pizza {
    private Long id;
    private String sabor;
    private String ingredientes;

    public Pizza() {
    }

    public Pizza(Long id, String sabor, String ingredientes) {
        this.id = id;
        this.sabor = sabor;
        this.ingredientes = ingredientes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
}