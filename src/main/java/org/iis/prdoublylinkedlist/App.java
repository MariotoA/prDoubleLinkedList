package org.iis.prdoublylinkedlist;

import java.util.ArrayList;
import java.util.List;

public class App {
    private App() {
    }

    public static void main(String[] args) {
        List<Integer> listArr = new ArrayList<Integer>();
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        System.out.println(list);
        for (int i = 0; i < 5; i++) {
            listArr.add(i);
        }
        list = new DoublyLinkedList<Integer>(listArr);
        System.out.println(list);
        System.out.println(list.size());
        list.insertAfter(2345, 4);
        list.insertBefore(2345, 4);
        System.out.println(list);
        System.out.println(list.size());

    }
}
