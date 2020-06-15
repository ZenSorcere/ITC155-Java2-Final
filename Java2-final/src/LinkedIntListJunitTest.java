//***************************************************************
// WEB155 - Final - Problem 2 - JUnit Test Cases
// Junit test cases for LinkedIntList: hasTwoConsecutive method
//***************************************************************

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LinkedIntListJunitTest {

	@Test
	void testFullTrue() {
		// Creates LinkedIntList of fully consecutive elements
		LinkedIntList list = new LinkedIntList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		// Should test hasTwoConsective: true
		assertTrue(list.hasTwoConsecutive());	
	}
	
	void testOneTrue() {
		// Creates LinkedIntList with only one instance of consecutive elements
		LinkedIntList list = new LinkedIntList();
		list.add(0);
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(7);
		
		// Should test hasTwoConsecutive: true
		assertTrue(list.hasTwoConsecutive());	
	}
	
	@Test
	void testFalse() {
		// Creates LinkedIntList of descending elements
		LinkedIntList list = new LinkedIntList();
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		
		// Should test hasTwoConsecutive: false
		assertFalse(list.hasTwoConsecutive());
	}

	@Test
	void testSingleElement() {
		// Creates list of just one element
		LinkedIntList list = new LinkedIntList();
		list.add(5);
		
		// Should test hasTwoConsecutive: false
		assertFalse(list.hasTwoConsecutive());
	}
	
	@Test
	void testEmpty() {
		// Creates an empty list
		LinkedIntList list = new LinkedIntList();
		
		// Should test hasTwoConsecutive: false
		assertFalse(list.hasTwoConsecutive());
	}
	
	@Test
	void testIdentical() {
		// Creates list of identical elements
		LinkedIntList list = new LinkedIntList();
		list.add(5);
		list.add(5);
		list.add(5);
		list.add(5);
		list.add(5);
		
		// Should test hasTwoConsecutive: false
		assertFalse(list.hasTwoConsecutive());
	}
}
