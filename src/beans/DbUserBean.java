package beans;

public class DbUserBean {

	private int uid;
	private String first, last, email, password;
	public DbUserBean(int uid, String first, String last, String email,
			String password) {
		super();
		this.uid = uid;
		this.first = first;
		this.last = last;
		this.email = email;
		this.password = password;
	}

	public int getUid() {
		return uid;
	}
	
	public String getFirst() {
		return first;
	}
	
	public String getLast() {
		return last;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
}
