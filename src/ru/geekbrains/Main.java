package ru.geekbrains;

public class Main {

    public static void main(String[] args) {
//	int a = 5;
//	int b = 5;
//        System.out.println(a==b);
//        int c=5;
//
//        inc(c);
//        System.out.println(c);
        Person p = new Person("Ivan");
        update(p);
        System.out.println(p.getName());
    }
    public static void update(Person p){
        p.setName("Super "+p.getName());
    }
    public static void inc(int c) {
        c++;
        System.out.println(c);
    }

    //O(log n)
    public static int find1(int x){
        int i  =1;
        while(i<x){
            i*=2;
        }
        return i;
    }


    //O(n^1/2)
    public static boolean find2(int x){
        for (int i = 2; i*i <= x; i++) {
            if(x%i==0){
                return false;
            }
        }
        return true;
    }


    //O(N)
    public static int find3(int x){
        int sum = 0;
        for (int i = 0; i <= x; i++) {
            sum+=i;
        }
        return sum;
    }

  //O(n*log(n))
    public static int find4(int x){
        int sum =0;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j < x; j*=2) {
                sum +=i*j;
            }
        }
        return sum;
    }


    //O(N*N)
    public static int find5(int x){
        int sum =0;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j < x; j+=2) {
                sum +=i*j;
            }
        }
        return sum;
    }

    //O(N*N*N1/2)  O(N^5/2)
    public static int find6(int x){
        int sum =0;
        int s = (int) Math.sqrt(x);
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j < x; j+=2) {
                for (int k = 0; k < s; k++) {
                    sum+=i+j+k;
                }
            }
        }
        return sum;
    }


    //O(N^3)
    public static int find7(int x){
        int sum =0;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j < x; j+=2) {
                for (int k = 0; k < x; k++) {
                    sum+=i+j+k;
                }
            }
        }
        return sum;
    }



}
