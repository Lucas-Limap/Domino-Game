package br.edu.univas.list;

public class Piece {
	
	private int side1;
	private int side2;
	
			
	public int getSide1() {
		return side1;
	}
	public void setSide1(int side1) {
		this.side1 = side1;
	}
	public int getSide2() {
		return side2;
	}
	public void setSide2(int side2) {
		this.side2 = side2;
	}
	
	@Override
	public String toString() {
        return "(" + side1 + "," + side2 + ")";
    }
	public String toString2() {
		return "(" + side2 + "," + side1 +")";
	}


}
