package cad.model;

public class Cell{
	
	private int abs, ord, width, height;
	
	public Cell(int abs, int ord, int width, int height){
		this.abs = abs;
		this.ord = ord;
		this.width = width;
		this.height = height;
	}

	public int getAbs() {
		return abs;
	}

	public void setAbs(int abs) {
		this.abs = abs;
	}

	public int getOrd() {
		return ord;
	}

	public void setOrd(int ord) {
		this.ord = ord;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	

}
