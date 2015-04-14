package org.iis.prdoublelinkedlist;

import java.util.ArrayList;
import java.util.List;

public class App {
    private App() {
    }

    public static void main(String[] args) {
        List<Integer> listArr = new ArrayList<Integer>();
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
        System.out.println(list);
        for (int i = 0; i < 5; i++) {
            listArr.add(i);
        }
        list = new DoubleLinkedList<Integer>(listArr);
        System.out.println(list);
        System.out.println(list.size());
        list.remove(3);
        System.out.println(list);
        System.out.println(list.size());

    }
}
