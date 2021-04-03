package ru.geekbrains.lesson4;

public class MyLinkedStack <T>{
    private MyLinkedList<T> ll = new MyLinkedList<T>();

    public void push (T item){
      ll.insertLast(item);
    }

    public T peek(){
        return ll.getLast();
    }

    public T pop(){
        T item =ll.removeLast();
        return item;
    }

    public int size(){
        return ll.size();
    }
    public boolean isEmpty(){
        return ll.isEmpty();
    }

    @Override
    public String toString() {
        return ll.toString();
    }
}
