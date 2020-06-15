//***************************************************************
// WEB155 - Final - Problem 1 - JUnit Test Cases
// Junit test cases for StackQueueProblem1: equals method
//***************************************************************
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;


class StackQueueProblem1Test {

	@Test
	void test() {
//create test stack with 3 integers: bottom [7, 2, 8] top
		Stack<Integer> test1 = new Stack<>();
		test1.push(7);
		test1.push(2);
		test1.push(8);
		
//create identical stack with 3 integers: bottom [7, 2, 8] top
		Stack<Integer> test2 = new Stack<>();
		test2.push(7);
		test2.push(2);
		test2.push(8);
		
//create test stack with 3 different integers: bottom [7, 2, 3] top
		Stack<Integer> test3 = new Stack<>();
		test3.push(7);
		test3.push(2);
		test3.push(3);
		
//create different size stack with 5 integers: bottom [7, 2, 8, 5, 11] top
		Stack<Integer> test4 = new Stack<>();
		test4.push(7);
		test4.push(2);
		test4.push(8);
		test4.push(5);
		test4.push(11);
		
//create two identical empty test stacks
		Stack<Integer> test5 = new Stack<>();
		Stack<Integer> test6 = new Stack<>();

		
	// assertTrue test for test1/test2
		assertTrue(StackQueueProblem1.equals(test1, test2));
		
	// assertEquals test for test1/test2 original state, post-equal method
		assertEquals("[7, 2, 8]", test1.toString());
		assertEquals("[7, 2, 8]", test2.toString());
		
	// assertFalse test for test1/test3
		assertFalse(StackQueueProblem1.equals(test1, test3));
		
	// assertEquals test for test3 original state, post-equal method
		assertEquals("[7, 2, 3]", test3.toString());
		
	// assertFalse test for test1/test4
		assertFalse(StackQueueProblem1.equals(test1, test4));
		
	// assertEquals test for test4 original state, post-equal method
		assertEquals("[7, 2, 8, 5, 11]", test4.toString());
		
	// assertTrue test for test5/test6
		assertTrue(StackQueueProblem1.equals(test5, test6));
		
	// assertEquals test for test5/test6 original state, post-equal method
		assertEquals("[]", test5.toString());
		assertEquals("[]", test6.toString());
		
	}

}
