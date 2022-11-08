/*
 * Matthew Szymanski
 * CSCD300
 * hw8
 */
public class myLinkedList {
	private class Node {
		private Object data;
		private Node next, prev;
		private Node(Object data, Node next, Node prev) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	private Node head;
	private int size;
	
	
	public myLinkedList() {
		this.head = new Node(null, null, null);
		this.head.next = this.head;
		this.head.prev = this.head;
		this.size = 0;
	}
	
	public void addLast(Object data) {
		Node nn = new Node(data, this.head, this.head.prev);
		this.head.prev.next = nn;
		this.head.prev = nn;
		this.size ++;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean isSorted() {
		
		for(Node cur = this.head.next; cur.next != this.head; cur = cur.next) {
			if(((Comparable)cur.data).compareTo(cur.next.data) > 0) {
				return false;
			}	
		}
		return true;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void MergeSort() throws Exception {
		myQueue q = new myQueue();	
		myLinkedList a = new myLinkedList();
		myLinkedList b = new myLinkedList();
		myLinkedList temp = new myLinkedList();
		
		for(Node cur = this.head.next; cur != this.head; cur = cur.next) {
			myLinkedList nList = new myLinkedList();
			nList.addLast(cur.data); ///here problem
			q.enqueue(nList);
		}
		
		while(q.getSize() > 1) {
			a = (myLinkedList)q.dequeue();
			b = (myLinkedList)q.dequeue();
			temp = merge(a, b);
			q.enqueue(temp);
		}
		q.dequeue();
		this.head = temp.head;
	}
	
	public Object removeFirst() throws Exception {
		if (this.size == 0) {
			throw new IllegalArgumentException();
		}
		
		Node cur = this.head.next;
		this.head.next = cur.next;
		
		cur.next.prev = this.head;
		this.size --;
		
		
		return cur.data;
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public myLinkedList merge(myLinkedList sublistA, myLinkedList sublistB) throws Exception {
		
		myLinkedList S = new myLinkedList();
		
		while(sublistA.size != 0 && sublistB.size != 0) {
			if(((Comparable)sublistA.getFirst()).compareTo((Comparable)sublistB.getFirst()) < 0) {
				S.addLast(sublistA.removeFirst());
			}
			else {
				S.addLast(sublistB.removeFirst());
			}
		}
			while(sublistA.size != 0) {
				S.addLast(sublistA.removeFirst());
			}
			
			while(sublistB.size != 0) {
				S.addLast(sublistB.removeFirst());
			}
		
		return S;
		
	}
	
	public Object getSize() {
		return this.size;
	}
	
	public Object getFirst() {
		return this.head.next.data;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void InsertionSort() {
		Node lastSorted, sortedWalker;
      @SuppressWarnings("rawtypes")
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
}

	
