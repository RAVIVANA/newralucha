package com.nkxgen.spring.jdbc.events;

public class LoanAppRequestEvent {

	private String event;
	private String username;

	public LoanAppRequestEvent(String event, String username) {
		this.event = event; // Assign the value of the 'event' parameter to the 'event' member variable of the class
		this.username = username; // Assign the value of the 'username' parameter to the 'username' member variable of
									// the class
	}

	public String getEvent() {
		return event; // Return the value of the 'event' member variable
	}

	public String getUsername() {
		return username; // Return the value of the 'username' member variable
	}

}
