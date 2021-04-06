package ru.geekbrains.lesson8;

import java.util.LinkedList;

public class ChainingHashMap<Key, Value> {
    private int capacity;
    private int size;
    private LinkedList<Node>[] st;

    private class Node {
        Key key;
        Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

    }

    public ChainingHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        st = new LinkedList[capacity];
        for (int i = 0; i < st.length; i++) {
            st[i] = new LinkedList<>();
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }


    public void put(Key key, Value value) {
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node: st[i]) {
            if(key.equals(node.key)){
                node.value=value;
            }
        }
        st[i].add(new Node(key, value));
        size++;
    }

   public Value get(Key key){
       checkKeyNotNull(key);
       int i = hash(key);
       for (Node node: st[i]) {
           if(key.equals(node.key)){
             return node.value;
           }
       }
       return null;
   }

   public boolean remove(Key key){
       checkKeyNotNull(key);
       int i = hash(key);
       if(st[i].removeIf(node -> node.key.equals(key))){
           size--;
           return true;
       }
       return false;
   }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            for (Node node: st[i]) {
            sb.append(node.key).append(" ");
            }
            sb.append(System.lineSeparator());
            }
        return sb.toString();
    }

    // реализовать метод удаления removeIf
}
