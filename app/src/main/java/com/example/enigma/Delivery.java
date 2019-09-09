package com.example.enigma;

public class Delivery {

    private int id;
    private String title;
    private double price;
    private int quantity;
    private int image;


    public Delivery(int id, String title, double price, int quantity, int image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getImage() {
        return image;
    }
}
