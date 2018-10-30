package com.example.vam1994.whyw8;

public class OrderedItem {
    String food;
    double price;
    int quantity;
    public OrderedItem(String food, double price, int quantity){
        this.food= food;
        this.price= price;
        this.quantity= quantity;
    }

    public String toString(){
        String total= food + " (x" + quantity + ") \n$" + quantity*price;
        return total;
    }
}
