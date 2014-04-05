package project.chessmodel;

public class Tuple<row, col> { 
	
	public final int row; 
	public final int col; 
	
	public Tuple(int row, int col) { 
	    this.row = row; 
	    this.col = col; 
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
}
