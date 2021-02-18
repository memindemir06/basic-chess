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
  public boolean isLegitMove(int i0, int j0, int i1, int j1){
    // Check if there is a piece with the same colour at the destination
		if (Board.hasPiece(i1,j1) && Board.getPiece(i1,j1).getColour() == getColour()) {
			return false;
		}
    //  Check if Rook moves horizantally or vertically
    if(i0 != i1 && j0 != j1){
      return false;
    }
    // Check if there is a move at all
    else if(i0 == i1 && j0 == j1){
      return false;
    }
    // Check if there is a piece on the path
    int pathDirection;
    if (i0 == i1 && j0 != j1) {
      if(j0 < j1) pathDirection = 1;      // Go right
      else pathDirection = -1;            // Go left
      int j = j0 + pathDirection;
      while (j != j1) {
        if (Board.hasPiece(i0,j)) return false;
        j += pathDirection;
      }
      return true;
    }
    else if (j0 == j1 && i0 != i1) {
      if(i0 < i1) pathDirection = 1;    // Go down
      else pathDirection = -1;          // Go up
      int i = i0 + pathDirection;
      while (i != i1) {
        if (Board.hasPiece(i,j0)) return false;
        i += pathDirection;
      }
      return true;
    }
    else return false;
  }
}
