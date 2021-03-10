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
	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1){
		// Check if there is a piece with the same colour at the destination
		if (Board.hasPiece(i1,j1) && Board.getPiece(i1,j1).getColour() == getColour()) {
			return false;
		}
		// Check if King moved one square horizantally
		if (Math.abs(i0-i1) == 1 && j0 == j1) {
			return true;
		}
		// Check if King moved one square vertically
		else if (Math.abs(j0-j1) == 1 && i0 == i1) {
			return true;
		}
		// Check if King moved one square diagonally
		else if (Math.abs(i0-i1) == 1 && Math.abs(j0-j1) == 1) {
			return true;
		}
		else return false;
	}

}
