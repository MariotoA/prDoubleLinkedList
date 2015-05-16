package org.iis.prdoublylinkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class App {
    private App() {
    }

    public static void main(String[] args) {
        //Yet to implement.
    	String[] arrayString = {"hola","paco", "quetal"};
    	String[] array2 = {"hola","paco","que tal"};
    	Object[] arrayFallo = {"hola", 1, new ArrayList<Integer>()};
    	Integer[] arrayInt = {1,3,2};
    	Integer[] arrayInt2 = {1,2};
    	DoublyLinkedList<String> list = new DoublyLinkedList<String>(Arrays.asList(arrayString));

    	Iterator<String> iter = list.iteratorBackwards();
    	String next;
    	while(iter.hasNext()){
    	  next = iter.next();
    	  if(next.equals("quetal")){
    	    iter.remove();
    	  }
    	}
    	
    	System.out.println(list.hashCode());
    }

}
