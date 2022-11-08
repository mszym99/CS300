/*
		Matthew Szymanski
		CSCD300
		10/1/2021
		HW1CSCD300
		
		Extra Credit not attempted.
		
		
*/
package hw1CSCD300;



public class MyLinkedList {
	
	private ListNode head;
	private int size;
	
	//inner class for ListNode
	private class ListNode {
		private Object data;
		private ListNode next;
		private ListNode(Object d) {
			this.data = d;
			this.next = null;
		}
		
	}
	
	public MyLinkedList() {
		this.head = new ListNode(null); //with a dummy head node
		this.size = 0;
	}
	
	
	
	
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// Add Object e to start of this LinkedList
	// Please DO NOT change this addFirst() method.
	// You must keep and include this provided addFirst() method in your source code.
	public void addFirst(Object e)
	{
		ListNode node = new ListNode(e);
		node.next = head.next;
		head.next = node;
		size++;
	}
	
	// Remove(cut out) the first data node(the node succeeding the dummy node) 
	//       in this list, then returns the data in the node removed.
	// If the size of this list is zero, throws an Exception.
	public Object removeFirst() throws Exception {//100%
		ListNode prev = this.head, cur = this.head.next;
		
		// add check to see if index is less than 0 or if index is greater than the size of the index
		if (size == 0) {
			throw new Exception("Exception: LinkedList is empty!");
		}
		else {
			prev.next = cur.next;// prev.next goes over cur to cur.next
			this.size--; //decrease size
		}
		
		return cur.data; //return the data that was removed
	}
	
	// Returns true if this list contains the specified element o. 
	// More formally, returns true if and only if this list contains at least one element e 
	// such that (o==null ? e==null : o.equals(e)).
	// Note: you have to handle the case where a list node stores null data element.
	public boolean contains(Object o) { 
	// Need to do a while loop to walk through and see if the contents contain Object o
		ListNode cur = this.head.next;
		
		while(cur != null) { // walk through while cur != equal null
			if (cur.data == null && o == null) { //check if for sure that cur.data and o are equal to null
				return true;
			}
			if (cur != null && cur.data.equals(o)) { //any other case besides null 
				return true;
			}
			cur= cur.next; // move forward
		}
		return false; 
		
		//change this as you need.
	}
	
	// Removes the first occurrence of the specified element o from this list and returns true, if it is present. 
	// If this list does not contain the element o, it is unchanged and the method returns false.
	// More formally, removes the element o with the lowest index i such that 
	//     (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
	// Note: you have to handle the case where a list node stores null data element.
	public boolean remove(Object o) { // 
		// walk through the list here
		// only stops once the Object o is found for the first time.
		for(ListNode prev = this.head, cur = this.head.next;
				cur != null; prev = cur, cur =cur.next) {
			if(cur.data != null && cur.data.equals(o)) { // checks for anything but null case
				prev.next = cur.next; //removes o
				this.size--; // decrease size
				return true; // returns true when data is removed
			}
			if(cur.data == null && o == null) { // checks for null cases
				prev.next = cur.next; // removes o
				this.size--; // size decreases
				return true;
			}	
		}
		return false; //if nothing is found then return false.
	}

	// Removes all copies of o from this linked list.
	// You have to handle the cases where Object o may 
	//        have zero, one or multiple copies in this list.
	// If any element has been removed from this list, returns true. 
	//        Otherwise returns false.
	// Note: be careful when multiple copies of Object o are stored
	//        in consecutive(adjacent) list nodes.
	//        E.g. []->["A"]->["A"]->["B"]. 
	//        Be careful when removing all "A"s in this example.
	// Note: This list may contains zero, one or multiple copies of null data elements.
	public boolean removeAllCopies( Object o ) { //passed test 
		//After submitting hw1Logic I thought about how to make this method easier and smarter.
		// removeAllCopies will utilize the same code that remove(Object o) uses.
		boolean removeAllBool = remove(o);	 // runs a first time here
		while(remove(o))  { // runs through while loop using previously coded remove(object o)
		}
		return removeAllBool; //change this as you need.
	}
	
