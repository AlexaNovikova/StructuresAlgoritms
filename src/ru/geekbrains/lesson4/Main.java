package ru.geekbrains.lesson4;

import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
      MyLinkedList<String> mll = new MyLinkedList<>();
      mll.insertFirst("one");
      mll.insertFirst("two");
      mll.insertFirst("one");
      mll.insertLast("last");
      mll.insert(0, "five");
      System.out.println(mll);
      ListIterator<String >li =mll.listIterator();

       int i = 1;

//      while(li.hasPrevious()){
//        li.previous();
//        li.add(i+ "");
//        i++;
//      }
//      System.out.println(mll);


      while(li.hasNext()){
        li.next();
        li.add(i+ "");
        i++;
      }
      System.out.println(mll);
//      while(li.hasPrevious()){
//        li.previous();
//        li.add("s");
//        i--;
//      }
//      System.out.println(mll);

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
