package beans;

public class BackgroundColorBean {

	private int red, green, blue;

	public BackgroundColorBean() {
		red = green = blue = 128;
	}
	
	public int getR(){ return red; }
	public void setR(int value) { red = value; }
	
	public int getG(){ return green; }
	public void setG(int value) { green = value; }
	
	public int getB(){ return blue; }
	public void setB(int value) { blue = value; }
	
}
