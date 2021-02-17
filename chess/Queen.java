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

  public boolean isLegitMove(int x1, int y1, int x2, int y2){
    // Check if there is a move at all
    if (x1 == x2 && y1 == y2) {
      return false;
    }
    // Check if Queen moved vertically
    else if (x1 == x2 && y1!= y2) {
      return true;
    }
    // Check if Queen moved horizantally
    else if (y1 == y2 && x1!= x2) {
      return true;
    }
    // Check if Queen moved diagonally
    else if (Math.abs(x1-x2) == Math.abs(y1-y2)) {
      return true;
    }
    else return false;
  }
}
