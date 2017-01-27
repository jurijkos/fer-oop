package hr.fer.oop.lab4.prob2;

//import hr.fer.oopj.lab4.data.StudentGrades;

/**
 * The SimpleHashtable class represents a hash table used to implement
 * an associative array, a structure that can map keys to values.
 * <p>
 * A hash table uses a hash function to compute an index into an array of
 * slots, from which the desired value can be found.
 * </p>
 * @author Jurij Kos
 *
 * @param <K> type of argument for key.
 * @param <V> type of argument for value.
 */


public class SimpleHashtable<K,V> {
	/**Holds current size of table*/
	private int size;
	/**Table in which data is hold.*/
	private TableEntry<K, V>[] table;
	
	
	/**
	 * 
	 * @author Jurij Kos
	 *
	 * @param <K> type of argument for key.
	 * @param <V> type of argument for value.
	 */
	
	private static class TableEntry<K,V> {
		/**It is key in our key-value dictionary*/
		private K key;
		private V value;
		/**It points to the next element in this slot.First one points to null*/
		private TableEntry<K, V> next;
		
		public TableEntry(K key, V value, TableEntry<K,V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
			
		}
		public K getKey() {
			return this.key;
		}
		public V getValue() {
			return this.value;
		}
		
		public void setValue(V value) {
			this.value = value;
		}
		@Override
		public String toString(){
			return key + " " + value; 
		}
	}
	

	/**
	 * Constructs a new SimpleHashtable object that stores entries in a
	 * table sized 16. Object is initally empty.
	 */
	@SuppressWarnings("unchecked")
	public SimpleHashtable() {
		table = new TableEntry[16];
		size = 0;
	}
	/**
	 * Constructs a new SimpleHashtable object that stores entries in a
	 * table sized the first power of two that is greater than or equal to the
	 * argument value. The object is initially empty.
	 * 
	 * @param capacity a value of table
	 */
	@SuppressWarnings("unchecked")
	public SimpleHashtable(int capacity) { 
		int tableSize;
		if (capacity <= 0)
			throw new IllegalArgumentException("Hash table size could not be zero or"
					+ " negative number");
		tableSize = (int)Math.pow(2, Math.ceil(Math.log(capacity) / Math.log(2)));
		table = new TableEntry[tableSize];
		size = 0;
	}
	
	/**
	 * Determines slot to store our key-value data.
	 * @return slot value to store (0 - tableLength-1)
	 */
	private int determineSlot(K key) {
		int hashCode = key.hashCode();
		if(hashCode < 0)
			hashCode = -hashCode;
		return hashCode % table.length;
	}
	
	/**
	 * Puts a new entry into the given object SimpleHashtable
	 * by determining the key's hash code for insertion.
	 * <p>Time complexity: O(1)</p>
	 * 
	 * @param key entry's key
	 * @param value entry's value
	 */
	public void put(K key,V value) {
		if(key==null){
			//System.err.println("Key cant be null!");
			return;
		}
		
		int slot=determineSlot(key);
		
		//if the slot is empty
	/*	if(table[slot]==null){
			TableEntry<K, V> newElement=new TableEntry<K,V>(key, value, null);
			table[slot]=newElement;
			++size;
			return;
		}
		*/
		//check the elements in the slot
		TableEntry<K, V> current = table[slot];
		while (current != null) {
			if (current.key.equals(key)) {
				current.setValue(value);
				return;
			}
			if (current.next == null){
				current.next=new TableEntry<K, V>(key, value, null);
				size++;
				return;
			}
			current = current.next;
		}
		//check the last element in the slot

		table[slot] = new TableEntry<K, V>(key, value, null);
		size++;

	}
	/**
	 * Returns a value of an entry given with its key.
	 * If the searched entry does not exist, null is returned.
	 * <p>Time complexity: O(1)</p>
	 * 
	 * @param key entry's key
	 * @return existing entry if found, null otherwise
	 */
	public V get(K key) {
		if (key == null)
			//System.err.println("Key cant be null!");
			return null;
		if (!containsKey(key)) {
			return null;
		}
		int slot = this.determineSlot(key);
		TableEntry<K, V> element = table[slot];
		while (true) {
			if (element.key.equals(key))
				return element.getValue();
			if (element.next == null)
				return null;
			element = element.next;
		}
		
	}
	public int size() { 
		return size;
	}
	
	/**
	 * Returns true if SimpleHashtable object contains
	 * the desired key. False otherwise.
	 * <p>Time complexity: O(1)</p>
	 * 
	 * @param key entry's key
	 * @return true if object contains the desired key. False otherwise.
	 */
	public boolean containsKey(K key) {
		if(key==null){
			//System.err.println("Key cant be null!");
			return false;
		}
		
		int slot=determineSlot(key);
		TableEntry<K, V> element = table[slot];

		// Check if the wanted element is somewhere in list
		while (true) {
			if (element.key.equals(key)) {
				return true;
			}
			
			if (element.next == null)
				return false;
			element = element.next;
		}
		
		
	}
	
	
	/**
	 * Returns true if SimpleHashtable object contains
	 * the desired value. False otherwise.
	 * <p>Time complexity: O(n)</p>
	 * 
	 * @param value entry's value
	 * @return true if object contains the desired value. False otherwise.
	 */
	public boolean containsValue(V value) {
		for(TableEntry<K, V> element : table){
			while(element.next!=null){
				if(element.value.equals(value)){
					return true;
				}
				element=element.next;
			}
			if(element.value.equals(value)){
				return true;
			}
		}
		return false;
			
		
	}
	
	/**
	 * Removes an existing entry with the given key. Prints out
	 * an error message if there is no entry with the given key. Complexity O(1) 
	 * @param key
	 */
	public void remove(K key) {
		if (key ==null){
			//System.err.println("Key can t be null");
			return;
		}
		if (!containsKey(key)) {
			System.out.println("No such element to remove");
		}
		int slot = determineSlot(key);
		TableEntry<K,V> element = table[slot];
		if (element.key.equals(key)) {
			table[slot] = element.next;
			size--;
			return;
		}
		// Check if the wanted element is somewhere in list
		while (element.next != null) {
			if (element.next.getKey().equals(key)) {
				element.next = element.next.next;
				size--;
				return;
			}
			element = element.next;
		}

		
	}
	/**
	 * 
	 * @return true if object is empty(size == 0) ,otherwise false
	 */
	public boolean isEmpty() {
		if (this.size == 0)
			return true;
		return false;
	}
	@Override
	public String toString() {
		String string="";
		
		for(TableEntry<K, V> element : table){
			while(element.next!=null){
				string+=element.key+" => "+element.value+System.lineSeparator();
				element=element.next;
			}
			string+=element.key+" => "+element.value+System.lineSeparator();
		}
		return string;
	}
	/**
	 * 
	 * @return array of all values of Students.
	 */
	public TableEntry<K, V>[] getTable() {
		return table;
	}
	/**
	 * It adds all pairs form other to table of object that
	 * is called on. 
	 * @param other all pairs to add current hashtable.
	 */
	public void addAll ( SimpleHashtable<K, V> other ) {
		TableEntry<K, V>[] newTable = other.getTable();
		for (TableEntry<K, V> tableEntry : newTable) {
			this.put(tableEntry.getKey(), tableEntry.getValue());
		} 
	}
	 	 
	  
	 
}
