package com.example.enigma;

public class CartMain {

    private int cartID;
    private String productName;
    private String CustomerName;
    private int quantity;
    private int photo;


    public CartMain() {
    }

    public CartMain(int cartID, String productName, String customerName, int quantity, int photo) {
        this.cartID = cartID;
        this.productName = productName;
        CustomerName = customerName;
        this.quantity = quantity;
        this.photo = photo;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getCartID() {
        return cartID;
    }

    public String getProductName() {
        return productName;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPhoto() {
        return photo;
    }
}
