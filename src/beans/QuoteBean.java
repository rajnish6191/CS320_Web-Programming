package beans;

public class QuoteBean {
	private int id;
	private String author,quote;
	public QuoteBean(int id, String author, String quote) {
		super();
		this.id = id;
		this.author = author;
		this.quote = quote;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getQuote() {
		return quote;
	}
	
	public void setQuote(String quote) {
		this.quote = quote;
	}	
}