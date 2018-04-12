package singleLinkList;

/*

This class accesses the data in Node(). It also contains 
methods needed to support all linked list operations needed 
to fulfill user commands.

*/

import java.io.Serializable;

public class SLList implements Serializable{
	
	private Node head;
	
	
	private String getLastName(String Name) {
		/*
	 	This method uses string.split() to break up the name input
		String with space delimiters are stored in an array 
		
		returns the last name that user input. That name is used to alphabetize 
		the address book. 
		
		Assumption: made private because it should only be accessed in this class
		
		**Used in toOrder()**
	 */
		
		String[] arrayOfString = Name.split(" ");
		int length = arrayOfString.length;
		String lastName = arrayOfString[length - 1];
		return lastName;
	}
	
	
	public void toOrder(String Name, String Email, String Number) {
		/*
	 	This method is used to add a new entry. The function
	 	also handles the sorting of of Entry by last Name. 
		 */
		
		// curr and rprev used to circulate through list - both start at head
		// and move at different times.
		Node curr = head;
		Node rprev = head;
		
		// create a new node with the new contact info. This is the Node that will be added
		Node newInfo = new Node();
		newInfo.setName(Name);
		newInfo.setEmail(Email);
		newInfo.setNumber(Number);

		// use getLastName() to pull out last name given by user
		String lastName =  getLastName(Name);
				
		if (head == null ) {
			// list is empty: so just add node
			newInfo.setNext(head);
			head = newInfo;			
		} else if (head != null) {
			curr = head;
			int compare = lastName.compareTo(getLastName(curr.getName()));
			
			// if last name are the same compare full name for secondary sorting
			if (compare == 0) {
			compare = newInfo.getName().compareTo(curr.getName());
			}
			
			// if user last name input < than last name in curr
			if (compare < 0){
				newInfo.setNext(curr);
				head = newInfo;	
				return;
					
			} else if(compare > 0 || compare == 0){
				// the or is to capture case if full name is the same
				// if user last name input > than last name in curr
				while(curr.getNext() != null) {
					
					// move curr to next node 
					curr = curr.getNext();
					
					// perform a new compare with new last name in the list
					compare = lastName.compareTo(getLastName(curr.getName()));
					
					// if user last name input < than last name in curr add before curr
					if (compare < 0) {		
						newInfo.setNext(curr) ;
						rprev.setNext(newInfo);
						return;
					}
					// if nothing found move rprev to next node
					rprev = rprev.getNext();
				}
			// reach end of list. Add to end	
			curr.setNext(newInfo);	 	
			
			}
		}
	}

	
	public String searchName(String searchableString) {
		/*
	 	This method searches user input value in a Node's Name field
	 	throughout the list
		 */
		
		// start curr at head
		Node curr = head;
		
		// keeps track of index
		int counter = 1;
		
		String foundInfo = "";
		
		if (curr == null) {
			// return empty if list empty
			return "<Empty>\n";
		} else {		
			
			while(curr != null) {
				// search node's name to see if contains user's input string
				if(curr.getName().contains(searchableString) == true) {
					// format string to print
					foundInfo += "Index "+ counter + "\n" + 
								curr.getAllinfo() + "\n\n";
				}
				
				/*
			 	Add counter whether search found or not. 
			 	Assumption: Index is location relative to list 
			 	not whether found
				 */
				
				counter ++;
				
				// move on to next Node
				curr = curr.getNext();	
			}
		}
		
		// return if nothing was found
		if(curr == null && foundInfo == "") 
			return "There was no match \n";
			
		// return list of all searched items
		return foundInfo;			
	}
	
	public String searchEmail(String searchableString) {
		/*
	 	This method searches user input value in a Node's email field
	 	throughout the list
	 	
	 	Works the same way as searchName
		 */
		
		// start curr at head
		Node curr = head;
		// keeps track of index
		int counter = 1;
		
		String foundInfo = "";
		
		if (curr == null) {
			// return empty if list empty
			return "<Empty>\n";
		} else {		
			while(curr != null) {
				// search node's email to see if contains user's input string
				if(curr.getEmail().contains(searchableString) == true) {
					// format string to print
					foundInfo += "Index "+ counter + "\n" + 
								  curr.getAllinfo() + "\n\n";
				}
				
				/*
			 	Add counter whether search found or not. 
			 	Assumption: Index is location relative to list 
			 	not whether found
				 */
				
				counter ++;	
				// move on to next Node
				curr = curr.getNext();	
			}
		}
			
		// return if nothing was found
		if(curr == null && foundInfo == "") 
			return "There was no match \n";
					
		// return list of all searched items
		return foundInfo;					
	}

	public String delete(Integer val) {
		/*
	 	This method deletes a a contact by index
	 	
	 	user inputs index
		 */
		
		Node prev = null;
		Node curr = head;
		int counter = 1;
		
		if (head == null) {
			// list is empty
			return "There are no Entries";
		}
		
		while (curr != null) {	
			if (val == 1) {
				// if deleting first entry set next equal to next entry
				head = curr.getNext();
				return "Contact Deleted";
			} else {	
				// increment counter, Curr points to next, while
				// prev points to previous node curr was at
				prev = curr;
				curr = curr.getNext();			
				counter++;
				
				if (counter == val) {
					// match found by index - delete it
					prev.setNext(curr.getNext());
					return "Contact Deleted";		
				}
			
			} 

		}
		// if index not found 
		return "That is not an index";
	}

	
	
	public String toString() {
		
		// create node to iterate through list
		Node n = head;
		//counter for indexing
		int counter = 1;
		
		String rtn = "";
		
		if (n == null) {
			// if head is empty print empty
			return "<Empty>\n";
		} else {
			while (n != null) {
				// print the data in each node
				rtn += "index " + counter + " \n" + n.getAllinfo() + "\n\n";
				n = n.getNext();
				counter++;
			}
		}
		
		// return print
		return rtn;
	}

}

