package MarioA.prDoubleLinkedList;

import java.util.ArrayList;
import java.util.List;


public class App {
	public static void main(String[] args) {
		List<Integer> listArr = new ArrayList<Integer>();
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		System.out.println(list);
		for(int i = 0; i<10; i++){
			listArr.add(i);
		}
		list = new DoubleLinkedList<Integer>(listArr);
		list.insertBeginning(1);
		list.insertEnd(94);
		System.out.println(list);
	}
}