	// Insert data elements from linkedlist A and B alternately into 
	//    a new linkedlist C, then returns C.
        // Follow the pattern to pick items in list A and B, 
        //        linkedlist A->linkedlist B->linkedlist A->linkedlist B …
	// If A is longer than B, append remaining items in A to C
	//     when the end of B is first reached.
	// If B is longer than A, append remaining items in B to C
	//     when the end of A is first reached.
	// E.g1 A = {1, 3, 5, 7, 9} and B = {2, 4, 6}; and 
	//       C will be {1, 2, 3, 4, 5, 6, 7, 9}.
        //
	// E.g2 A = {1, 3, 5} and B = {2, 4, 6, 8, 10}; and 
	//       C will be {1, 2, 3, 4, 5, 6, 8, 10}.
	// Note: after this method is called, both list A and B are UNCHANGED.
	public static MyLinkedList interleave(MyLinkedList A, MyLinkedList B) {
			int last = Math.max(A.size(), B.size()); // find the max size of index
			MyLinkedList C = new MyLinkedList(); // create new LL C
			for (int i = 0; i < last; i++) { // for loop walks through
				if(i < A.size()) { // using the add method
					C.add(A.get(i)); //here
				}
				if(i < B.size()) {
					C.add(B.get(i));	//using the add method
				}
				}
		return C; //returns C LL
	}
	
	// Inserts the specified element at the specified position in this list. 
	// Shifts the element currently at that position (if any) and any subsequent
	//     elements to the right (adds one to their indices).
	// if(index < 0 or index > this.size), throws IndexOutOfBoundsException.
	
	// E.g, if this list is [dummy]->["A"]->["B"]->["C"] with size = 3.
	//   add(0,D) will result in [dummy]->["D"]->["A"]->["B"]->["C"].
	//   Continuing on the previous add() call, add(1,"E") will
	//   change the existing list to [dummy]->["D"]->["E"]->["A"]->["B"]->["C"].
	public void add(int index, Object o) {
			if(index < 0 || index >this.size) { // if the index does not pass these parameters then it throws a new 
																		// IndexOutOfBoundsException
				throw new IndexOutOfBoundsException("Index Passed in not valid!");
			
			}
			ListNode cur = this.head; // using a dummy head node
			int i = 0; // i for our "Ticker"
			
			while(i < index) { // check up to the specified index while incrementing the ticker i
				cur = cur.next;
				i++;
			}
			//Once i = index then create new ListNode o
			// set Listnode nn.next to cur.next and cur.next to nn to implement the "loose wires"
			ListNode nn = new ListNode(o);// Might need to add a new constructor? //ListNode nn 
			nn.next = cur.next;
			cur.next = nn;
			
			this.size++;
	}
	

	// Returns the element at the specified index in this list.
	// Be noted that the listnode at head.next has index 0 and 
	//      the last list node has index of size()-1.
	// if index < 0 or index >= this.size, throws IndexOutOfBoundsException.
	public Object get(int index) throws IndexOutOfBoundsException{
		
		ListNode cur = this.head.next; // set cur to this.head.next
		//I ran into a problem when setting cur to this.head only, but after setting it to this.head.next it worked
		
		if (index < 0 || index >= this.size) { // check the bounds of the index
			throw new IndexOutOfBoundsException("Provided index is out of bounds! 4");
		}
		int i = 0; //ticker
		while (i != index) {
			cur = cur.next; // Walks through the LL
			i ++;
		}
		return cur.data; // returns data
	}
	
	// Removes (cuts out) the list node at the specified index in this list. 
	// Returns the data element in the node that is removed.
	// Be noted that the list node at head.next has index 0 and 
	//      the last list node has index of size()-1.
	// if index < 0 or index >= this.size, throws IndexOutOfBoundsException.
	public Object remove(int index) throws IndexOutOfBoundsException {
		ListNode prev = this.head, cur = this.head.next;
		if (index < 0 || index >= this.size) { // Always assume the worst
			throw new IndexOutOfBoundsException("Provided index is out of bounds! 2");
		}
		else { //remove and decrease size
			prev.next = cur.next;
			size --;
		}
		return cur.data; //change this as you need.
	}

	
	//Add the object e to the end of this list.
	// it returns true, after e is successfully added.
	public boolean add(Object e) {
		ListNode cur = this.head; // set cur to the head
			while (cur.next != null) { // loops through until the null is found
				cur = cur.next;
			}
			//create nn
				ListNode nn = new ListNode(e);
				cur.next = nn; //connect the one loose end
				// increase size
				size ++;
				
		return true; //change this as you need. 
		
	} 
	
        //Please DO NOT Change the following toString() method!!!
        //You must include the following toString() method in your source code.
	@Override
	public String toString() {
		String result = "{";
	    for (ListNode node = this.head.next; node != null; node = node.next) {
	    		if(node.next != null)
	    			result += node.data + "->"; 
	    		else
	    			result += node.data;
	    }
	    return result + "}";
	  }
}

