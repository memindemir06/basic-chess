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
    p.colour = p;
  }
}
