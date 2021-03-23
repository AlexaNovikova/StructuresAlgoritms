package ru.geekbrains;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {
//        int[] arr = new int[10];
//        int[][] arr2 = new int[10][];
//
//        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 2, 2, 2, 3, 4, 5));
//        list.removeIf(i -> i == 2);
//        list.removeAll(Collections.singletonList(2));
//        list.replaceAll(i -> i*i);
//        list.remove(new Integer(2));
//        System.out.println(list);


//        MySortedArrayList<Integer> msal= new MySortedArrayList<>();
//        msal.add(13);
//        msal.add(5);
//        msal.add(1);
//        msal.add(13);
//        msal.add(6);
//        msal.add(1);
//        msal.add(2);
//        System.out.println(msal);
//        System.out.println(msal.binaryIndexOf(13));

        MyArrayList<Integer> myArrayList = new MyArrayList<>(100000);
        Random r = new Random();
        for (int i = 0; i < 100000; i++) {
            myArrayList.add(r.nextInt(1000));
        }

        // получено время - 9614мс
//        long timeStart = System.currentTimeMillis();
//        myArrayList.selectionSort();
//        long timeEnd = System.currentTimeMillis();
//        long deltaTime = timeEnd-timeStart;
//        System.out.println("Time of selectionSort : "+ deltaTime);


        // 3982 мс
//        long timeStart = System.currentTimeMillis();
//        myArrayList.insertionSort();
//        long timeEnd = System.currentTimeMillis();
//        long deltaTime = timeEnd-timeStart;
//        System.out.println("Time of insertionSort : "+ deltaTime);


        // Time of bubbleSort : 28822
//        long timeStart = System.currentTimeMillis();
//        myArrayList.bubbleSort();
//        long timeEnd = System.currentTimeMillis();
//        long deltaTime = timeEnd-timeStart;
//        System.out.println("Time of bubbleSort : "+ deltaTime);


      //  Time of bubbleSortOptimal : 28989
        long timeStart = System.currentTimeMillis();
        myArrayList.bubbleSortOptimal();
        long timeEnd = System.currentTimeMillis();
        long deltaTime = timeEnd-timeStart;
        System.out.println("Time of bubbleSortOptimal : "+ deltaTime);
    }


}
