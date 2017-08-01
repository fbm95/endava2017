package com.endava.models;

import com.endava.enums.AmplifierElectronics;
import com.endava.enums.AmplifierType;

public class Amplifier {
    private String name;
    private AmplifierType type;
    private AmplifierElectronics electronics;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AmplifierType getType() {
        return type;
    }

    public void setType(AmplifierType type) {
        this.type = type;
    }

    public AmplifierElectronics getElectronics() {
        return electronics;
    }

    public void setElectronics(AmplifierElectronics electronics) {
        this.electronics = electronics;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return "Amplifier:" + "\nName: " + name + "\nType: " + type + "\nElectronics: " + electronics + "\nPrice: " + price + "\n";
    }
}
