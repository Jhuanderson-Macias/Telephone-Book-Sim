package singleLinkList;

/*
Jhuanderson Macias 

The following program simulates an address book. User is asked to 
input the name, email, and telephone number of the person they are trying to add. 
 
At any point users can also save their created address book into a file. 
At the beginning of the program, users are able to load their previously 
saved address book. 

User can input 7 commands:
• ‘a’ : Add a phone number to the list.
• ‘p’ : Print the entire List
• ‘s’ : Search for Name.
• ‘e’ “ Search for email address
• ‘d’ : Delete an Entry.
• 'save' : save address book
• 'q', 'quit': quit program.

Run program to start.
*/
public class Driver {

	public static void main(String[] args) {

		Driver me = new Driver();
		me.doIt();
		
	}


	private void doIt() {
		TelephoneList createAddressBook = new TelephoneList();
		createAddressBook.menu();
	
	}
}
