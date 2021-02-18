package chess;

public class Bishop extends Piece{
  public Bishop(PieceColour p){
    switch (p) {
      case WHITE:
        setSymbol("♗");
        break;
      case BLACK:
        setSymbol("♝");
        break;
    }
    colour = p;
  }

  public boolean isLegitMove(int i0, int j0, int i1, int j1){
    // Check if there is a piece with the same colour at the destination
		if (Board.hasPiece(i1,j1) && Board.getPiece(i1,j1).getColour() == getColour()) {
			return false;
		}
    // Check if Bishop moved at all
    if (i0 == i1 || j0 == j1) {
      return false;
    }
    // Check if Bishop moved diagonally
    else if (Math.abs(i0-i1) == Math.abs(j0-j1)) {
      int[] pathDirection;
      pathDirection = new int[2];
      if (i0 < i1 && j0 < j1) {pathDirection[0] = 1; pathDirection[1] = 1 ;}   //Destination at bottom right
      if (i0 > i1 && j0 < j1) {pathDirection[0] = -1; pathDirection[1] = 1 ;}    //Destination at top right
      if (i0 < i1 && j0 > j1) {pathDirection[0] = 1; pathDirection[1] = -1 ;}  //Destination at bottom left
      if (i0 > i1 && j0 > j1) {pathDirection[0] = -1; pathDirection[1] = -1 ;}   //Destination at top left
      // 2,7  0,5
      int i = i0 + pathDirection[0];
      int j = j0 + pathDirection[1];
      while (i != i1 && j != j1) {
        if (Board.hasPiece(i,j)) return false;
        i += pathDirection[0];
        j += pathDirection[1];
      }
      return true;
    }
    else return false;
  }
}
