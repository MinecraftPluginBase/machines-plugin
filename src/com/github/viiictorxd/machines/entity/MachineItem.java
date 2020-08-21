package com.github.viiictorxd.machines.entity;

public class MachineItem {

    private String key;
    private double price;
    private MachineItemSettings settings;

    public MachineItem(String key, double price, MachineItemSettings settings) {
        this.key = key;
        this.price = price;
        this.settings = settings;
    }

    public String getKey() {
        return key;
    }

    public double getPrice() {
        return price;
    }

    public MachineItemSettings getSettings() {
        return settings;
    }
}
