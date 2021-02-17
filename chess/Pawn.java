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
	public boolean isLegitMove(int x1, int y1, int x2, int y2){
		boolean isAtStartPos = false;
		boolean checkEnemy = false;
		PieceColour cl = getColour();
		switch (cl) {
			case WHITE:
				if (y1 == 7) {
					isAtStartPos = true;
				}
				break;
			case BLACK:
				if (y1 == 1) {
					isAtStartPos = true;
				}
				break;
		}

		if (isAtStartPos && x1 == x2) {
			return true;
		}
		return false;
	}
}
