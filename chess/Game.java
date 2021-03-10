package chess;
import java.util.Scanner;  // Import the Scanner class
import java.io.Console;

public class Game {
	private static boolean gameEnd=false;

	//This method requires your input
	public static void play(){
		String whiteMove = "------ Whites Move ------";
		String blackMove = "------ Blacks Move ------";
		int turnCheck = 1;		// If 1 -> Whites move, If -1 -> Blacks move
		boolean terminateCheck = false; // variable to check if the game is terminated
		boolean checkOrigin = false;
		CheckInput c = new CheckInput();
		//PieceColour p;
		while (!gameEnd){
			// PRINT WHICH COLOUR HAS THE TURN
			if (turnCheck == 1) System.out.println(whiteMove);
			else System.out.println(blackMove);

			// VALIDATE AND GET ORIGIN INPUT (row0,col0)
			Console keyboardConsole = System.console();
			String origin;
			int row0 = 0;
			int col0 = 0;
			do {
				origin = keyboardConsole.readLine("> Enter origin: ");
				if (origin.equals("END")) break;
				if (c.checkCoordinateValidity(origin)){
					row0 = Integer.parseInt(String.valueOf(origin.charAt(0))) - 1;
					col0 = Integer.parseInt(String.valueOf((char) (origin.charAt(1) - 49)));
					if (Board.hasPiece(row0,col0)) {
						if (turnCheck == 1 && Board.getPiece(row0,col0).getColour() == PieceColour.WHITE) checkOrigin = true;
						if (turnCheck == 0 && Board.getPiece(row0,col0).getColour() == PieceColour.BLACK) checkOrigin = true;
					}
				}
			} while (!checkOrigin || row0 == 0 || col0 == 0);

			if (origin.equals("END")) {
				gameEnd = true;
				terminateCheck = true;
				break;
			}

			// VALIDATE AND GET DESTINATION INPUT (row1,col1)
			String destination;
			do {
				destination = keyboardConsole.readLine("> Enter destination: ");
				if (destination.equals("END")) break;
			} while (!c.checkCoordinateValidity(destination));
			if (destination.equals("END")) {
				gameEnd = true;
				terminateCheck = true;
				break;
			}
			int row1 = Integer.parseInt(String.valueOf(destination.charAt(0))) - 1;
			int col1 = Integer.parseInt(String.valueOf((char) (destination.charAt(1) - 49)));

			// CHECK MOVE VALIDITY
			if (Board.getPiece(row0,col0).isLegitMove(row0,col0,row1,col1)) {
				gameEnd = Board.movePiece(row0,col0,row1,col1,Board.getPiece(row0,col0));
				Board.printBoard();
			}
			else {continue;}
			// CHANGE TURN
			turnCheck *= -1;
		}
		// DETERMINE THE WINNER AND PRINT TO CONSOLE
		if (terminateCheck) {
			System.out.println("You quit the game!");
		}
		else {
			if (turnCheck == 1) System.out.println("------ Blacks Won UwU ------");
			else System.out.println("------ Whites Won UwU ------");
		}
	}

	//This method should not be edited
	public static void main (String args[]){
		Board.initialiseBoard();
		Board.initialisePieces();
		Board.printBoard();
		Game.play();	}
}
