package ru.geekbrains.lesson5;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // System.out.println(fact2(5));
//        System.out.println(fiboRec(10));
//        System.out.println(treug(3));
//        System.out.println(treugRec(3));
//        System.out.println(multiply(3,8));
//        System.out.println(multiplyRec(3,8));


        int number = 10;
        int e = -2;
        System.out.println( "Число " + number+ " в степени " + e +  " = "+ exp(4, 3));

        ArrayList <Item> items = new ArrayList<>();
        items.add(new Item("1", 5,3));
        items.add(new Item("2", 10,5));
        items.add(new Item("3", 6,4));
        items.add(new Item("4", 5,2));
        Rucksack rucksack = new Rucksack(14);
        ArrayList <Item> bestSet = rucksack.makeBestSetOfItems(items);
        System.out.println("Содержимое рюкзака:");
        for (Item item: bestSet) {
            System.out.println(item);
        }
        System.out.println("Суммарная ценность: "+ rucksack.getBestPrice());

    }

    public static int fact(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    public static int fact2(int n) {
        if (n == 1) return 1;
        else
            return n * fact2(n - 1);
    }

    public static long fibo(long n) {
        long a = 1;
        long b = 1;
        for (int i = 3; i <= n; i++) {
            b = b + a;
            a = b - a;
        }
        return b;
    }

    public static long fiboRec(long n) {
        if (n == 1 || n == 2) return 1;
        else return fiboRec(n - 2) + fiboRec(n - 1);
    }

    public static int treug(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int treugRec(int n) {
        if (n == 1) return 1;
        else return n + treugRec(n - 1);
    }

    public static int multiply(int a, int b) {
        int rez = 0;
        for (int i = 1; i <= b; i++) {
            rez += a;
        }
        return rez;
    }

    public static int multiplyRec(int a, int b) {
        if (b == 1) return a;
        else return multiplyRec(a, b - 1) + a;
    }

    public static double exp(int number, int e) {
        if (e < 0) {
            return 1 / (exp(number, -e));
        }
        if (e == 1) return number;
        if (e == 0) return 1;
        else return exp(number, e - 1) * number;
    }



}
