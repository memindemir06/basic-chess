package chess;

public class Pawn extends Piece{
	public Pawn(PieceColour p){
		switch (p) {
      case WHITE:
        setSymbol("♙");
        break;
      case BLACK:
        setSymbol("♟");
        break;
    }
		colour = p;
	}
	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1){
		boolean isAtStartPos = false;
		PieceColour c = getColour();
		// Check if there is a piece with the same colour at the destination
		if (Board.hasPiece(i1,j1) && Board.getPiece(i1,j1).getColour() == getColour()) {
			return false;
		}
		// Check if Pawn moves more than one square horizantally
		if (Math.abs(j0-j1) > 1) return false;
		// Check if Pawn captures a piece
		if (Math.abs(j0-j1) == 1){
			if ((c == PieceColour.BLACK && i1-i0 == 1) || (c == PieceColour.WHITE && i0-i1 == 1 )){
				if (Board.hasPiece(i1,j1) && Board.getPiece(i1,j1).getColour() != getColour()) return true;
				return false;
			}
			return false;
		}

		// Check if Pawn has moved before
		if ((c == PieceColour.BLACK && i0 == 1) || (c == PieceColour.WHITE && i0 == 6)) isAtStartPos = true;
		if (c == PieceColour.BLACK) {
			if (isAtStartPos && i1 - i0 == 2 && !Board.hasPiece(i1-1,j1) && !Board.hasPiece(i1,j1)) return true;
			else if (i1 - i0 == 1 && !Board.hasPiece(i1,j1)) return true;
			else return false;
		}
		if (c == PieceColour.WHITE) {
			if (isAtStartPos && i0 - i1 == 2 && !Board.hasPiece(i1+1,j1) && !Board.hasPiece(i1,j1)) return true;
			else if (i0 - i1 == 1 && !Board.hasPiece(i1,j1)) return true;
			else return false;
		}

		return false;
	}
}
