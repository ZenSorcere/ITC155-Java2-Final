 //*******************************************************************
 // Final, problem # 2: Ch16, Ex 6: "hasTwoConsecutive" method
 //  
 // *Method to be added to the LinkedIntList class from Ch16.
 // 
 // Write a method called hasTwoConsecutive that returns whether or not
 //   a list of integers has two adjacent numbers that are consecutive
 //   integers (true if such a pair exists and false otherwise). 
 //
 // By: Michael Gilson
 // Date: 6/13/2020
 //*******************************************************************

// Class LinkedIntList can be used to store a list of integers.
public class LinkedIntList {
    private ListNode front;  // first value in the list

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
    }
//*************************************************
    
// hasTwoConsecutive method that returns a boolean
   public boolean hasTwoConsecutive() {
	   
// current ListNode type variable set to the front of the IntList
	   ListNode current = front;
	   
// If statement for it IntList is empty, return false
	   if (current == null) {
		   return false;
		   
// Else statement: traverse through the IntList. While current's next
//   element points to another node (is not the end of the list), if the
//   current data + 1 matches the next LinkNode's data, then the elements
//   are consecutive, and it return's true.
	   } else {
		   while (current.next !=null) {
			   if (current.data + 1 == current.next.data) {
				   return true;
			   } //end if
			   
// Update current ListNode variable to be the next element in the list
			current = current.next;
		   } //end while
	   } //end else
	   
// If the if/else statement runs to completion, then no consecutive numbers
//   were found, and the method returns false.
	   return false;   
   } //end method
    
//************************************************* 
    
    
// isSorted method that returns a boolean
    public boolean isSorted() {
    	
// Declare variable for default boolean.
//  Declare local variable of type ListNode to traverse the list
//    without destroying it.
		boolean sorted = false;
		ListNode begin = front;
		
// If starting node is null, list is empty. Set sorted to true, and return.
		if (begin == null) {
			sorted = true;
			return sorted;
			
// Else, while the next field isn't null, traverse the list and compare
//   the next ListNode data with the current one.
// If the next ListNode is greater than the current, the list is not
//   sorted, so the sorted variable is returned.
// If next ListNode is less, local variable changes to the next ListNode
//   and traversal continues.
		} else {
			while (begin.next != null) {
				if (begin.next.data < begin.data) {
					return sorted;
				} else {
					begin = begin.next;
				}
			}
// If the entire list is traversed, sorted boolean will be set to true.
		sorted = true;
		}
// Once traversal is complete, sorted variable will be returned.
	return sorted;	
	}
    
   
    
      
    
    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode current = front;
        while (current !=  null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = new ListNode(value, current.next);
        }
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    
    
}