package com.endava.models;

import com.endava.enums.GuitarModel;
import com.endava.enums.GuitarType;

public class Guitar {
    private String name;
    private GuitarType type;
    private GuitarModel model;
    private double price;

    public Guitar(){
        this.name = "";
        this.price = 0;
    }

    public Guitar(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GuitarType getType() {
        return type;
    }

    public void setType(GuitarType type) {
        this.type = type;
    }

    public GuitarModel getModel() {
        return model;
    }

    public void setModel(GuitarModel model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return "Guitar:" + "\nName: " + name + "\nType: " + type + "\nModel: " + model + "\nPrice: " + price + "\n";
    }

}
