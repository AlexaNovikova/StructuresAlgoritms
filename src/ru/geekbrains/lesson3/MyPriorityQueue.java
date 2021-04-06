package ru.geekbrains.lesson3;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyPriorityQueue <T extends Comparable<T>>{
    private T[]list ;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY=10;

    public MyPriorityQueue(int capacity) {
        if (capacity<=0){
            throw new IllegalArgumentException("capacity: "+ capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Comparable[capacity];

    }
    public MyPriorityQueue() {
        this.capacity = DEFAULT_CAPACITY;
        list= (T[]) new Comparable[capacity];

    }

    public boolean isFull(){
        return size == list.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(T item){
        if (isFull()){
           reCapacity(capacity*2);
          //  throw new StackOverflowError("Очередь заполнена");
        }

        list[size]=item;
        size++;
        int i = size-1;
        while (i>0 && list[i-1].compareTo(list[i])<0){
         swap(i,i-1);
         i--;
        }
    }

    public T peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return list[size-1];
    }

    public T remove(){
        T temp = peek();
        size--;
        list[size]=null;
        return temp;
    }
    private void reCapacity(int newCapacity){
        T[] tempArr = (T[]) new Comparable[newCapacity];
        System.arraycopy(list,0,tempArr,0,size);
        capacity=newCapacity;
        list=tempArr;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(list, size));
    }
}
