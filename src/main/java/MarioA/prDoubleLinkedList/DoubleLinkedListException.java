package MarioA.prDoubleLinkedList;

public class DoubleLinkedListException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DoubleLinkedListException(){
		super();
	}
	public DoubleLinkedListException(String msg){
		super(msg);
	}
	public DoubleLinkedListException(int i){
		super(Integer.toString(i));
	}
	
}
