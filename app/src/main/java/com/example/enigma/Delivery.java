package com.example.enigma;

public class Delivery {

    private String customerName;
    private String address;
    private String phone;
    private int proID;
    private int quantity;
    private double price;

    public Delivery(String customerName, String address, String phone, int proID, int quantity, double price) {
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
        this.proID = proID;
        this.quantity = quantity;
        this.price = price;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getProID() {
        return proID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
