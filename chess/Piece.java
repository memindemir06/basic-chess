package chess;

//This class requires your input
public class Piece {
	private String symbol;
	protected PieceColour colour;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String s){
		symbol = s;
	}

	public PieceColour getColour(){
		return colour;
	}

	public boolean isLegitMove(int i0, int j0, int i1, int j1){
		return true;
	}
}
