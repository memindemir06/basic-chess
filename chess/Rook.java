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
    //  Check if Rook moves horizantally or vertically
    if(x1 != x2 && y1 != y2){
      return false;
    }
    // Check if there is a move at all
    else if(x1 == x2 && y1 == y2){
      return false;
    }
    else return true;
  }
}
