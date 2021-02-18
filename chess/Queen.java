package chess;

public class Queen extends Piece{
  public Queen(PieceColour p){
    switch (p) {
      case WHITE:
        setSymbol("♕");
        break;
      case BLACK:
        setSymbol("♛");
        break;
    }
    colour = p;
  }

  public boolean isLegitMove(int i0, int j0, int i1, int j1){
    // Check if there is a piece with the same colour at the destination
		if (Board.hasPiece(i1,j1) && Board.getPiece(i1,j1).getColour() == getColour()) {
			return false;
		}
    // Check if there is a move at all
    if (i0 == i1 && j0 == j1) {
      return false;
    }
    int pathDirection;
    // Check if queen moved horizantally
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
    // Check if queen moved vertically
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
    // Check if Queen moved diagonally
    else if (Math.abs(i0-i1) == Math.abs(j0-j1)) {
      int[] delta;
      delta = new int[2];
      if (i0 < i1 && j0 < j1) {delta[0] = 1; delta[1] = 1 ;}   //Destination at bottom right
      if (i0 > i1 && j0 < j1) {delta[0] = -1; delta[1] = 1 ;}    //Destination at top right
      if (i0 < i1 && j0 > j1) {delta[0] = 1; delta[1] = -1 ;}  //Destination at bottom left
      if (i0 > i1 && j0 > j1) {delta[0] = -1; delta[1] = -1 ;}   //Destination at top left
      // 2,7  0,5
      int i = i0 + delta[0];
      int j = j0 + delta[1];
      while (i != i1 && j != j1) {
        if (Board.hasPiece(i,j)) return false;
        i += delta[0];
        j += delta[1];
      }
      return true;
    }
    else return false;
  }
}
