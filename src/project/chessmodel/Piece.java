package project.chessmodel;

import java.util.ArrayList;

public abstract class Piece {
	
	protected String color;
	
	public Piece(String color) {
		this.color = color;
	}
	
	public abstract ArrayList<Tuple<Integer,Integer>> validMoves(Cell[][] chessBoard, 
			int row, int col);
	
	public abstract ArrayList<Tuple<Integer,Integer>> eatMoves(Cell[][] chessBoard, 
			int row, int col);
	
	public abstract ArrayList<Tuple<Integer,Integer>> potentialEatMoves(Cell[][] chessBoard, 
			int row, int col);
	
	public String getColor() {
		return color;
	}
	
	@Override
	public String toString() {
		return getClass()+","+color;
	}

}
