
/* NOTE: PLEASE DO NOT CHANGE OR REVISE ANY CODE IN THIS TESTER */
/* !!! IF YOU CHANGE THIS FILE, YOU GET A ZERO FOR THIS PROJECT !!!! */

public class Tester {

	private static CDoublyLinkedList list0;
	private static CDoublyLinkedList list2;
	private static CDoublyLinkedList list3;
	
	private static void init() {
		list0 = new CDoublyLinkedList();
		list2 = new CDoublyLinkedList();
		list3 = new CDoublyLinkedList();
		list2.addFirst("6:Tony");
		list2.addFirst("5:Tom");
		list2.addFirst("4:Tim");
		list2.addFirst("3:Abby");
		list2.addFirst("2:Morning");
		list2.addFirst("1:Good");
		list0.addFirst(null);
		list0.addFirst("bad");
		list0.addFirst("apple");
		list0.addFirst(null);
	}
	public static void drawLine() {
		System.out.println("-----------------------------");
	}
	
	public static void testAddFirst() { //passed test
		init();
		drawLine();
		System.out.println(list0);
		System.out.println(list2);
		System.out.println(list3);
		drawLine();
	}
	
	public static void testAddLast() { //
		System.out.println("------------------testAddLast()----");
		init();
		list3.addLast("A");
		System.out.println(list3);
		list3.addLast("B");
		System.out.println(list3);
		list3.addLast(null);
		System.out.println(list3);
		list3.addLast("C");
		System.out.println(list3);
		drawLine();
	}
	

	public static void testRemoveStartingAtBack() { 
		init();
		System.out.println("---------------Test removeStartingAtBack---");
		list0.addFirst("apple");
		System.out.println(list0.removeStartingAtBack("notexist")); //false
		System.out.println(list0.removeStartingAtBack("apple")); //true
		System.out.println(list0); //apple, null, bad, null
		System.out.println(list0.removeStartingAtBack(null)); //true
		System.out.println(list0); //apple, null, bad
		list2.removeStartingAtBack("1:Good");
		System.out.println(list2);

		drawLine();
	}
	

	public static void testLastIndexOf() { 
		init();
		System.out.println("------------Test lastIndexOf()-----");
		System.out.println(list3.lastIndexOf("notexist")); //-1
		System.out.println(list0.lastIndexOf(null)); //3
		System.out.println(list2.lastIndexOf(null)); //-1
		System.out.println(list2.lastIndexOf("notexist"));//-1
		System.out.println(list2.lastIndexOf("1:Good"));//0
		System.out.println(list2.lastIndexOf("6:Tony"));//5
		list3.addFirst("B3");
		list3.addFirst("B3");
		list3.addFirst("B3");
		System.out.println(list3.lastIndexOf("B3"));//2
		drawLine();
	}
	
	public static void testSubList() {  
		init();
		list3.addFirst("D");
		list3.addFirst("M");
		list3.addFirst("A");
		list3.addFirst("B");
		list3.addFirst("G");
		list3.addFirst("B");
		list3.addFirst("B");
		list3.addFirst("F");
		System.out.println("--------testSubListOfSmallerValues()----------");
		System.out.println(list3.subListOfSmallerValues("A")); //none
		System.out.println(list3.subListOfSmallerValues("C")); //BBBA
		System.out.println(list3.subListOfSmallerValues("G")); //FBBBAD
		System.out.println(list3.subListOfSmallerValues("Q")); //FBBGBAMD
		drawLine();
	}
	
	public static void testRetainAll() {
		init();
		System.out.println("---------testRetainAll()---------");
		list3.retainAll(list0);
		System.out.println(list3);
		list3.addFirst("C");
		list3.addFirst("C");
		list3.addFirst("6:Tony");
		list3.addFirst("6:Tony");
		list3.retainAll(list2);
		System.out.println(list3);
		init();
		list3.addFirst(null);
		list3.addFirst("bad");
		list3.addFirst(null);
		list3.addFirst("B");
		list3.addFirst("A");
		list3.retainAll(list0);
		System.out.println(list3);
		drawLine();
	}
	
	public static void testSort() {
		init();
		System.out.println("---------test insertionSort()---------");
		list3.insertionSort();
		System.out.println(list3); //none
		list3.addFirst("D");
		System.out.println(list3); //D
		list3.addFirst("F");
		list3.addFirst("E");
		list3.addFirst("G");
		list3.addFirst("E");
		list3.insertionSort();
		System.out.println(list3); //DEEFG
		drawLine();
	}
	
	public static void main(String argv[]) {

		testAddLast(); 
		testSubList(); 
		testLastIndexOf(); 
		testRetainAll(); 
		testRemoveStartingAtBack(); 
		testSort(); 
		
	}//end of main
}
