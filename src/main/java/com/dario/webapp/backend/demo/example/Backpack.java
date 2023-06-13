package com.dario.webapp.backend.demo.example;

public class Backpack {

    private Book book;

    private PencilCase pencilCase;

    private Water water;

    public Backpack (Book book, PencilCase pencilCase){
        this.book = book;
        this.pencilCase = pencilCase;
    }

    public void setWater(Water water){
        this.water = water;
    }

}
