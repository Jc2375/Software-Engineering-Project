package com.example.vam1994.whyw8;

import java.text.DecimalFormat;

public class OrderedItem {
    String food;
    double price;
    int quantity;
    String ftime;
    public OrderedItem(String food, double price, int quantity,String ftime){
        this.food= food;
        this.price= price;
        this.quantity= quantity;
        this.ftime = ftime;

    }

    public String toString(){
        String s= String.format(("%.2f"),quantity*price);
        String total= food + " (x" + quantity + ") \n$" + s;
        return total;
    }
}
