package org.iis.prdoublylinkedlist;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {
    private class NodeDoublyLinkedList<E> {
        E element;
        NodeDoublyLinkedList<E> prev;
        NodeDoublyLinkedList<E> next;

        public NodeDoublyLinkedList(E element, NodeDoublyLinkedList<E> prev,
                NodeDoublyLinkedList<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
    
    private NodeDoublyLinkedList<T> first;
    private NodeDoublyLinkedList<T> last;
    private int size;
    private static final String errorInsertNullNode = "Insertion %s a null node.";
    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public DoublyLinkedList(List<T> list) {
        this();
        for (T elems : list) {
            this.insertEnd(new NodeDoublyLinkedList<T>(elems, null, null));
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void insertEnd(NodeDoublyLinkedList<T> nodeToInsert)
            throws DoublyLinkedListException {
        if (nodeToInsert == null) {
            throw new DoublyLinkedListException(String.format(errorInsertNullNode,"of"));
        }
        if (this.isEmpty()) {
            this.first = nodeToInsert;
            this.last = nodeToInsert;
        } else {
            this.last.next = nodeToInsert;
            nodeToInsert.prev = this.last;
            this.last = this.last.next;

        }
        this.size++;
    }

    public void insertEnd(T elem) {
        this.insertEnd(new NodeDoublyLinkedList<T>(elem, null, null));
    }

    public void insertBefore(T elem, int position) {
        NodeDoublyLinkedList<T> nodeToInsert = new NodeDoublyLinkedList<T>(
                elem, null, null);
        if (position == 0) {
            this.insertBeginning(nodeToInsert);
        } else if (position == this.size) {
            this.insertEnd(nodeToInsert);
        } else {
            this.insertBefore(nodeToInsert, this.getNode(position));
        }
    }

    public void insertAfter(T elem, int position) {
        NodeDoublyLinkedList<T> nodeToInsert = new NodeDoublyLinkedList<T>(
                elem, null, null);
        if (position == this.size - 1) {
            this.insertEnd(nodeToInsert);
        } else {
            this.insertAfter(nodeToInsert, this.getNode(position));
        }
    }

    private void insertAfter(NodeDoublyLinkedList<T> nodeToInsert,
            NodeDoublyLinkedList<T> nodeRef) throws DoublyLinkedListException {
        if (nodeToInsert == null) {
            throw new DoublyLinkedListException(String.format(errorInsertNullNode,"of"));
        } else if (nodeRef == null) {
            throw new DoublyLinkedListException(String.format(errorInsertNullNode,"after"));
        }
        nodeRef.next.prev = nodeToInsert;
        nodeToInsert.next = nodeRef.next;
        nodeToInsert.prev = nodeRef;
        nodeRef.next = nodeToInsert;
        this.size++;
    }

    private void insertBefore(NodeDoublyLinkedList<T> nodeToInsert,
            NodeDoublyLinkedList<T> nodeRef) throws DoublyLinkedListException {
        if (nodeToInsert == null) {
            throw new DoublyLinkedListException(String.format(errorInsertNullNode,"of"));
        } else if (nodeRef == null) {
            throw new DoublyLinkedListException(String.format(errorInsertNullNode,"before"));
        }
        nodeRef.prev.next = nodeToInsert;
        nodeToInsert.prev = nodeRef.prev;
        nodeToInsert.next = nodeRef;
        nodeRef.prev = nodeToInsert;
        this.size++;
    }

    public void insertBeginning(T elem) {
        this.insertBeginning(new NodeDoublyLinkedList<T>(elem, null, null));
    }

    private void insertBeginning(NodeDoublyLinkedList<T> nodeToInsert)
            throws DoublyLinkedListException {
        if (nodeToInsert == null) {
            throw new DoublyLinkedListException(String.format(errorInsertNullNode,"of"));
        }
        if (this.isEmpty()) {
            this.first = nodeToInsert;
            this.last = nodeToInsert;
        } else {
            this.first.prev = nodeToInsert;
            nodeToInsert.next = this.first;
            this.first = this.first.prev;

        }
        this.size++;
    }

    private NodeDoublyLinkedList<T> find(T elem) {
        boolean found = false;
        NodeDoublyLinkedList<T> nodeAux = first;
        while (nodeAux != null && !found) {
            if (nodeAux.element.equals(elem)) {
                found = true;
            } else {
                nodeAux = nodeAux.next;
            }
        }
        return nodeAux;
    }

    public boolean contains(T elem) {
        return this.find(elem) != null;
    }

    private NodeDoublyLinkedList<T> getNode(int index)
            throws DoublyLinkedListException {
        if (index < 0 || index >= this.size) {
            throw new DoublyLinkedListException("Index out of list bounds.");
        }
        int half = this.size / 2;
        NodeDoublyLinkedList<T> nodeAux;
        if (index < half) {
            nodeAux = this.first;
            for (int i = 0; i < index; i++) {
                nodeAux = nodeAux.next;
            }

        } else {
            nodeAux = this.last;
            for (int i = this.size - 1; i > index; i--) {
                nodeAux = nodeAux.prev;
            }
        }
        return nodeAux;
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        return this.getNode(index).element;
    }

    public void remove(int index) {
        this.remove(this.getNode(index));
    }

    private void remove(NodeDoublyLinkedList<T> node) {
        if (node.prev == null) {
            this.first = this.first.next;
        } else if (node.next == null) {
            this.last = this.last.prev;
        } else {
            node.prev.next = node.next;
        }
        this.size--;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<T> iter = this.iteratorForwards();
        while (iter.hasNext()) {
            sb.append(iter.next().toString());
            if (iter.hasNext()) {
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
        return new DoublyLinkedListIteratorForwards();
    }

    /**
     * 
     * @return
     */
    public Iterator<T> iteratorBackwards() {
        return new DoublyLinkedListIteratorBackwards();
    }

    private class DoublyLinkedListIteratorForwards implements Iterator<T> {
        private NodeDoublyLinkedList<T> actual;

        public DoublyLinkedListIteratorForwards() {
            this.actual = first;
        }

        @Override
        public boolean hasNext() {
            return actual != null;
        }
        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            NodeDoublyLinkedList<T> aux = actual;
            actual = actual.next;
            return aux.element;
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();

        }

    }

    private class DoublyLinkedListIteratorBackwards implements Iterator<T> {
        private NodeDoublyLinkedList<T> actual;

        public DoublyLinkedListIteratorBackwards() {
            this.actual = last;
        }
        @Override
        public boolean hasNext() {
            return actual != null;
        }
        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            NodeDoublyLinkedList<T> aux = actual;
            actual = actual.prev;
            return aux.element;
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();

        }

    }

}
