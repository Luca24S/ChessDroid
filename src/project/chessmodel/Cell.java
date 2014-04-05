package project.chessmodel;

public class Cell {
	
	private Piece piece;
	private String color;
	
	public Cell(boolean color, Piece piece) {
		if (color) {
			this.color = "black";
		} else {
			this.color = "white";
		}
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public Piece getPiece() {
		return piece;
	}
	
	@Override
	public String toString() {
		return color+","+piece.toString();
	}
	
	public String printEmptyCell() {
		return color;
	}
	
	public boolean isEmpty() {
		return piece == null;
	}
	
	public boolean isBusy() {
		return piece != null;
	}
	
	public boolean isWhite() {
		return isBusy() && piece.getColor() == "white";
	}
	
	public boolean isBlack() {
		return isBusy() && piece.getColor() == "black";
	}
	
	public boolean isBlackKing() {
		return isBusy() && piece instanceof King;
	}
	
	public boolean isWhiteKing() {
		return isBusy() && piece instanceof King;
	}

}
