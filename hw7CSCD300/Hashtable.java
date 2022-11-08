
import java.util.LinkedList;

public class Hashtable {
	private class HashtableRecord{
		private Object key;
		private Object value;

		public HashtableRecord() {
			this.key = null;
			this.value = null;
		}

		public HashtableRecord(Object inKey, Object inData) {
			this.key = inKey;
			this.value = inData;
		}

		/* Equality can be based on key alone because there can't be
		 * 2 records with the same key in the table */
		public boolean equals(Object obj) {
			if (obj instanceof HashtableRecord) {
				HashtableRecord node = (HashtableRecord)obj;
				return this.key.equals(node.key);
			}
			else {
				return false;
			}
		}

		public String toString() {
			return "Key: ["+this.key+"] Value: ["+this.value+"]";
		}
	}
	//
	//
	private final int tableSize = 101;
	private int numElements;
	private Object [] table;
	
	//constructor
	public Hashtable(int realSize) {
		this.table = new Object[realSize];
		this.numElements = 0;
	}
	
	public Hashtable() {
		this.table = new Object[this.tableSize];
		this.numElements = 0;
	}
	
	private int hash(Object key) {

		/* Start with a base, just so that it's not 0 for empty strings */
		int result = 42; //start at hard coded base

		String inputString = key.toString().toLowerCase();
		//System.out.println("hash string is:" + inputString + "\n");

		char [] characters = inputString.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			char currentChar = characters[i];
			int j = (int)currentChar;
			//System.out.println("j = " + j );
			result += j;
		}
		return (result % this.table.length);
	}

	public void put(Object key, Object data) {
		if (data == null || key == null) {
			System.err.println("ERROR: Either the key or the data are null");
			return;
		}

		// If trying to add duplicate keys, that means 
		// we like to update the value associated with that existing key.
		// We first delete the existing mapping, then insert a new record that key.
		if (this.contains(key)) {
			remove(key);
		}
		// Find out where in our array should the new item goes 
		int pos = this.hash(key);
		// If nothing exists in the position, create a new linked list there 
		if (this.table[pos] == null) {
			this.table[pos] = new LinkedList<HashtableRecord>();
		}
		
		LinkedList<HashtableRecord> theList = (LinkedList<HashtableRecord>) this.table[pos];
		// Add to the linked list in the appropriate position
		theList.add(new HashtableRecord(key, data));
		this.numElements++;
	}
	
	public void put(Object [] keys, Object [] inputData) {
		for (int i = 0; i < inputData.length; i++) {
			this.put(keys[i], inputData[i]);
		}
	}
    
    public Object get(Object key) {
    	
    	int pos = this.hash(key); // position gets this.hash(key).
        LinkedList<HashtableRecord> thisList = (LinkedList<HashtableRecord>) this.table[pos]; // list head.
       
        if(thisList != null) { //while list is not empty
            for(int i = 0; i < thisList.size(); i++) {// for loop
                Object val = ((HashtableRecord) thisList.get(i)).value; // creates object val to get the hashtable record
                														// by getting the value at i
                Object compare = ((HashtableRecord) thisList.get(i)).key; // creates object compare at value i
                															// this is used down in compare.equals(key)
                if(compare.equals(key)) {								// to see if compare matches the key 
                    return val; // if it equals then return the value.
                }
            }
        } // other
        return null; //return null.
    }

	//return type is different from the standard Map interface.
	public void remove(Object key) {
		int pos = this.hash(key);

		if (this.table[pos] != null) {
			HashtableRecord node = new HashtableRecord();
			node.key = key; //in order to use the equals() method in HashtableNode
			LinkedList<HashtableRecord> theList = (LinkedList<HashtableRecord>) this.table[pos];
			//
			boolean removed = theList.remove(node);
			if( theList.size() == 0 )
				this.table[pos] = null;
			if( removed )
				this.numElements--;
		}
	}

	public void remove(Object [] keys) {
		for (int i = 0; i < keys.length; i++) {
			this.remove(keys[i]);
		}
	}

	public String toString() {
		String buffer = "";

		buffer += "{\n";
		for (int i = 0; i < this.table.length; i++) {
			if (this.table[i] != null) {
				buffer  = buffer +  "\t" + (LinkedList)this.table[i] + "\n" ;
			}
		}
		buffer += "}";
		return buffer;
	}

	public int getNumElements() {
		return this.numElements;
	}

	public boolean contains(Object key) {
		boolean result = false;
		int hash = this.hash(key);

		if (this.table[hash] != null) {
			HashtableRecord node = new HashtableRecord();
			node.key = key;
			if (((LinkedList<HashtableRecord>)this.table[hash]).indexOf(node) > -1) {
				result = true;
			}
		}
		return result;
	}
	
	public static void main(String argv[]){
		Hashtable myhash = new Hashtable();
		
		//test of strings
		System.out.println("Inital hash table is: \n" + myhash);
		myhash.put("smith", 30);
		myhash.put("john", 10);
		System.out.println("After two adds, hashtalbe is: \n" + myhash);
		myhash.put("green", 10);
		myhash.put("green", 60); //this will be added successfully, updating existing record.
		System.out.println("After four adds, hashtalbe is: \n" + myhash);
		
		myhash.remove("green");
		System.out.println("After remove green, hashtalbe is: \n" + myhash);
		/*
		System.out.println("Inital hash table is: \n" + myhash);
		myhash.put(11.5f, "smith");
		myhash.put(100.9f, "john");
		System.out.println("After two adds, hashtalbe is: \n" + myhash);
		myhash.put(3.4, "green");
		myhash.put(3.4, "white"); //this successfully updated the existing record with key = 3.4
		System.out.println("After total four adds, hashtalbe is: \n" + myhash);
		
		myhash.remove(3.4);
		System.out.println("After remove 3.4, hashtalbe is: \n" + myhash);
	*/
	}

}
