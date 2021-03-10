package chess;

public class Knight extends Piece {
  public Knight(PieceColour p){
    switch (p) {
      case WHITE:
        setSymbol("♘");
        break;
      case BLACK:
        setSymbol("♞");
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
    // List of the movements that Knight can make
    int legitMoves[][] = {
      {1,2},
      {2,1},
      {1,-2},
      {2,-1},
      {-1,2},
      {-2,1},
      {-1,-2},
      {-2,-1}
    };
    // Check if user made one of the legit moves
    for (int i = 0; i<legitMoves.length; i++) {
      if (i0 + legitMoves[i][0] == i1 && j0 + legitMoves[i][1] == j1) {
        return true;
      }
    }
    return false;
  }
}
