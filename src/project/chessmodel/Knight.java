package project.chessmodel;

import java.util.ArrayList;

public class Knight extends Piece {
	
	public Knight(String color) {
		super(color);
	}

	@Override
	public ArrayList<Tuple<Integer, Integer>> validMoves(Cell[][] chessBoard,
			int row, int col) {
		ArrayList<Tuple<Integer, Integer>> moves = new ArrayList<Tuple<Integer, Integer>>();
		int x = 0;
		int y = 0;
		if (color == "white") {
			// move upwards-right
			x = row-2;
			y = col+1;
			if (x >= 0 && y < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer,Integer>(x,y));
			// move upwards-left
			y = col-1;
			if (y >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer,Integer>(x,y));
			// move leftwards-up
			x = row-1;
			y = col-2;
			if (x >= 0 && y >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer,Integer>(x,y));
			// move leftwards-down
			x = row+1;
			if (x < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer,Integer>(x,y));
			// move downwards-left
			x = row+2;
			y = col-1;
			if (x < 8 && y >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer,Integer>(x,y));
			// move downwards-right
			y = col+1;
			if (y < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer,Integer>(x,y));
			// move rightwards-down
			x = row+1;
			y = col+2;
			if (x < 8 && y < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer,Integer>(x,y));
			// move rightwards-up
			x = row-1;
			if (x >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer,Integer>(x,y));
		} else if (color == "black") {
			// move upwards-right
			x = row-2;
			y = col+1;
			if (x >= 0 && y < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer,Integer>(x,y));
			// move upwards-left
			y = col-1;
			if (y >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer,Integer>(x,y));
			// move leftwards-up
			x = row-1;
			y = col-2;
			if (x >= 0 && y >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer,Integer>(x,y));
			// move leftwards-down
			x = row+1;
			if (x < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer,Integer>(x,y));
			// move downwards-left
			x = row+2;
			y = col-1;
			if (x < 8 && y >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer,Integer>(x,y));
			// move downwards-right
			y = col+1;
			if (y < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer,Integer>(x,y));
			// move rightwards-down
			x = row+1;
			y = col+2;
			if (x < 8 && y < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer,Integer>(x,y));
			// move rightwards-up
			x = row-1;
			if (x >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer,Integer>(x,y));
		}
		return moves;
	}

	@Override
	public ArrayList<Tuple<Integer, Integer>> eatMoves(Cell[][] chessBoard,
			int row, int col) {
		return validMoves(chessBoard,row,col);
	}

	@Override
	public ArrayList<Tuple<Integer, Integer>> potentialEatMoves(
			Cell[][] chessBoard, int row, int col) {
		return validMoves(chessBoard,row,col);
	}

}
