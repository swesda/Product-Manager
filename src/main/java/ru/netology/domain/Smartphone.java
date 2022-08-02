package ru.netology.domain;

public class Smartphone extends Product {
    protected String producer;

    public Smartphone(int id, String title, int price, String producer) {
        super(id, title, price);
        this.producer = producer;
    }
}
