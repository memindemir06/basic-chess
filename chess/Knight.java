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

  public boolean isLegitMove(int x1, int y1, int x2, int y2){
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
      if (x1 + legitMoves[i][0] == x2 && y1 + legitMoves[i][1] == y2) {
        return true;
      }
    }
    return false;
  }
}
