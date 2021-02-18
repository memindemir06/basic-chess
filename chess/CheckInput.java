package chess;

public class CheckInput {

	//This method requires your input
	public boolean checkCoordinateValidity(String input){
		if (input.length() != 2) return false;
		else {
			char row = input.charAt(0);
			int row_ascii = (int) row;
			char col = input.charAt(1);
			int col_ascii = (int) col;
			if (row_ascii <= 56 && row_ascii >= 49 && col_ascii <= 104 && col_ascii >= 97) return true;
		}
		return false;
	}
}
