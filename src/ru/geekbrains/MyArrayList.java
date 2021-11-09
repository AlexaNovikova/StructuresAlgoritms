package ru.geekbrains;

import java.util.Arrays;

public class MyArrayList<T extends Comparable<T>> {

    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <= 0  " + capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Comparable[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public MyArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        list = (T[]) new Comparable[capacity];
    }

    public void add(T item) {
        // проверка на превышение лоад фактора (0.75)
        checkLoadF();
        list[size] = item;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]).append(", ");
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(" ]");
        return sb.toString();
    }

    public void add(int index, T item) {
        // проверка на превышение лоад фактора (0.75)
        checkLoadF();
        if (index>=size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
        size++;
    }

    public T remove(int index) {
       if (index>=size){
           throw new ArrayIndexOutOfBoundsException(index);
       }
        T temp = list[index];
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size--;
        list[size] = null;
        return temp;
    }

    public int indexOf(T obj) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public T get(int index) {
        if (index>=size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return list[index];
    }

    public void set(int index, T item) {
        if (index>=size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        list[index] = item;
    }

    public int size() {
        return size;
    }


    public boolean remove(T obj) {
        int i = indexOf(obj);
        if (i == -1) {
            return false;
        }
        remove(i);
        return true;
    }

    private void checkLoadF (){
        if (size > capacity*3/4){
            capacity+=capacity;
            T[] listOld = list.clone();
            list = (T[]) new Comparable[capacity];
            for (int i = 0; i < listOld.length; i++) {
                list[i]=listOld[i];
            }
        }
    }

    private boolean less(T item1, T item2) {
        return item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }


    // квадратичная сортировка
    public void selectionSort() {
        int indexMin;
        for (int i = 0; i < size - 1; i++) {
            indexMin = i;
            for (int j = i + 1; j < size; j++) {
                if (less(list[j], list[indexMin])) {
                    indexMin = j;
                }
            }
            swap(i, indexMin);
        }
    }


    // от линейной до квадратичной, оптимально для уже частично отсортированного массива
    public void insertionSort() {
        T key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];
            while (j>0&&less(key,list[j-1])){
                list[j]=list[j-1];
                j--;
            }
         list[j]=key;
        }
    }

    //квадратичная сортировка
    public void bubbleSort(){
        for (int i = size-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(less(list[j+1], list[j])){
                    swap(j+1, j);
                }

            }

        }
    }

    public void bubbleSortOptimal(){
        boolean isSorted;
        for (int i = size-1; i > 0; i--) {
            isSorted=true;
            for (int j = 0; j < i; j++) {
                if(less(list[j+1], list[j])){
                    swap(j+1, j);
                    isSorted=false;
                }
            }
            if(isSorted){
                return;
            }
        }
    }
}
