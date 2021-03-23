package ru.geekbrains.lesson4;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    public ListIterator<T> listIterator() {
        return new ListIter();
    }


    private class ListIter extends Iter implements ListIterator<T> {
        int index = 0;
        Node current = new Node(null, first);
        boolean isNext;
        boolean isPrev;


        /**
         * Метод начинает перебор элементов с конца,
         * возвращает True если есть предшествующий элемент,
         * при достижении начала списка происходит установка итератора на first элементе,
         * метод возвращает false
         */
        @Override
        public boolean hasPrevious() {
            if (current.getPrev() != null) {
                return true;
            } else {
                current = new Node(null, first);
                return false;
            }
        }

        @Override
        public T previous() {
            isPrev = true;
            isNext = false;
            current = current.getPrev();
            return current.getValue();
        }

        @Override
        public int nextIndex() {
            index++;
            return index;
        }

        @Override
        public int previousIndex() {
            index--;
            return index;
        }


        @Override
        public void remove() {
            if (current.getValue() != null) {
                MyLinkedList.this.remove(current.value);
            }
        }


        /**
         * @param t - новое значение элемента списка
         *          устанавливает значение, указанное параметром, для элемента пройденного
         *          итератором методом Next, prev.
         */

        @Override
        public void set(T t) {
            if (isPrev && (current.getPrev() != null || current.getPrev() == null && current.getNext() != null)) {
                current.setValue(t);
            }

            if (isNext && ((current.getNext() != null || current.getPrev() != null && current.getNext() == null))) {
                current.setValue(t);
            }
        }

        /**
         * @param t - значение нового элемента списка
         *          создает новый элемент списка и добавляет его между пройденным элементом
         *          методами Next, Prev
         *          и текущим положением итератора
         */

        @Override
        public void add(T t) {
            if (isPrev) {
                if (current.getPrev() != null) {
                    Node node = new Node(t, current, current.getPrev());
                    current.getPrev().setNext(node);
                    current.setPrev(node);
                    previous();
                } else if (current.getPrev() == null && current.getNext() != null) {
                    Node node = new Node(t, current, null);
                    current.setPrev(node);
                    first = node;
                    previous();
                }
            }
            if (isNext) {
                if (current.getNext() != null) {
                    Node node = new Node(t, current.getNext(), current);
                    current.getNext().setPrev(node);
                    current.setNext(node);
                    next();
                } else if (current.getNext() == null && current.getPrev() != null) {
                    Node node = new Node(t, null, current);
                    current.setNext(node);
                    last = node;
                    next();
                }
            }
        }

        /**
         * Метод начинает перебор элементов с начала списка,
         * возвращает True если есть последующий элемент(элемент не равен null),
         * при достижении конца списка
         * указатель устанавливается на последнем элементе и метод возвращает false
         */
        @Override
        public boolean hasNext() {
            if (current.getNext() != null) {
                return true;
            } else {
                current = new Node(null, null, last);
                return false;
            }

        }

        @Override
        public T next() {
            isPrev = false;
            isNext = true;
            current = current.getNext();
            return current.getValue();
        }
    }

    private class Iter implements Iterator<T> {
        Node current = new Node(null, first);

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public T next() {
            current = current.getNext();
            return current.getValue();
        }
    }

    private class Node {
        T value;
        Node next;
        Node prev;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
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
        if (isEmpty()) {
            last = newNode;
        } else {

            first.setPrev(newNode);
        }
        first = newNode;
        size++;
    }

    public T removeFirst() {
        T tmp = getFirst();
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrev(null);
        }
        size--;
        return tmp;
    }

    public void insertLast(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.setPrev(last);
            last.setNext(newNode);

        }
        last = newNode;
        size++;
    }

    public T removeLast() {
        T tmp = getLast();
        if (last.getPrev() == null) {
            first = null;
        } else {
            last.getPrev().setNext(null);
        }
        last = last.getPrev();
        size--;
        return tmp;
    }

    public T getFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Элемент не найден");
        }
        return first.value;
    }

    public T getLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Элемент не найден");
        }
        return last.value;
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
        if (index == size) {
            insertLast(item);
            return;
        }

        Node current = first;
        int i = 0;
        while (i < index - 1) {
            current = current.getNext();
            i++;
        }
        Node newNode = new Node(item, current.getNext(), current);
        current.getNext().setPrev(newNode);
        current.setNext(newNode);
        size++;
    }

    public boolean remove(T item) {
        if (isEmpty()) {
            return false;
        }
        if (first.value.equals(item)) {
            removeFirst();
            return true;
        }

        Node current = first;
        while (current != null && !current.getValue().equals(item)) {
            current = current.getNext();
        }
        if (current == null) {
            return false;
        }
        if (current == last) {
            removeLast();
            return true;
        }
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        Node current = first;
        while (current != null) {
            sb.append(current.value).append(", ");
            current = current.getNext();
        }
        if (!isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(" ]");
        return sb.toString();
    }
}
