 //*******************************************************************
 // Final, problem # 3: Ch17, Ex 7: "isFull" method
 //  
 // *Method to be added to the IntTree class from Ch17.
 // 
 // Write a method called isFull that return true if a binary tree is
 //   full and false if it is not. A full binary tree is one in which 
 //   every node has 0 or 2 children. By definition, an empty tree is
 //   considered full.
 //
 // By: Michael Gilson
 // Date: 6/13/2020
 //*******************************************************************

//import java.util.*;


public class IntTree {
    private IntTreeNode overallRoot;

// Constructor to create Empty IntTree
    public IntTree() {
    	overallRoot = null;
    }
    
    // pre : max > 0
    // post: constructs a sequential tree with given number of
    //       nodes
    public IntTree(int max) {
        if (max <= 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }

    // post: returns a sequential tree with n as its root unless
    //       n is greater than max, in which case it returns an
    //       empty tree
    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new IntTreeNode(n, buildTree(2 * n, max),
                                   buildTree(2 * n + 1, max));
        }
    }
    

 
//*************************************************
// Constructor for no parameters that redirects to private constructor
    public boolean isFull() {
    	return isFull(overallRoot);
    }
    
// Constructor with IntTreeNode parameter
    private boolean isFull(IntTreeNode root) {
    	
// If tree is empty, return true, as an empty tree is considered full.
    	if (root == null) {
    		return true;
    		
// Else if the left branch is not null, but the right branch is, return
//   false, since a full tree has to have either 0 or 2 children, not 1.
    	} else if (root.left != null && root.right == null) {
    		return false;
    		
// Same type of Else statement checking if right is not null, but left is.
    	} else if (root.right != null && root.left == null) {
    		return false;
    		
// Finally, else statement to recursively go down both left AND right
//   branches (as they would both exist at this point in the if/else statement).
//   Eventually, the base cases above will be hit, and if both left AND right
//   branches return true, then the final return statement is true, indicating
//   a full tree.
    	} else {
    		return isFull(root.left) && isFull(root.right);
    		
    	} // end else
    } //end method
    
//*************************************************
    
    // Constructor for no parameters that redirects to private constructor
    public int countEmpty() {
    	return countEmpty(overallRoot);
    }
    
    // Constructor with IntTreeNode parameter
    private int countEmpty(IntTreeNode root) {
    	
    // If the tree is empty, then it returns 1, as per instructions
    	if (root == null) {
    		return 1;
    		
    // If a node has no left branch, it returns 1, then recursively goes down
    //   the right branch.
    	} else if (root.left == null) {
    		return 1 + countEmpty(root.right);
    
    // If a node has no right branch, it returns 1, then recursively goes down
    //   the left branch.
    	} else if (root.right == null) {
    		return 1 + countEmpty(root.left);
    		
    // Otherwise, it will recursively go down both the left and right branches.
    //   Eventually, it will encounter a branch that is null, and return the 
    //   "1" + any recursive numbers acquired, and returning the total of the 
    //   number of empty branches.
    	} else {
    		return countEmpty(root.left) + countEmpty(root.right);
    	}
    }
    
    
    // post: prints the tree contents using a preorder traversal
    public void printPreorder() {
        System.out.print("preorder:");
        printPreorder(overallRoot);
        System.out.println();
    }

    // post: prints the tree contents using a preorder traversal
    // post: prints in preorder the tree with given root
    private void printPreorder(IntTreeNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    // post: prints the tree contents using a inorder traversal
    public void printInorder() {
        System.out.print("inorder:");
        printInorder(overallRoot);
        System.out.println();
    }

    // post: prints in inorder the tree with given root
    private void printInorder(IntTreeNode root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(" " + root.data);
            printInorder(root.right);
        }
    }

    // post: prints the tree contents using a postorder traversal
    public void printPostorder() {
        System.out.print("postorder:");
        printPostorder(overallRoot);
        System.out.println();
    }

    // post: prints in postorder the tree with given root
    private void printPostorder(IntTreeNode root) {
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(" " + root.data);
        }
    }

    // post: prints the tree contents, one per line, following an
    //       inorder traversal and using indentation to indicate
    //       node depth; prints right to left so that it looks
    //       correct when the output is rotated.
    public void printSideways() {
        printSideways(overallRoot, 0);
    }

    // post: prints in reversed preorder the tree with given
    //       root, indenting each line to the given level
    private void printSideways(IntTreeNode root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }
}