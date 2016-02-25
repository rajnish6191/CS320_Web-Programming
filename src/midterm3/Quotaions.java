package midterm3;

public class Quotaions {
	int getIntID() {
		return intID;
	}

	void setIntID(int intID) {
		this.intID = intID;
	}

	String getStrQuote() {
		return strQuote;
	}

	void setStrQuote(String strQuote) {
		this.strQuote = strQuote;
	}

	String getStrAuthor() {
		return strAuthor;
	}

	void setStrAuthor(String strAuthor) {
		this.strAuthor = strAuthor;
	}

	private int intID;
	private String strQuote;
	private String strAuthor;
	private static int intNextid =0; 
	private static int intNextVisitedCount =1;
	private int intVisitedCount;
	
	int getIntVisitedCount() {
		return intVisitedCount;
	}

	void setIntVisitedCount(int intVisitedCount) {
		this.intVisitedCount = intVisitedCount;
	}

	public Quotaions(String strQuote, String strAuthor ) {
		
		intNextid ++;
		this.intID = intNextid;
		this.strAuthor = strAuthor;
		this.strQuote = strQuote;
	}
}