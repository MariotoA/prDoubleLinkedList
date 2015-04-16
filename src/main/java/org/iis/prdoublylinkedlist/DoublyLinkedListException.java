package org.iis.prdoublylinkedlist;

public class DoublyLinkedListException extends RuntimeException {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    public DoublyLinkedListException() {
        super();
    }

    public DoublyLinkedListException(String msg) {
        super(msg);
    }

    public DoublyLinkedListException(int i) {
        super(Integer.toString(i));
    }

}
