import static org.junit.Assert.*;

import org.junit.Test;

public class MyArrayListTest {

	@Test
	public void testConstructorAndInitialCapacity() throws Exception {
		MyArrayList<String> testArray = new MyArrayList<String>();
		assertEquals(10,testArray.getInitialCapacity());
		
		int capacity = 3;
		MyArrayList<String> testArray2 = new MyArrayList<String>(capacity);
		assertEquals(capacity,testArray2.getInitialCapacity());
	}
	
	@Test
	public void testAddGetSize() throws Exception {
		MyArrayList<Integer> integerArray = new MyArrayList<Integer>();
		assertEquals(0,integerArray.size());
		Integer integer = new Integer(3);
		
		//need to make sure add returns true
		assertTrue(integerArray.add(integer));
		assertEquals(1,integerArray.size());
		assertEquals(0,integerArray.indexOf(integer));
		assertSame(integer,integerArray.get(0));
		
		Integer integer2 = new Integer(6);
		integerArray.add(integer2);
		assertEquals(2,integerArray.size());
		assertEquals(1,integerArray.indexOf(integer2));
		assertSame(integer2,integerArray.get(1));
		
		//FIRST TEST FOR ENSURE CAPACITY
		//tested by seeing that the add method can add more than initial capacity
		
		//arraylist with initial capacity 3
		MyArrayList<String> stringArray = new MyArrayList<String>(3); 
		
		String one = "one";
		String two = "two";
		String three = "three";
		String four = "four";
		
		stringArray.add(one);
		stringArray.add(two);
		stringArray.add(three);
		stringArray.add(four);
		
		/*
		 * let's check that we managed to add 4. We want to test that add 
		 *calls ensureCapacity() when it needs more space, so by adding 4
		 *elements (more than the capacity) and verifying that they all added
		 *we are ensuring that when we write the add method, it will have to
		 *add space to the array if there is none left 
		 */
		
		assertEquals(4, stringArray.size());
		assertEquals(one, stringArray.get(0));
		assertEquals(two, stringArray.get(1));
		assertEquals(2, stringArray.indexOf(three));
		assertEquals(3, stringArray.indexOf(four));
	}
	
	@Test
	public void testAddAtSpecificIndexAddsAtIndex() throws Exception {
		MyArrayList<String> array = new MyArrayList<String>();

		String element1 = "I am an element.";
		String element2 = "I am another element.";
		
		array.add(0,element1);
		array.add(1,element2);
		
		assertEquals(0, array.indexOf(element1));
		assertEquals(1, array.indexOf(element2));
		
		assertEquals(element1, array.get(0));
		assertEquals(element2, array.get(1));
	}
	
	/*
	 * This tests that if you request to add at an index that already has
	 * an element stored there, all elements are shifted over.
	 */
	@Test
	public void testAddAtSpecificIndexShiftsElementsIfNeeded() throws Exception {
		MyArrayList<String> array = new MyArrayList<String>();

		String element1 = "element 1.";
		String element2 = "element 2.";
		String element3 = "element 3.";
		
		array.add(0,element1);
		array.add(1,element2);
		array.add(0,element3);
		
		assertEquals(0, array.indexOf(element3));
		assertEquals(1, array.indexOf(element1));
		assertEquals(2, array.indexOf(element2));
		
		assertEquals(element3, array.get(0));
		assertEquals(element1, array.get(1));
		assertEquals(element2, array.get(2));
	}
	
	@Test
	public void testAddAtSpecificIndexThrowsIndexOutOfBounds() throws Exception {
		MyArrayList<String> array = new MyArrayList<String>();

		String element1 = "element 1.";
		String element2 = "element 2.";
		
		array.add(0,element1);
		try {
			
			//if we get beyond this next line, that means we haven't thrown an exception
			array.add(2,element2);
			
			//your add method should throw an exception if you add beyond its bounds
			fail("You have not implemented a check to make sure the index is within bounds.");
			
		} catch (IndexOutOfBoundsException e) {
		}
		
		try {
			array.add(-4, element2);
			fail("You haven't checked to make sure the index is not negative");
		} catch (IndexOutOfBoundsException e) {
		}
		
		assertEquals(1, array.size());
		assertFalse(array.contains(element2));
	}
	
	@Test
	public void testAddAtIndexEnsuresCapacity() throws Exception {
		/*
		 * SECOND TEST FOR ENSURE CAPACITY
		 */
		
		MyArrayList<String> array = new MyArrayList<String>(2);
		
		String three = "3";

		array.add(0, "1");
		array.add(1, "2");
		array.add(2, three);
		
		assertEquals(3, array.size());
		assertTrue(array.contains(three));
	}
	
	@Test
	public void testClear() throws Exception {
		MyArrayList<String> arrayList = new MyArrayList<String>();
		
		String element = "Me!";
		
		arrayList.add(element);
		arrayList.add("Meee, me!");
		
		assertEquals(2, arrayList.size());
		arrayList.clear();
		assertEquals(0, arrayList.size());
		assertFalse(arrayList.contains(element));
		assertEquals(-1, arrayList.indexOf(element));
		}
	
