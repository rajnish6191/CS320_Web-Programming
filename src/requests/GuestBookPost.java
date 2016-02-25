package requests;

import java.util.Date;

public class GuestBookPost {

	private String name;
	private String message;
	private Date when;
	
	public GuestBookPost(String name, String message) {
		super();
		this.name = name;
		this.message = message;
		this.when = new Date();
	}

	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}

	public Date getWhen() {
		return when;
	}	
}