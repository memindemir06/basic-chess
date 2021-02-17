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

  public boolean isLegitMove(int x1, int y1, int x2, int y2){
    // Check if Bishop moved at all
    if (x1 == x2 || y1 == y2) {
      return false;
    }
    // Check if Bishop moved diagonally
    else if (Math.abs(x1-x2) == Math.abs(y1-y2)) {
      for (int i = 1; i<Math.abs(x1-x2); i++) {
        break;
      }
      return true;
    }
    else return false;
  }
}
