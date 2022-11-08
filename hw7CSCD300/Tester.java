public class Tester {

	public static void main(String[] args) {
		
		Hashtable tab=new Hashtable();
		tab.put("abcde", "AA");
		tab.put("acbed", "AB");
		tab.put("abced", "AC");
        tab.put(new Integer(10), "BB");
        tab.put(new Integer(11), "BC");
        tab.put(new Integer(12), "BD");
		tab.put("moist", "CC");
		tab.put("pizza", "CD");
		tab.put("student", "DD");
		tab.put("teacher", "DE");
		tab.put("goodperson", "EE");
		//b) Testing get for things that exist in the list
		String test=(String) tab.get("goodperson");
		System.out.println(test);
		test=(String) tab.get("student");
		System.out.println(test);
		test=(String) tab.get(12);
		System.out.println(test);
		//c) test for data that doesn't exist
		test=(String)tab.get("hello");
		System.out.println(test);
		//d) test for collision, abcde collides with abced and acbde
		test=(String) tab.get("acbed");
		System.out.println(test);
		//The entire list for reference
		//System.out.println(tab);
	
	}

}
