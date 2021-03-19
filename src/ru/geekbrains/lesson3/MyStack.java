package ru.geekbrains.lesson3;

import java.util.EmptyStackException;

public class MyStack <T>{
    private T[]list ;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY=10;

    public MyStack(int capacity) {
        if (capacity<=0){
            throw new IllegalArgumentException("capacity: "+ capacity);
        }
        this.capacity = capacity;
        list = (T[])new Object[capacity];

    }
    public MyStack() {
        this.capacity = DEFAULT_CAPACITY;
        list= (T[]) new Object[capacity];

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

    public void push(T item){
        if (isFull()){
            reCapacity(capacity*2);
        //    throw new StackOverflowError("нет места в стеке");
        }
        list[size]=item;
        size++;
    }

    public T pick() throws EmptyStackException{
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return list[size-1];
    }

    public T pop(){
        T temp = pick();
        size--;
        list[size]=null;
        return temp;
    }
    private void reCapacity(int newCapacity){
        T[] tempArr = (T[]) new Object[newCapacity];
        System.arraycopy(list,0,tempArr,0,size);
        list=tempArr;
        capacity= newCapacity;
    }
}
