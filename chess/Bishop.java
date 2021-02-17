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
    p.colour = p;
  }
}
