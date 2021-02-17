package chess;

public class King extends Piece{
	public King(PieceColour p){
		switch (p) {
      case WHITE:
        setSymbol("♔");
        break;
      case BLACK:
        setSymbol("♚");
        break;
    }
		colour = p;
	}

	public boolean isLegitMove(int x1, int y1, int x2, int y2){
		// Check if there is a piece with the same colour at the destination
		if (Board.hasPiece(x2,y2) && Board.getPiece(x2,y2).getColour() == getColour()) {
			return false;
		}
		// Check if King moved one square horizantally
		if (Math.abs(x1-x2) == 1 && y1 == y2) {
			return true;
		}
		// Check if King moved one square vertically
		else if (Math.abs(y1-y2) == 1 && x1 == x2) {
			return true;
		}
		// Check if King moved one square diagonally
		else if (Math.abs(x1-x2) == 1 && Math.abs(y1-y2) == 1) {
			return true;
		}
		else return false;
	}

}
