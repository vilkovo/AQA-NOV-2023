package org.prog.collections;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        List<String> aList = new ArrayList<>();
        List<String> bList = new ArrayList<>();
        List<String> cList = new ArrayList<>();

        aList.add("a");
        aList.add("b");
        aList.add("c");

        bList.add("d");
        bList.add("e");
        bList.add("f");

        cList.add("a");
        cList.add("e");
        cList.add("g");

        aList.addAll(bList);

        aList.add("a");
//        System.out.println();
//        System.out.println(aList.get(3));
//        System.out.println(aList.get(10));
//        System.out.println(aList.contains("a"));
//        System.out.println(aList.indexOf("a"));
//        System.out.println(aList.lastIndexOf("a"));

//        for (int i = 0; i < aList.size(); i++) {
//            System.out.println(aList.get(i));
//        }

        for (String s : aList) {
            System.out.println(s);
        }
    }
}
