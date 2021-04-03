package ru.geekbrains.lesson3;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        MyStack<String> myStack = new MyStack(3);
//        myStack.push("asd");
//        myStack.push("bnm");
//        myStack.push("123");
//        myStack.push("asd");
//        myStack.push("bnm");
//        myStack.push("123");
//        myStack.push("asd");
//        System.out.println(myStack.size());
//        for (int i = 0; i < 7; i++) {
//            System.out.println(myStack.pop());
//        }
//        System.out.println(myStack.size());

//        Expression exp = new Expression("{[()]}");
//        System.out.println(exp.checkBracket());

//        MyQueue<Integer> myQueue = new MyQueue<>(10);
//
//        for (int i = 0; i < 10; i++) {
//            myQueue.insert(i*10);
//        }
//        for (int i = 0; i < 5; i++) {
//            myQueue.remove();
//        }
//        System.out.println(myQueue);
//
//        for (int i = 0; i < 5; i++) {
//            myQueue.insert(i*10);
//        }
//        System.out.println(myQueue);
//        for (int i = 0; i < 5; i++) {
//            myQueue.insert(i*10);
//        }
//        System.out.println(myQueue);
//        for (int i = 0; i < 5; i++) {
//            myQueue.remove();
//        }
//        System.out.println(myQueue);
//        for (int i = 0; i < 15; i++) {
//            myQueue.insert(i*10);
//        }
//        System.out.println(myQueue);
//        for (int i = 0; i < 5; i++) {
//            myQueue.remove();
//        }
//        System.out.println(myQueue);


//        MyPriorityQueue <Integer> myPriorityQueue = new MyPriorityQueue<>(4);
//        myPriorityQueue.insert(5);
//        myPriorityQueue.insert(4);
//        myPriorityQueue.insert(1);
//        myPriorityQueue.insert(3);
//        myPriorityQueue.insert(8);
//        System.out.println(myPriorityQueue);
//        System.out.println(myPriorityQueue.remove());
//        myPriorityQueue.insert(4);
//        System.out.println(myPriorityQueue);
//        myPriorityQueue.insert(4);
//        myPriorityQueue.insert(1);
//        myPriorityQueue.insert(3);
//        myPriorityQueue.insert(8);
//
//        System.out.println(myPriorityQueue);


   //     reverseExpression();

        MyDequeue<Integer> myDequeue =new MyDequeue<>(3);
        myDequeue.insertRight(2);
        myDequeue.insertRight(5);
        myDequeue.insertRight(7);
        myDequeue.insertRight(9);
        System.out.println(myDequeue);
        System.out.println(myDequeue.removeRight());
        System.out.println(myDequeue.removeLeft());
        System.out.println(myDequeue.removeLeft());
        System.out.println(myDequeue);
        myDequeue.insertRight(2);
        myDequeue.insertRight(5);
        myDequeue.insertRight(7);
        myDequeue.insertRight(9);
        System.out.println(myDequeue);
        myDequeue.insertLeft(4);
        myDequeue.insertRight(12);
        System.out.println(myDequeue);
        System.out.println(myDequeue.removeRight());
        System.out.println(myDequeue.removeLeft());
        System.out.println(myDequeue.removeLeft());
        System.out.println(myDequeue.removeLeft());
        System.out.println(myDequeue);
        myDequeue.insertLeft(4);
        myDequeue.insertLeft(13);
        myDequeue.insertRight(12);
        myDequeue.insertRight(16);
        myDequeue.insertLeft(4);
        myDequeue.insertLeft(13);
        myDequeue.insertRight(12);
        myDequeue.insertRight(16);
        myDequeue.insertLeft(4);
        myDequeue.insertLeft(13);
        myDequeue.insertRight(12);
        myDequeue.insertRight(16);
        System.out.println(myDequeue);
        System.out.println(myDequeue.removeRight());
        System.out.println(myDequeue.removeLeft());
        System.out.println(myDequeue.removeLeft());
        System.out.println(myDequeue.removeLeft());
        System.out.println(myDequeue);
        myDequeue.insertLeft(13);
        myDequeue.insertRight(12);
        myDequeue.insertRight(16);
        System.out.println(myDequeue);
    }

    public static void reverseExpression(){
        System.out.println("Введите любую фразу.");
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.nextLine();
        MyStack<Character> myStack = new MyStack<>(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            myStack.push(exp.charAt(i));
        }
        System.out.println("Перевернутая фраза: ");
        for (int i = 0; i < exp.length(); i++) {
            System.out.print(myStack.pop());
        }
    }
}
