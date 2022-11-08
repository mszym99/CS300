/*
 * Matthew Szymanski
 * CSCD300
 * hw8
 */
public class myQueue {

	private class Node {
		
		private Object data;
		private Node next;
		
		private Node(Object data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private Node head, tail;
	private int size;
	
	public myQueue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	
	public void enqueue(Object element) {
		Node nn = new Node(element);
		
		if(this.size == 0) { //empty base
			this.head = nn;
			this.tail = nn;
		}
		
		this.tail.next = nn;
		this.tail = nn;
		this.size ++;	
	}
	
	public Object dequeue() throws Exception {
		if (this.size == 0) {
			throw new IllegalArgumentException();
		}
		Object temp = this.head.data;
		
		this.head = this.head.next;
		this.size --;
		if (this.size == 0) {
			this.tail = null;
		}
		return temp;
	}
	public int getSize() {
		return this.size;
	}
}	

