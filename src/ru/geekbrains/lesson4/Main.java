package ru.geekbrains.lesson4;

import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> mll = new MyLinkedList<>();
        mll.insertFirst("one");
        mll.insertFirst("two");
        mll.insertFirst("tree");
        mll.insertFirst("four");
        mll.insertFirst("five");
        System.out.println(mll);
        ListIterator<String> li = mll.listIterator();


        System.out.println("Перебор итератором с начала");
        while (li.hasNext()) {
            System.out.println(li.next());
        }
        System.out.println();

        System.out.println("Перебор итератором с конца");
        while (li.hasPrevious()) {
            System.out.println(li.previous());
        }
        System.out.println();

        System.out.println("Перебор итератором с начала и добавление");
        while (li.hasNext()) {
            li.next();
            li.add("next");

        }
        System.out.println(mll);

        System.out.println("Перебор итератором с конца и добавление");
        while (li.hasPrevious()) {
            li.previous();
            li.add("prev");

        }
        System.out.println(mll);
        int i = 1;
        System.out.println("Перебор итератором с начала и изменения значения");
        while (li.hasNext()) {
            li.next();
            li.set("" + i);
            i++;
        }
        System.out.println(mll);

        System.out.println("Перебор итератором с конца и изменения значения");
        while (li.hasPrevious()) {
            li.previous();
            li.set("new");
        }
        System.out.println(mll);

        System.out.println("Перебор итератором с начала и удаление значения");
        while (li.hasNext()) {
            li.next();
            li.remove();
            i++;
        }
        System.out.println(mll);
//        MyLinkedStack<Integer> stack = new MyLinkedStack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        System.out.println(stack);
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//


//        MyLinkedQueue <Integer> queue = new MyLinkedQueue<>();
//        queue.insert(1);
//        queue.insert(4);
//        queue.insert(7);
//        queue.insert(9);
//        queue.insert(10);
//        queue.insert(13);
//        System.out.println(queue);
//        System.out.println(queue.peekFront());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue);

    }
}
