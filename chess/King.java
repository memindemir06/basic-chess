package chess;

public class King extends Piece{
	public King(PieceColour p){
		switch (p) {
      case WHITE:
        setSymbol("♔");
        break;
      case BLACK:
        setSymbol("♚");
        break;
    }
		p.colour = p;
	}

}
