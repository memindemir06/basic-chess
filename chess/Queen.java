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
    p.colour = p;
  }
}
