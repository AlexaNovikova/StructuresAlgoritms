package ru.geekbrains.lesson5;

import java.util.ArrayList;
import java.util.List;

public class Rucksack {
    private double bestPrice;
    private int maxWeight;
    ArrayList<Item> contents;

    public Rucksack(int maxWeight) {
        this.maxWeight = maxWeight;
        this.contents = new ArrayList<>();
        this.bestPrice=0;
    }

    private double totalWeight(ArrayList<Item> list){
        double weight=0;
        for (Item i:list) {
            weight+=i.getWeight();
        }
        return weight;
    }
    private double totalPrice(ArrayList<Item>list){
        double price =0;
        for (Item i:list) {
            price+=i.getPrice();
        }
        return price;
    }


    private void checkContent(ArrayList<Item> items)
    {
        if (contents == null)
        {
            if (totalWeight(items) <= maxWeight)
            {
                contents = items;
                bestPrice = totalPrice(items);
            }
        }
        else
        {
            if(totalWeight(items) <= maxWeight && totalPrice(items) > bestPrice)
            {
                contents = items;
                bestPrice = totalPrice(items);
            }
        }
    }
    private void makeContents(ArrayList<Item> items)
    {
        if (items.size() > 0)
            checkContent(items);

        for (int i = 0; i < items.size(); i++)
        {
            ArrayList<Item> newContents = new ArrayList<Item>(items);
            newContents.remove(i);
            makeContents(newContents);
        }
    }

    public ArrayList<Item> makeBestSetOfItems(ArrayList<Item> items)
    {
        makeContents(items);
        return contents;
    }

    public double getBestPrice() {
        return bestPrice;
    }
}
