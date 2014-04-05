package project.chessmodel;

import java.util.ArrayList;

public class Pawn extends Piece {
	
	public Pawn(String color) {
		super(color);
	}

	@Override
	public ArrayList<Tuple<Integer, Integer>> validMoves(Cell[][] chessBoard, 
			int row, int col) {
		ArrayList<Tuple<Integer, Integer>> moves = new ArrayList<Tuple<Integer, Integer>>();
		if (color == "white" && row-1 >= 0) {
			if (chessBoard[row-1][col].isEmpty()) // move pawn 1 cell forward
				moves.add(new Tuple<Integer,Integer>(row-1,col));
			if (row == 6 && chessBoard[row-2][col].isEmpty()) // move pawn 2 cells forward
				moves.add(new Tuple<Integer,Integer>(row-2,col));
		} else if (color == "black" && row+1 < 8) {
			if (chessBoard[row+1][col].isEmpty()) // move pawn 1 cell forward
				moves.add(new Tuple<Integer,Integer>(row+1,col));
			if (row == 1 && chessBoard[row+2][col].isEmpty()) // move pawn 2 cells forward
				moves.add(new Tuple<Integer,Integer>(row+2,col));
		} return moves;
	}

	@Override
	public ArrayList<Tuple<Integer, Integer>> eatMoves(Cell[][] chessBoard,
			int row, int col) {
		ArrayList<Tuple<Integer, Integer>> moves = new ArrayList<Tuple<Integer, Integer>>();
		if (color == "white" && row-1 >= 0) {
			if (col-1 >= 0 && chessBoard[row-1][col-1].isBlack()) // pawn can eat
				moves.add(new Tuple<Integer,Integer>(row-1,col-1));
			if (col+1 < 8 && chessBoard[row-1][col+1].isBlack()) // pawn can eat
				moves.add(new Tuple<Integer,Integer>(row-1,col+1));
		} else if (color == "black" && row+1 < 8) {
			if (col-1 >= 0 && chessBoard[row+1][col-1].isWhite()) // pawn can eat
				moves.add(new Tuple<Integer,Integer>(row+1,col-1));
			if (col+1 < 8 && chessBoard[row+1][col+1].isWhite()) // pawn can eat
				moves.add(new Tuple<Integer,Integer>(row+1,col+1));
		} return moves;
	}

	@Override
	public ArrayList<Tuple<Integer, Integer>> potentialEatMoves(
			Cell[][] chessBoard, int row, int col) {
		ArrayList<Tuple<Integer, Integer>> moves = new ArrayList<Tuple<Integer, Integer>>();
		if (color == "white" && row-1 >= 0) {
			if (col-1 >= 0) // pawn can potentially eat
				moves.add(new Tuple<Integer,Integer>(row-1,col-1));
			if (col+1 < 8) // pawn can potentially eat
				moves.add(new Tuple<Integer,Integer>(row-1,col+1));
		} else if (color == "black" && row+1 < 8) {
			if (col-1 >= 0) // pawn can potentially eat
				moves.add(new Tuple<Integer,Integer>(row+1,col-1));
			if (col+1 < 8) // pawn can potentially eat
				moves.add(new Tuple<Integer,Integer>(row+1,col+1));
		} return moves;
	}

}
