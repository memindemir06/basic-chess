package chess;

public class Pawn extends Piece{
	public Pawn(PieceColour p){
		switch (p) {
      case WHITE:
        setSymbol("♙");
        break;
      case BLACK:
        setSymbol("♟");
        break;
    }
		p.colour = p;
	}
}
