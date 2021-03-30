package ru.geekbrains.lesson3;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyQueue<T> {
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    public MyQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Object[capacity];

    }

    public MyQueue() {
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

    /**
     * Метод добавления в очередь нового элемента
     *
     * @param item добавляет элемент
     * @throws IllegalStateException если очередь полная
     */
    public void insert(T item) throws IllegalStateException {
        if (isFull()) {
            reCapacity(capacity * 2);
            // throw new IllegalStateException("очередь полная");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T peekFront() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[begin];

    }

    public T remove() {
        T temp = peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
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
