package ru.geekbrains.lesson6;

public class Main {

    public static void main(String[] args) {
//        MyTreeMap<Integer, String> myMap = new MyTreeMap<>();
//        myMap.put(5, "five");
//        myMap.put(1, "one");
//        myMap.put(4, "four");
//        myMap.put(2, "two");
//        myMap.put(6, "six");
//        myMap.put(7, "seven");
//        myMap.put(3, "three");
//        myMap.put(8, "eight");
//        myMap.put(0, "zero");

   //
//        System.out.println(myMap.isBalancedTree());
//
//        myMap.put(3, "three");
//
//        myMap.put(10, "ten");
//
//        myMap.put(6, "six");
//        myMap.put(8, "eight");
//        myMap.put(14, "fourteen");
//        myMap.put(13, "thirteen");

//        System.out.println(myMap.minKey());
//        System.out.println(myMap.maxKey());
//        System.out.println(myMap.get(3));
//        myMap.put(3, "threeee");
//        System.out.println(myMap.get(3));
//        System.out.println(myMap.size());
//        myMap.del(5);
//        myMap.del(13);
//        System.out.println(myMap);
//        System.out.println(myMap.height());

        int kolTrees = 20000;
        int kolLevels = 6;
        MyTreeMap<Integer, String>[] maps = new MyTreeMap[kolTrees];

        for (int i = 0; i < kolTrees; i++) {
            maps[i] = createTree(kolLevels);
        }
        double percentOfNotBalanced = checkPercentOfNotBalancedTrees(maps);
        System.out.println("Процент несбалансированных деревьев: " +percentOfNotBalanced+ " %.");

    }

    public static MyTreeMap<Integer, String> createTree(int levels) {
        MyTreeMap<Integer, String> newMap = new MyTreeMap();
        while (newMap.height() < 6) {
            int key = (int) (Math.random() * 200) - 100;
            String value = String.valueOf(key);
            newMap.put(key, value);
        }
        return newMap;
    }

    public static double checkPercentOfNotBalancedTrees(MyTreeMap<Integer, String>[]maps){
        int balanced=0;
        int notBalanced=0;
        for (MyTreeMap <Integer, String> map:maps) {
            if(map.isBalancedTree()){
                balanced++;
            }
            else notBalanced++;
        }
        return (double) notBalanced/(balanced+notBalanced)*100;
    }
}
