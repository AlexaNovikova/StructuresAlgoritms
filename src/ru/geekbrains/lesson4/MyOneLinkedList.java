package ru.geekbrains.lesson4;

import java.util.NoSuchElementException;

public class MyOneLinkedList<T> {
    private Node first;
    private int size;

    private class Node {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public T getValue() {
            return value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }

    public void insertFirst(T item) {
        Node newNode = new Node(item, first);
        first = newNode;
        size++;
    }

    public T removeFirst() {
        T tmp = getFirst();
        first = first.getNext();
        size--;
        return tmp;
    }

    public T getFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Элемент не найден");
        }
        return first.value;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public final int indexOf(T val) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.value.equals(val)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) > -1;
    }

    public void insert(int index, T item) throws IllegalArgumentException {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is wrong");
        }
        if ((index == 0)) {
            insertFirst(item);
            return;
        }
        Node current = first;
        int i = 0;
        while (i < index - 1) {
            current = current.getNext();
            i++;
        }
        Node newNode = new Node(item, current.getNext());
        current.setNext(newNode);
        size++;
    }

    public boolean remove (T item){
        if (isEmpty()){
            return false;
        }
        if (first.value.equals(item))
         {
            removeFirst();
            return true;
        }
        Node current = first;
        while (current.getNext()!=null && !current.getNext().getValue().equals(item)){
            current=current.getNext();
        }
        if (current.getNext()==null){
            return false;
        }
        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        Node current = first;
        while (current!=null){
            sb.append(current.value).append(", ");
            current=current.getNext();
        }
        if (!isEmpty()){
            sb.setLength(sb.length()-2);
        }
        sb.append(" ]");
        return sb.toString();
    }
}
