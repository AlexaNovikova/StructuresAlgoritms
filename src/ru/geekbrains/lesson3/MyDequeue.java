package ru.geekbrains.lesson3;

import java.util.NoSuchElementException;

public class MyDequeue<T> {

    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    public MyDequeue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Object[capacity];

    }

    public MyDequeue() {
        this.capacity = DEFAULT_CAPACITY;
        list = (T[]) new Object[capacity];

    }

    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int prevIndex(int index) {
        return (index - 1) >= 0 ? index - 1 : list.length - 1;
    }

    /**
     * Метод добавления в очередь нового элемента слева
     *
     * @param item добавляет элемент
     */
    public void insertLeft(T item){
        if (isFull()) {
            reCapacity(capacity * 2);
            //  throw new IllegalStateException("очередь полная");
        }
        size++;
        begin = prevIndex(begin);
        list[begin] = item;
    }


    /**
     * Метод получения из очереди первого элемента слева с его последующим удалением из очереди
     *
     */
    public T removeLeft() {
        T temp = peekLeft();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    /**
     * Метод добавления в очередь нового элемента справа
     *
     * @param item добавляет элемент
     */
    public void insertRight(T item) {
        if (isFull()) {
            reCapacity(capacity * 2);
            //реализовать расширение массива
            // throw new IllegalStateException("очередь полная");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T peekLeft() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[begin];
    }

    public T peekRight() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[prevIndex(end)];
    }


    /**
     * Метод получения из очереди первого элемента справа с его последующим удалением из очереди
     *
     */
    public T removeRight() {
        T temp = peekRight();
        size--;
        list[prevIndex(end)] = null;
        end = prevIndex(end);
        return temp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        int i = begin;
        if (size > 0) {
            do {
                sb.append(list[i]).append(", ");
                i = nextIndex(i);
            }
            while (i != end);
            sb.setLength(sb.length() - 2);
        }
        sb.append(" ]");
        return sb.toString();
    }


    private void reCapacity(int newCapacity) {
        T[] tempArr = (T[]) new Object[newCapacity];
        if (begin < end) {
            System.arraycopy(list, 0, tempArr, 0, size);
        } else {
            System.arraycopy(list, begin, tempArr, 0, size - begin);
            System.arraycopy(list, 0, tempArr, size - begin, end);
        }
        begin = 0;
        end = size;
        list = tempArr;
        capacity = newCapacity;
    }
}
