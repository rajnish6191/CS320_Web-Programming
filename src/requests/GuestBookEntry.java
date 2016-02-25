package requests;

import java.util.Date;

public class GuestBookEntry {
	private String username;
	private String message;
	private Date datePosted;
	
	public GuestBookEntry(String username, String message) {		
		this.username = username;
		this.message = message;
		this.datePosted = new Date();
	}

	public String getUsername() {
		return username;
	}

	public String getMessage() {
		return message;
	}

	public Date getDatePosted() {
		return datePosted;
	}
}