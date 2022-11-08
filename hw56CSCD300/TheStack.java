/*
 * Matthew Szymanski
 * 11/2/2021 
 * HW56
 * 
 */
package hw56;

public class TheStack {
	private Object val;
	private TheStack prev;
	private int size;
	
	public TheStack() {
	      //empty cons.
	   }
	
	public TheStack(TheStack prev, Object val) {
		this.prev = prev; //set values
		this.val = val;
		this.size++; //increase size
	}
	   
	   public void push(Object d) { //push and adds value on top of the stack
	      this.prev = new TheStack(this.prev, this.val); // implement new stack
	      this.val = d; // val gets obj being pushed
	      this.size++; //size increased
	   }
	   
	   
	   public Object top() {
	   //returns the top value
	      if (size == 0) { //base
	         return -1;
	      }
	      return this.val; //return top value
	   }
	   
	   public Object pop() {
	   
	      if (this.isEmpty()) {
	         System.out.println("Stack is empty!"); // empty stack
	      }
	      
	      Object temp = this.val; // create temp to store val
	      
	      this.size--; // decrease size
	      return temp; // returns the popped val
	   }
	   
	   
	   
	   public int size() {
	      return this.size; // returns the size
	   }
	   
	   
	   
	   public boolean isEmpty() {   
	      return this.prev == null; //checks if empty
	      
	   }

}
