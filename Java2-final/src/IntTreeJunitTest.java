//***************************************************************
// WEB155 - Final - Problem 3 - JUnit Test Cases
// Junit test cases for IntTree: isFull method
//***************************************************************
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class IntTreeJunitTest {

	@Test
	void testLargeTree() {
	// Creates Int Tree with 12 nodes
    // Prints Sideways IntTree structure, for false full status verification
		IntTree test1 = new IntTree(12);
        System.out.println("Large/Even Node Tree structure:");
        test1.printSideways();

    // Should test isFull: false, since even nodes evenly distributed 
    //  should leave a node with only one branch. 
        assertFalse(test1.isFull());
	}
	
	@Test
	void testSmallTree() {
	// Creates Int Tree with 3 nodes
	// Prints Sideways IntTree structure, for true full status verification 
		IntTree test2 = new IntTree(3);
		System.out.println("Small/Odd Node Tree structure:");
        test2.printSideways();

    // Should test isFull: true, since no excess branches will remain
        assertTrue(test2.isFull());
	}
	
	@Test
	void testSingleNodeTree() {
	// Creates Int Tree with just 1 node (a root)
	// Prints Sideways IntTree structure, for true full status verification
		IntTree test3 = new IntTree(1);
		System.out.println("Single Node Tree structure:");
        test3.printSideways();

    // Should test isFull: true, since there are no branches from root node.
        assertTrue(test3.isFull());
	}
	
	@Test
	void testNullTree() {
	// Creates Empty IntTree
	// No print output since Tree is empty 
		IntTree test4 = new IntTree();
		System.out.println("Null Tree structure:");
	    
	// Should test isFull: true, since an empty tree is considered to be full.
		assertTrue(test4.isFull());
	}

}
