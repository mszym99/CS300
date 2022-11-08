/*
Matthew Szymanski
CSCD300
10/11/2021
HW2
*/
public class CDoublyLinkedList {

	private class Node {
		private Object data;   //Assume data implemented Comparable
		private Node next, prev;
		private Node(Object data, Node pref, Node next)
		{
			this.data = data;
			this.prev = pref;
			this.next = next;
		}
	}

	private Node head;
	private int size;

	public CDoublyLinkedList() {
		this.head = new Node(null, null, null );
		this.head.next = this.head;
		this.head.prev=this.head;
		this.size = 0;
	}

	public boolean isEmpty() {
		return this.head == this.head.next;
	} 
	
	// Add Object data to start of this LinkedList
	// Please DO NOT change this addFirst() method.
	// You must keep and include this provided addFirst() method
	//      in your source code.
	public void addFirst(Object data) {
		Node nn = new Node(data, this.head, this.head.next);
		this.head.next.prev = nn;
		this.head.next = nn;
		this.size ++;
	}

	// write a method void addLast(Object data) that will insert 
	// the piece of data at the end of the current list.
	// Note: this list is allowed to store null data element in its list node.
	public void addLast(Object data) { // basically the opposite of addFirst
      Node nn = new Node(data, this.head.prev, this.head);
      this.head.prev.next = nn; //Now needs to point to the prev because we are adding last and not first
      this.head.prev = nn;
      this.size ++;
	}
	
	// Write the subListOfSmallerValues method.  
	// It should return a CDoublyLinkedList object 
	//     containing data that is smaller than the value passed to the method.
        // If a null data element in this list is encountered, you can skip it.
        // You need to use the CompareTo() method to determine which object is smaller.
        // If list A contains {9, 11, 14, 6, 4, 7} and you call  A.subListOfSmallerValues(10),
        // the method call returns a list that contains data in A that is smaller than 10, the passed-in argument.
        // That is, the returned list contains { 9, 6, 4, 7}.
	public CDoublyLinkedList subListOfSmallerValues(Comparable data) {
        CDoublyLinkedList nCDLL = new CDoublyLinkedList(); // new CDLL
        
        Node cur; // cur reference
        
        for(cur = this.head.next; cur.next != this.head.next; cur = cur.next) { //for loop walk through
        
            if(cur.data != null && ((Comparable) cur.data).compareTo(data) < 0) { // compare data during walk
                nCDLL.addLast(cur.data); // use addLast method I created earlier
            }
        }
        return nCDLL; //change this as needed.
    }
	
	// This method should remove the first occurrence of the data from the list, 
        //      starting at the *BACK* of the list. 
        // It scans the list from back to the front by following the prev links. 
	// The method should return true if successful, false otherwise. 
	// Note that list node may contain null data element. Please handle this edge case.
	public boolean removeStartingAtBack(Object dataToRemove) {
	   Node cur = this.head.prev; // cur
      while (cur != this.head) { // walk through the list
         if (cur.data == null && dataToRemove == null) { //check for null 
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            size --; 
            return true;
         }
         if (cur.data != null && cur.data.equals(dataToRemove)) { //check for other cases dataToRemove
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            size --;
            return true;
         }
         cur = cur.prev;
      }
		return false;//change this as needed.
	}
	
	// Returns the index of the last occurrence of the specified element in this list, 
	//     or -1 if this list does not contain the element. 
	// More formally, returns the highest index i 
	//     such that (o==null ? get(i)==null : o.equals(get(i))), 
	//     or -1 if there is no such index.
	// Note: a list node may store a null data element. Please handle this edge case.
	public int lastIndexOf(Object o) {
      Node cur = this.head.prev; //cur
      int i = this.size - 1;
      while (i != -1) {
         if (cur.data == null && o == null) { //check for null
             
            return i;
         }
         if (cur.data != null && cur.data.equals(o)) {//check for other cases
            
            return i;
         }            //zero has been hard for me to figure out. it keeps on saying -1 for me.
         i--;
         cur = cur.prev;
      }
      
		return -1; //change this as needed.
	}
	
	
	// Removes from this list all of its elements that 
	//    are NOT contained in the specified linkedlist other.
	// If any element has been removed from this list,
	//    returns true. Otherwise returns false.
	// If other list is null, throws NullPointerException.
        // Helper methods are allowed.
        
	public boolean retainAll(CDoublyLinkedList other) throws NullPointerException {
      
      if(other.isEmpty()) {
         throw new NullPointerException("Null Pointer Exception");
      }
      
	    return false; //change this as needed.
	}
	

        // Write this method to sort this list using insertion sort algorithm, 
        //      as we have learned in the classroom.
	public void insertionSort() {
		Node lastSorted, sortedWalker;
      Comparable firstUnsortedData; //insertion sort method from class // FUD
      for(lastSorted = this.head; lastSorted != this.head.prev; lastSorted = lastSorted.next) {
         firstUnsortedData = (Comparable)lastSorted.next.data; //FUD -> lastSorted
         for(sortedWalker = lastSorted; sortedWalker != head && ((Comparable)sortedWalker.data).compareTo(firstUnsortedData) > 0;
            sortedWalker = sortedWalker.prev) {
               sortedWalker.next.data = sortedWalker.data;
               }
            sortedWalker.next.data = firstUnsortedData; //SortedWalker -> FUD
         }
      }   
	
	
	@Override
	public String toString() {
		String result = "{";
	    for (Node node = this.head.next; node != this.head; node = node.next) {
	    		if(node.next != this.head)
	    			result += node.data + "->"; 
	    		else
	    			result += node.data;
	    }
	    return result + "}";
	  }
}
			