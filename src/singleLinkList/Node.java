package singleLinkList;

/*
 Jhuanderson Macias 
 
Node Class that contains 3 Strings, one for name, one 
for email, and the other for the phone number, in 
addition to the reference to the next entry.

	Data each node is private. There are a series of setters and getters
	to retrieve or set data. 
	
	Method getAllinfo() is used is Sllist searchEmail, searchName and toString.
	 	It is used to print all data for the node without having to call each get
	 	in SLList.
 */


import java.io.Serializable;

public class Node implements Serializable {
	
	

	private String Name;
	private String Email;
	private String Number;
	
	private Node next;
	
	public Node() {
		Name = null;
		Email = null;
		Number = null;		
		next = null;
	}
	
	public String getName() {
		return Name;
	}
	
	
	public void setName(String name) {
		this.Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		this.Number = number;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String getAllinfo(){
		return String.format("\tName:  " + this.Name + 
				"%n \tEmail: " + this.Email + "%n \tPhone Number:  "  + 
				this.Number);
	}
	


}

