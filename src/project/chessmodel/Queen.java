package project.chessmodel;

import java.util.ArrayList;

public class Queen extends Piece {
	
	public Queen(String color) {
		super(color);
	}

	@Override
	public ArrayList<Tuple<Integer, Integer>> validMoves(Cell[][] chessBoard,
			int row, int col) {
		ArrayList<Tuple<Integer, Integer>> moves = new ArrayList<Tuple<Integer, Integer>>();
		int x = 0;
		int y = 0;
		if (color == "white") {
			// go up
			x = row-1;
			y = col;
			while (x >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer,Integer>(x,y));
				x--;
			// go right
			x = row;
			y = col+1;
			while (y < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer,Integer>(x,y));
				y++;
			// go down
			x = row+1;
			y = col;
			while (x < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer,Integer>(x,y));
				x++;
			// go left
			x = row;
			y = col-1;
			while (y >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer,Integer>(x,y));
				y--;
			// go up-rightwards
			x = row-1;
			y = col+1;
			while (x >= 0 && y < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer,Integer>(x,y));
				x--;
				y++;
			// go up-leftwards
			x = row-1;
			y = col-1;
			while (x >= 0 && y >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer,Integer>(x,y));
				x--;
				y--;
			// go down-leftwards
			x = row+1;
			y = col-1;
			while (x < 8 && y >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer,Integer>(x,y));
				x++;
				y--;
			// go down-rightwards
			x = row+1;
			y = col+1;
			while (x < 8 && y < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isBlack()))
				moves.add(new Tuple<Integer,Integer>(x,y));
				x++;
				y++;
		} else if (color == "black") {
			// go up
			x = row-1;
			y = col;
			while (x >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer,Integer>(x,y));
				x--;
			// go right
			x = row;
			y = col+1;
			while (y < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer,Integer>(x,y));
				y++;
			// go down
			x = row+1;
			y = col;
			while (x < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer,Integer>(x,y));
				x++;
			// go left
			x = row;
			y = col-1;
			while (y >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer,Integer>(x,y));
				y--;
			// go up-rightwards
			x = row-1;
			y = col+1;
			while (x >= 0 && y < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer,Integer>(x,y));
				x--;
				y++;
			// go up-leftwards
			x = row-1;
			y = col-1;
			while (x >= 0 && y >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer,Integer>(x,y));
				x--;
				y--;
			// go down-leftwards
			x = row+1;
			y = col-1;
			while (x < 8 && y >= 0 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer,Integer>(x,y));
				x++;
				y--;
			// go down-rightwards
			x = row+1;
			y = col+1;
			while (x < 8 && y < 8 && (chessBoard[x][y].isEmpty() || chessBoard[x][y].isWhite()))
				moves.add(new Tuple<Integer,Integer>(x,y));
				x++;
				y++;
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
