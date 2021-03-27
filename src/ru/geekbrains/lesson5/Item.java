package ru.geekbrains.lesson5;

public class Item {
    private String name;
    private double weight;
    private double price;

    public Item(String name, double weight, double price) {
        this.weight = weight;
        this.price = price;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Предмет "  + name  +
                ", вес=" + weight +
                ", цена=" + price;
    }
}
