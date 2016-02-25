package beans;

public class PageCounterBean {

	private int count;

	public PageCounterBean() {
		super();
	}

	public int getCount() {
		return ++count;
	}

	public void setCount(int count) {
		this.count = count;
	}	
}
