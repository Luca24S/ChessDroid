package project.chessmodel;

import java.util.ArrayList;

public class King extends Piece {
	
	public King(String color) {
		super(color);
	}

	@Override
	public ArrayList<Tuple<Integer, Integer>> validMoves(Cell[][] chessBoard,
			int row, int col) {
		ArrayList<Tuple<Integer, Integer>> moves = new ArrayList<Tuple<Integer, Integer>>();
		// can move by 1 cell in every direction
		int x = 0;
		int y = 0;
		if (color == "white") {
			// go leftwards
			x = row;
			y = col-1;
			if (y >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer, Integer>(x,y));
			// go up-leftwards
			x = row-1;
			if (x >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer, Integer>(x,y));
			// go upwards
			y = col;
			if (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack())
				moves.add(new Tuple<Integer, Integer>(x,y));
			// go up-rightwards
			y = col+1;
			if (y < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer, Integer>(x,y));
			// go rightwards
			x = row;
			if (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack())
				moves.add(new Tuple<Integer, Integer>(x,y));
			// go down-rightwards
			x = row+1;
			y = col+1;
			if (x < 8 && y < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer, Integer>(x,y));
			// go downwards
			y = col;
			if (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack())
				moves.add(new Tuple<Integer, Integer>(x,y));
			// go down-leftwards
			y = col-1;
			if (y >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer, Integer>(x,y));
		} else if (color == "black") {
			// go leftwards
			y = col-1;
			if (y >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer, Integer>(x,y));
			// go up-leftwards
			x = row-1;
			if (x >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer, Integer>(x,y));
			// go upwards
			y = col;
			if (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite())
				moves.add(new Tuple<Integer, Integer>(x,y));
			// go up-rightwards
			y = col+1;
			if (y < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer, Integer>(x,y));
			// go rightwards
			x = row;
			if (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite())
				moves.add(new Tuple<Integer, Integer>(x,y));
			// go down-rightwards
			x = row+1;
			y = col+1;
			if (x < 8 && y < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer, Integer>(x,y));
			// go downwards
			y = col;
			if (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite())
				moves.add(new Tuple<Integer, Integer>(x,y));
			// go down-leftwards
			y = col-1;
			if (y >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer, Integer>(x,y));
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
