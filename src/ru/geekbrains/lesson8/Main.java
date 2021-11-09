package ru.geekbrains.lesson8;

import java.util.Random;

public class Main {
    static Random random;

    public static void main(String[] args) {
//        random= new Random();
//       ChainingHashMap<Integer, String> chm = new ChainingHashMap<>(5);
//       chm.put(1, "one");
//       chm.put(2, "two");
//       chm.put(3, "three");
//        chm.put(5, "five");
//        chm.put(6, "six");
//        System.out.println("size: "+chm.size());
//        System.out.println(chm);
//        System.out.println(chm.remove(5));
//        System.out.println(chm.remove(4));
//        System.out.println(chm);
//        System.out.println("size: "+chm.size());

        LinearProbingHashMap<Integer, String> lphm = new LinearProbingHashMap<>(19);
        lphm.put(1, "one");
        lphm.put(2, "two");
        lphm.put(3, "three");
        lphm.put(6, "two");
        lphm.put(8, "three");
        System.out.println(lphm.get(2));
        System.out.println(lphm);
        System.out.println(lphm.size());
        lphm.remove(2);
        System.out.println(lphm);
        System.out.println(lphm.get(2));
        lphm.put(2, "two");
        System.out.println(lphm);

    }
}
