package midterm;

public class MidtermReviewCourse {

	private static int count = 0;
	
	private int id;
	private String title;
	private String number;
	
	
	public MidtermReviewCourse(String number, String title) {
		super();
		this.title = title;
		this.number = number;
		
		this.id = count++;
	}


	public int getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}


	public String getNumber() {
		return number;
	}	
}