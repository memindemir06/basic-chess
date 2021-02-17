package chess;

public class Rook extends Piece{
  public Rook(PieceColour p){
    switch (p) {
      case WHITE:
        setSymbol("♖");
        break;
      case BLACK:
        setSymbol("♜");
        break;
    }
    colour = p;
  }
  public boolean isLegitMove(int x1, int y1, int x2, int y2){
    // Check if there is a piece with the same colour at the destination
		if (Board.hasPiece(x2,y2) && Board.getPiece(x2,y2).getColour() == getColour()) {
			return false;
		}
    //  Check if Rook moves horizantally or vertically
    if(x1 != x2 && y1 != y2){
      return false;
    }
    // Check if there is a move at all
    else if(x1 == x2 && y1 == y2){
      return false;
    }
    else if (x1 == x2 && y1 != y2) {
      boolean checkDirection = false;
      if (y1-y2<0) checkDirection = true;
      if (checkDirection) {
        for (int i = y1+1; i<y2; i++) {
          if (Board.hasPiece(x1,i)) return false;
        }
      }
      else {
        for (int i = y1-1; i>y2; i--) {
          if (Board.hasPiece(x1,i)) return false;
        }
      }
      return true;
    }
    else if (y1 == y2 && x1 != x2) {
      boolean checkDirection = false;
      if (x1-x2<0) checkDirection = true;
      if (checkDirection) {
        for (int i = x1+1; i<x2; i++) {
          if (Board.hasPiece(i,y1)) return false;
        }
      }
      else {
        for (int i = x1-1; i>x2; i--) {
          if (Board.hasPiece(i,y1)) return false;
        }
      }
      return true;
    }
    else return false;
  }
}
