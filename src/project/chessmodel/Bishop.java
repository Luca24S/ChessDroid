package project.chessmodel;

import java.util.ArrayList;

public class Bishop extends Piece {
	
	public Bishop(String color) {
		super(color);
	}

	@Override
	public ArrayList<Tuple<Integer, Integer>> validMoves(Cell[][] chessBoard,
			int row, int col) {
		ArrayList<Tuple<Integer, Integer>> moves = new ArrayList<Tuple<Integer, Integer>>();
		int x = 0;
		int y = 0;
		if (color == "white") {
			// bishop can go upwards-right
			x = row-1;
			y = col+1;
			while (x >= 0 && y < 8 && chessBoard[x][y].isEmpty())
				moves.add(new Tuple<Integer,Integer>(x,y));
				x--;
				y++;
			if (chessBoard[x][y].isBlack())
				moves.add(new Tuple<Integer,Integer>(x,y));
			// bishop can go upwards-left
			x = row-1;
			y = col-1;
			while (x >= 0 && y >= 0 && chessBoard[x][y].isEmpty())
				moves.add(new Tuple<Integer,Integer>(x,y));
				x--;
				y--;
			if (chessBoard[x][y].isBlack())
				moves.add(new Tuple<Integer,Integer>(x,y));
			// bishop can go downward-right
			x = row+1;
			y = col+1;
			while (x < 8 && y < 8 && chessBoard[x][y].isEmpty())
				moves.add(new Tuple<Integer,Integer>(x,y));
				x++;
				y++;
			if (chessBoard[x][y].isBlack())
				moves.add(new Tuple<Integer,Integer>(x,y));
			// bishop can go downward-left
			x = row+1;
			y = col-1;
			while (x < 8 && y >=0 && chessBoard[x][y].isEmpty())
				moves.add(new Tuple<Integer,Integer>(x,y));
				x++;
				y--;
			if (chessBoard[x][y].isBlack())
				moves.add(new Tuple<Integer,Integer>(x,y));
		} else if (color == "black") {
			// bishop can go upwards-right
			x = row-1;
			y = col+1;
			while (x >= 0 && y < 8 && chessBoard[x][y].isEmpty())
				moves.add(new Tuple<Integer,Integer>(x,y));
				x--;
				y++;
			if (chessBoard[x][y].isWhite())
				moves.add(new Tuple<Integer,Integer>(x,y));
			// bishop can go upwards-left
			x = row-1;
			y = col-1;
			while (x >= 0 && y >= 0 && chessBoard[x][y].isEmpty())
				moves.add(new Tuple<Integer,Integer>(x,y));
				x--;
				y--;
			if (chessBoard[x][y].isWhite())
				moves.add(new Tuple<Integer,Integer>(x,y));
			// bishop can go downwards-right
			x = row+1;
			y = col+1;
			while (x < 8 && y < 8 && chessBoard[x][y].isEmpty())
				moves.add(new Tuple<Integer,Integer>(x,y));
				x++;
				y++;
			if (chessBoard[x][y].isWhite())
				moves.add(new Tuple<Integer,Integer>(x,y));
			// bishop can go downwards-left
			x = row+1;
			y = col-1;
			while (x < 8 && y >=0 && chessBoard[x][y].isEmpty())
				moves.add(new Tuple<Integer,Integer>(x,y));
				x++;
				y--;
			if (chessBoard[x][y].isWhite())
				moves.add(new Tuple<Integer,Integer>(x,y));
		} return moves;
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
