//*******************************************************************
// Final, problem # 1: Ch14, Ex 5: "equals" method
// 
// Write a method called equals that accepts two stacks of integers as
//   parameters and returns true if the two stacks store exactly the
//   same sequence of integer values in the same order. Method must 
//   restore the two stacks to the original state before returning.
//   Use one stack as auxiliary storage.
//
// By: Michael Gilson
// Date: 6/13/2020
//*******************************************************************

import java.util.*;

public class StackQueueProblem1 {

	public static void main(String[] args) {
// Create 3 test stacks to run equals method on, display pre state,
//   equals method results, and display post state.
		Stack<Integer> test1 = new Stack<>();
		test1.push(7);
		test1.push(2);
		test1.push(8);
		System.out.println(test1); // [7, 2, 8]
		
		Stack<Integer> test2 = new Stack<>();
		test2.push(7);
		test2.push(2);
		test2.push(8);
		System.out.println(test2); // [7, 2, 8]
		
		Stack<Integer> test3 = new Stack<>();
		test3.push(7);
		test3.push(2);
		test3.push(3);
		System.out.println(test3); // [7, 2, 3]
		
		System.out.println("test1 v test2: " + equals(test1, test2));  //true
		System.out.println("test1 v test3: " + equals(test1, test3));  //false
		
		
		System.out.println(test1); // [7, 2, 8]
		System.out.println(test2); // [7, 2, 8]
		System.out.println(test3); // [7, 2, 3]
	} //end main
	
// Method declaration with two stacks as parameters
	public static boolean equals (Stack<Integer> s1, Stack<Integer> s2) {
		
// Create an auxiliary stack called silo
		Stack<Integer> silo = new Stack<>();

// Create a boolean variable called match, default set to true.
		boolean match = true;
		
// If statement: if two parameter stacks aren't same size, they don't match.
//   match set to false, and is immediately returned.
		if (s1.size() != s2.size()) {
			match = false;
			return match;

// Otherwise, while both stacks aren't empty, pop the top element off each
//   stack, and save as variables a and b. Push both a and b onto auxiliary
//   stack.
		} else {
			while (!s1.isEmpty() && !s2.isEmpty()) {
				int a = s1.pop();
				int b = s2.pop();
				silo.push(a);
				silo.push(b);
			// Test print statements to track while loop progress
				//System.out.print(a + " ");
				//System.out.print(b + " ");

// If statement: compare a and b. If they don't match, boolean is set to false.
//   this continues through both stacks, until they are empty. If match is never
//   is never set to false, the result will be true.
				if (a != b) {
					match = false;
				} //end if	
				
//******************************************************************* 
// Originally included an else statement, which passed the 6 tests in PracticeIt.
//   However, I discovered if the top values didn't match but the rest did, the else
//   statement would override the boolean as it progressed through the stack, and 
//   return an incorrect result, which was not caught by PracticeIt tests. My sample
//   stacks revealed this missing test case, so I removed the else.

				//}else {
				//	match = true;	
				//}
//*******************************************************************
				
			} //end while
		} //end else
		
// Once Else/while loop is completed, a while loop is used to return both stacks
//   to their original state by removing the top item from the auxiliary stack
//   in reverse order of entry, pushing them back to their original stacks.
		while (!silo.isEmpty()) {
			s2.push(silo.pop());
			s1.push(silo.pop());
		} //end while
		
// Return result of match boolean variable, once stacks restored
		return match;
	} //end equals method
	
} //end class
