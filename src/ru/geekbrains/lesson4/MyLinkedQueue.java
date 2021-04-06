package ru.geekbrains.lesson4;

import java.util.NoSuchElementException;

public class MyLinkedQueue <T>{
    MyLinkedList<T> ll = new MyLinkedList<>();

    public boolean isEmpty() {
        return ll.isEmpty();
    }

    public int size() {
        return ll.size();
    }

    public void insert(T item) {
       ll.insertLast(item);
    }

    public T peekFront()  throws NoSuchElementException{
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return ll.getFirst();
    }

    public T remove() {
        return ll.removeFirst();
    }

    @Override
    public String toString() {
        return ll.toString();
    }

}
