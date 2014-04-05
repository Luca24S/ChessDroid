package project.chessmodel;

import java.util.ArrayList;

public class ChessBoard {
	
	private Cell[][] chessBoard = new Cell[8][8];
	private String turn = "white";
	
	public ChessBoard() {
		init();
	}
	
	private void init() {
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard.length; j++) {
				if (isOdd(i+j)) {
					chessBoard[i][j] = new Cell(true, null);
				} else {
					chessBoard[i][j] = new Cell(false, null);
				}
			}
		}
		// put the pieces onto the chessboard
		// black player
		chessBoard[0][0].setPiece(new Rook("black"));
		chessBoard[0][7].setPiece(new Rook("black"));
		chessBoard[0][1].setPiece(new Knight("black"));
		chessBoard[0][6].setPiece(new Knight("black"));
		chessBoard[0][2].setPiece(new Bishop("black"));
		chessBoard[0][5].setPiece(new Bishop("black"));
		chessBoard[0][3].setPiece(new Queen("black"));
		chessBoard[0][4].setPiece(new King("black"));
		for(int j = 0; j < chessBoard.length; j++) {
			chessBoard[1][j].setPiece(new Pawn("black"));
		}
		// white player
		chessBoard[7][0].setPiece(new Rook("white"));
		chessBoard[7][7].setPiece(new Rook("white"));
		chessBoard[7][1].setPiece(new Knight("white"));
		chessBoard[7][6].setPiece(new Knight("white"));
		chessBoard[7][2].setPiece(new Bishop("white"));
		chessBoard[7][5].setPiece(new Bishop("white"));
		chessBoard[7][3].setPiece(new Queen("white"));
		chessBoard[7][4].setPiece(new King("white"));
		for(int j = 0; j < chessBoard.length; j++) {
			chessBoard[6][j].setPiece(new Pawn("white"));
		}
	}
	
	private void changeTurn() {
		if (turn == "white")
			turn = "black";
		else if (turn == "black")
			turn = "white";
	}
	
	// move a piece from one cell to another
	public void move(int fromRow, int fromCol, int toRow, int toCol) {
		chessBoard[toRow][toCol].setPiece(chessBoard[fromRow][fromCol].getPiece());;
		chessBoard[fromRow][fromCol].setPiece(null);
		changeTurn();
	}
	
	// compute the cells a piece can go to
	public ArrayList<Tuple<Integer,Integer>> validMoves(int row, int col) {
		assert (row >= 0 && row < 8 && col >= 0 && col < 8);
		Cell cell = chessBoard[row][col];
		if (cell.isBusy()) {
			return cell.getPiece().validMoves(chessBoard, row, col);
		} return new ArrayList<Tuple<Integer,Integer>>();
	}
	
	// compute the cells a piece can go to and eat
	public ArrayList<Tuple<Integer,Integer>> eatMoves(int row, int col) {
		assert (row >= 0 && row < 8 && col >= 0 && col < 8);
		Cell cell = chessBoard[row][col];
		return cell.getPiece().eatMoves(chessBoard, row, col);
	}
	
	// detect whether a cell is reachable by some opponent's piece
	public boolean isInOpponentCheck(String player, int row, int col) {
		Tuple<Integer,Integer> thisCell = new Tuple<Integer,Integer>(row,col);
		Cell cell;
		String color;
		Piece piece;
		ArrayList<Tuple<Integer,Integer>> couldEat;
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cell = chessBoard[x][y];
				if (cell.isBusy()) {
					color = cell.getPiece().getColor();
					piece = cell.getPiece();
					couldEat = piece.potentialEatMoves(chessBoard,x,y);
					if (color == player && couldEat.contains(thisCell)) {
						return true;
					}
				}
			}
		} return false;
	}
	
	public Cell[][] getChessBoard() {
		return chessBoard;
	}
	
	private boolean isOdd(int n) {
		return n % 2 > 0;
	}
	
	public static void main(String[] args) {
		ChessBoard c = new ChessBoard();
		Cell[][] chess = c.getChessBoard();
		for (int i = 0; i < chess.length; i++)
			for (int j = 0; j < chess.length; j++)
				if (chess[i][j].getPiece() == null)
					System.out.println((i+1)+","+(j+1)+","+chess[i][j].printEmptyCell());
				else
					System.out.println((i+1)+","+(j+1)+","+chess[i][j]);
	}
	

}
