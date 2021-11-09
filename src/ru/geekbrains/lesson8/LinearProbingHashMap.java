package ru.geekbrains.lesson8;

public class LinearProbingHashMap<Key, Value> {
    private int capacity;
    private int size;
    private Key[] keys;
    private Value[] values;
    private final Object DELETED;

    public LinearProbingHashMap(int capacity) {
        if (capacity<=0){
            throw  new IllegalArgumentException();
        }
        this.capacity = capacity;
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
        DELETED = new Object();
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

    private int hash2(Key key) {
        return 7 - Math.abs (key.hashCode()) % 7;
    }

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
    }

    public void put (Key key, Value value){
        //проверка на превышение лоад фактора , либо бросить исключение,
        // либо перехеширование на массив размером больше (простое число)
        checkKeyNotNull(key);
        int i = hash(key);
        int del=capacity*2;
        int step = hash2(key);
        while (keys[i]!=null){
            if(keys[i].equals(key)){
                values[i]=value;
                return;
            }
            if(keys[i].equals(DELETED)){
               del=i;
            }
            i= (i+step)% capacity;
        }
        int j = Math.min(del, i);
        keys[j]=key;
        values[j]=value;
        size++;
    }

   public Value get(Key key){
       checkKeyNotNull(key);
       int i = hash(key);
       int step = hash2(key);
       while (keys[i]!=null){
           if(keys[i].equals(key)){
               return values[i];
           }
           i= (i+step)% capacity;
       }
       return null;
   }

   public void remove(Key key){
        checkKeyNotNull(key);
        int i = hash(key);
        int step = hash2(key);
        while (keys[i]!=null){
           if(keys[i].equals(key)){
               values[i]= null;
               keys[i]= (Key) DELETED;
               size--;
               return;
           }
           i= (i+step)% capacity;
       }
   }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
            for (Key key: keys) {
                if (key!=DELETED){
                    sb.append(key).append(" ");
                }
                else sb.append("del").append(" ");
            }
            sb.append(System.lineSeparator());
        return sb.toString();
    }
}
