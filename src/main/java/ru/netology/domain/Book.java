package ru.netology.domain;

public class Book extends Product {
    protected String author;

    public Book(int id, String title, int price, String author) {
        super(id, title, price);
        this.author = author;
    }
}
