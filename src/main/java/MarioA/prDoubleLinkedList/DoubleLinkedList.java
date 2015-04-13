package MarioA.prDoubleLinkedList;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> {
	private class NodeDoubleLinkedList<Type> {
		Type element;
		NodeDoubleLinkedList<Type> prev;
		NodeDoubleLinkedList<Type> next;

		public NodeDoubleLinkedList(Type element,
				NodeDoubleLinkedList<Type> prev, NodeDoubleLinkedList<Type> next) {
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
	}

	private NodeDoubleLinkedList<T> first;
	private NodeDoubleLinkedList<T> last;

	public DoubleLinkedList() {
		this.first = null;
		this.last = null;
	}

	public DoubleLinkedList(List<T> list) {
		for (T elems : list) {
			this.insertEnd(new NodeDoubleLinkedList<T>(elems, null, null));
		}
	}

	public boolean isEmpty() {
		return this.first == null && this.last == null;
	}

	private void insertEnd(NodeDoubleLinkedList<T> nodeToInsert) {
		if (this.isEmpty()) {
			this.first = nodeToInsert;
			this.last = nodeToInsert;
		} else {
			this.last.next = nodeToInsert;
			nodeToInsert.prev = this.last;
			this.last = this.last.next;

		}
	}
	public void insertEnd(T elem){
		this.insertEnd(new NodeDoubleLinkedList<T>(elem,null,null));
	}
	public void insertBeginning(T elem){
		this.insertBeginning(new NodeDoubleLinkedList<T>(elem,null,null));
	}
	private void insertBeginning(NodeDoubleLinkedList<T> nodeToInsert) {
		if (this.isEmpty()) {
			this.first = nodeToInsert;
			this.last = nodeToInsert;
		} else {
			this.first.prev = nodeToInsert;
			nodeToInsert.next = this.first;
			this.first = this.first.prev;

		}
	}
	
	private NodeDoubleLinkedList<T> find(T elem){
		boolean found = false;
		NodeDoubleLinkedList<T> nodeAux=first;
		while(nodeAux!=null&&!found){
			if(nodeAux.element.equals(elem)){
				found = true;
			} else{
				nodeAux = nodeAux.next;
			}
		}
		return nodeAux;
	}
	public boolean contains(T elem){
		return this.find(elem) != null;
	}
	private NodeDoubleLinkedList<T> getNode(int index){
		int cont = 0;
		boolean found = false;
		NodeDoubleLinkedList<T> nodeAux=first;
		while(nodeAux!=null&&!found){
			if(cont==index){
				found = true;
			} else{
				cont++;
				nodeAux = nodeAux.next;
			}
		}
		if(!found){
			throw new DoubleLinkedListException("Index out of list bounds.");
		}
		return nodeAux;
	}
	
	public T get(int index){
		T res = this.getNode(index).element;
		return res;
	}
	
	public void remove(int index){
		this.remove(this.getNode(index));
	}
	
	private void remove(NodeDoubleLinkedList<T> node){
		if(node.prev==null){
			this.first=this.first.next;
		} else if(node.next==null){
			this.last=this.last.prev;
		} else {
			node.prev.next = node.next;
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Iterator<T> iter = this.iteratorForwards();
		while (iter.hasNext()) {
			sb.append(iter.next().toString());
			if(iter.hasNext()){
				sb.append(", ");
			}
		}
		return sb.append("]").toString();

	}

	/**
	 * 
	 * @return
	 */
	public Iterator<T> iteratorForwards() {
		return new DoubleLinkedListIteratorForwards();
	}

	/**
	 * 
	 * @return
	 */
	public Iterator<T> iteratorBackwards() {
		return new DoubleLinkedListIteratorBackwards();
	}

	private class DoubleLinkedListIteratorForwards implements Iterator<T> {
		private NodeDoubleLinkedList<T> actual;

		public DoubleLinkedListIteratorForwards() {
			this.actual = first;
		}

		public boolean hasNext() {
			return actual != null;
		}

		public T next() {
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			NodeDoubleLinkedList<T> aux = actual;
			actual = actual.next;
			return aux.element;
		}

		public void remove() {
			throw new UnsupportedOperationException();

		}

	}

	private class DoubleLinkedListIteratorBackwards implements Iterator<T> {
		private NodeDoubleLinkedList<T> actual;

		public DoubleLinkedListIteratorBackwards() {
			this.actual = last;
		}

		public boolean hasNext() {
			return actual != null;
		}

		public T next() {
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			NodeDoubleLinkedList<T> aux = actual;
			actual = actual.prev;
			return aux.element;
		}

		public void remove() {
			throw new UnsupportedOperationException();

		}

	}
}
