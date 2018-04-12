package singleLinkList;
/*
 *Jhuanderson Macias
 
This class handles all user interface. Based on input from user, 
this class decides which action to perform on the list.

For example:
If command is 'a' it calls on toOrder() from the SLList() class, which creates a new
node for the linked list and add it in last name alphabetical order.

This class also deals with the storing and restoring of an address book.

 */



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

	
	public class TelephoneList {
		
	private SLList info;
	private String fileName;
	
	public TelephoneList() {
		info = new SLList();
		fileName = "y";
	}
	
	
		
		public void menu() {
			
			
			Scanner kbd = new Scanner(System.in);
			boolean done = false;
			String Name;
			String Email;
			String phoneNumber;
			String input;
			int index;
			String command;
			
			// if saving data to file. Name of file
			
			System.out.println("Welcome to your Telephone Address Book\n");
			
			System.out.println("Do you have a previously saved address book? \n "
					+ "Type yes to load it. Type No otherwise.");
			input = kbd.nextLine();
			command = input.toLowerCase().trim();
			
			if (command.equals("yes")) {
				this.info = RestoreFile();
			}
		
			while(done == false) {
				System.out.print("Enter command (? for help)\n--> ");
				System.out.println("Please Enter a command");
				input = kbd.nextLine();
				command = input.toLowerCase().trim();
				
				switch(command) {
				
				case "?":
				case "H":
				case "help":
					
					System.out.println("Commands:");
					System.out.println("\tq, quit : Quit");
					System.out.println("\ta : Add a phone number");
					System.out.println("\tp : Print address book");
					System.out.println("\ts : Search for Name");
					System.out.println("\te : Search for email address");
					System.out.println("\td : Delete an Entry by index");
					System.out.println("\t? : This display");
					System.out.println("\tsave : save address book");				
					break;
				
				case "q":
				case "quit":
					
					System.out.println("Closing address book!");
					done = true;
					
					break;
					
				case "d":
					
					System.out.print("which index would you like to delete?");
					input = kbd.nextLine();
					try {
						index = Integer.parseInt(input);	
						} catch(NumberFormatException e){		
						System.out.println("Hey Buddy, please pick a index");
						break;
						}
					
					// print if contact got deleted
					System.out.println(info.delete(index));

					break;
					
				case "p":
					
					System.out.println(this.info);

					break;
					
				case "e":
					
					System.out.println("What email would you like to search for");
					input = kbd.nextLine();
					Email = input.toUpperCase().trim();
					
					System.out.print(this.info.searchEmail(Email));	

					break;
					
				case "s":
					
					System.out.println("What Name would you like to search for");
					input = kbd.nextLine();
					Name = input.toUpperCase().trim();
					
					System.out.print(this.info.searchName(Name));	
					
					break;

				case "a":
					
					System.out.println("Enter Name of person");
					input = kbd.nextLine();
					Name = input.toUpperCase().trim();
					System.out.println("Enter person's email");
					input = kbd.nextLine();
					Email = input.toUpperCase().trim();
					System.out.println("Enter person's Phone Number");
					input = kbd.nextLine();
					phoneNumber = input.toUpperCase().trim();
					
					
					this.info.toOrder(Name, Email, phoneNumber);
					
					break;
					
				case "save":					
					saveFile();
					System.out.println("saved successfuly ");
					break;
			}
			
		} 
			kbd.close();
	} 
		
		// saves file using serializable 		
		public void saveFile() {
			try {
				
				FileOutputStream fileInput = new FileOutputStream(this.fileName);
				ObjectOutputStream os = new ObjectOutputStream(fileInput);
				os.writeObject(this.info);
				os.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return;
		}
		
		// restore data
		public SLList RestoreFile() {
			SLList stored = new SLList();
			
			try {
				
				FileInputStream fileInpu2 = new FileInputStream(this.fileName);
				ObjectInputStream is = new ObjectInputStream(fileInpu2);
				stored = (SLList) is.readObject();
				is.close();
				System.out.println("Successfully loaded previous Address Book");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.print("There was an Error loading Address Book \n" + 
					    "Press Enter to coninue \n");
				
			} catch(IOException e) {
				e.printStackTrace();
				System.out.print("There was an Error loading Address Book \n" + 
					    "Press Enter to coninue \n");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
				System.out.print("There was an Error loading Address Book \n" + 
					    "Press Enter to coninue \n");
				
			}
			// if nothing found return empty list to start, else returns 
			// the saved list
			return stored;
		}

}