	@Test
	public void testContains() throws Exception {
		
		MyArrayList<String> arrayList = new MyArrayList<String>();
		
		String element = "ELEMENT";
		String element2 = "ELEMENT 2";
		
		arrayList.add(element);
		
		assertTrue(arrayList.contains(element));
		assertFalse(arrayList.contains(element2));
		arrayList.clear();
		assertFalse(arrayList.contains(element));
	}
	
	@Test
	public void testGetIndexReturnsElement() throws Exception {
		
		MyArrayList<String> arrayList = new MyArrayList<String>();

		String one = "One.";
		String two = "Two.";
		String three = "Three.";

		arrayList.add(one);
		arrayList.add(two);
		arrayList.add(three);
	
		assertEquals(one, arrayList.get(0));
		assertEquals(two, arrayList.get(1));
		assertEquals(three, arrayList.get(2));
	}
	
	@Test
	public void testGetIndexThrowsIndexOutOfBounds() throws Exception {
		
		MyArrayList<String> arrayList = new MyArrayList<String>();

		try{
			arrayList.get(0);
			fail("There is nothing at index 0, check and throw IndexOutOfBounds");
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			arrayList.get(-8);
			fail("IndexOutOfBoundsException should be thrown for negative nubers");
		} catch (IndexOutOfBoundsException e) {
			
		}
		assertEquals(0, arrayList.size());
	}
	
	@Test
	public void testIndexOf() throws Exception {
		MyArrayList<String> array = new MyArrayList<String>();
		String hey = "Hey.";
		String hi = "Hi.";

		array.add(hey);
		array.add(hi);
		array.add(hi);
			
		assertEquals(0, array.indexOf(hey));
		assertEquals(1, array.indexOf(hi));
		assertEquals(3, array.size());
		assertEquals(-1, array.indexOf("Hello."));
	}
	
	@Test
	public void testIsEmpty() throws Exception {
		MyArrayList<String> array = new MyArrayList<String>();
		
		assertTrue(array.isEmpty());
		array.add("I'm here.");
		assertFalse(array.isEmpty());
	}
	
	@Test
	public void testRemoveIndexReturnsObject() throws Exception {
		MyArrayList<String> array = new MyArrayList<String>();
		String hey = "Hey.";
		String hi = "Hi.";

		array.add(hey);
		array.add(hi);
		assertEquals(2,array.size());
		assertEquals(hey, array.remove(0));
		assertEquals(1,array.size());
	}
	
	@Test
	public void testRemoveIndexShiftsEverythingToLeft() throws Exception {
		MyArrayList<String> array = new MyArrayList<String>();
		String hey = "Hey.";
		String hi = "Hi.";

		array.add(hey);
		array.add(hi);

		assertEquals(1, array.indexOf(hi));
		array.remove(0);
		assertEquals(0, array.indexOf(hi));
	}
	
	@Test
	public void testRemoveIndexThrowsIndexOutOfBounds() throws Exception {
		MyArrayList<String> array = new MyArrayList<String>();

		try {
			array.remove(1);
			fail("Didn't check and throw IndexOutOfBounds");
		}catch (IndexOutOfBoundsException e) {
			
		}
		try { 
			array.remove(-4);
			fail("didnt check and throw IndexOutOfBounds for negative num");
		} catch (IndexOutOfBoundsException e) {
			
		}
		assertTrue(array.isEmpty());
	}
	
	@Test
	public void testRemoveObjectReturnsBoolean() throws Exception {
		MyArrayList<String> array = new MyArrayList<String>();
		String hey = "Hey.";
		String hi = "Hi.";

		array.add(hey);
		array.add(hi);
		assertEquals(2,array.size());
		assertTrue(array.remove(hey));
		assertEquals(1,array.size());
		assertFalse(array.remove("hello"));
	}
	
	@Test
	public void testRemoveObjectShiftsEverythingToLeft() throws Exception {
		MyArrayList<String> array = new MyArrayList<String>();
		String hey = "Hey.";
		String hi = "Hi.";

		array.add(hey);
		array.add(hi);

		assertEquals(1, array.indexOf(hi));
		array.remove(hey);
		assertEquals(0, array.indexOf(hi));
	}
	
	@Test
	public void testSetSets() throws Exception {
		MyArrayList<String> array = new MyArrayList<String>();
		String hey = "Hey.";
		String hi = "Hi.";

		array.add(hey);
		assertEquals(0, array.indexOf(hey));
		assertEquals(hey, array.set(0, hi));
		assertFalse(array.contains(hey));
		assertEquals(0, array.indexOf(hi));
	}
	
	@Test
	public void testSetThrowsIndexOutOfBounds() throws Exception {
		MyArrayList<String> array = new MyArrayList<String>();

		try {
			array.set(0, "one");
			fail("Didn't check and throw IndexOutOfBounds. Can't set something"
					+ "to an index that hasn't had anything assigned to it yet");
		}catch (IndexOutOfBoundsException e) {
			
		}
		try { 
			array.set(-4, "two");
			fail("didnt check and throw IndexOutOfBounds for negative num");
		} catch (IndexOutOfBoundsException e) {
			
		}
		assertTrue(array.isEmpty());

	}
	
	
}
