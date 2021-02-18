package chess;
import java.util.Scanner;  // Import the Scanner class

public class Game {
	private static boolean gameEnd=false;

	//This method requires your input
	public static void play(){
		String whiteMove = "------ Whites Move ------";
		String blackMove = "------ Blacks Move ------";
		int turnCheck = 1;		// If 1 -> Whites move, If -1 -> Blacks move
		CheckInput c = new CheckInput();
		//PieceColour p;
		while (!gameEnd){
			if (turnCheck == 1) System.out.println(whiteMove);
			else System.out.println(blackMove);
			Scanner input = new Scanner(System.in);
			System.out.print("> Enter origin: ");
			String origin = input.nextLine();
			// Validating origin coordinates
			while (!c.checkCoordinateValidity(origin)){
				System.out.print("> Enter a valid coordinate: ");
				origin = input.nextLine();
			}
			int row0 = Integer.parseInt(String.valueOf(origin.charAt(0))) - 1;
    	int col0 = Integer.parseInt(String.valueOf((char) (origin.charAt(1) - 49)));
			boolean checkPiece = false;
			if(turnCheck == 1){
				while (!Board.hasPiece(row0,col0) || Board.getPiece(row0,col0).getColour() != PieceColour.WHITE){
					System.out.print("> Enter a valid origin coordinate: ");
					origin = input.nextLine();
				}
			}
			else {
				while (!Board.hasPiece(row0,col0) || Board.getPiece(row0,col0).getColour() != PieceColour.BLACK){
					System.out.print("> Enter a valid origin coordinate: ");
					origin = input.nextLine();
				}
			}
			row0 = Integer.parseInt(String.valueOf(origin.charAt(0))) - 1;
    	col0 = Integer.parseInt(String.valueOf((char) (origin.charAt(1) - 49)));
			System.out.print("> Enter destination: ");
			String destination = input.nextLine();
			while (!c.checkCoordinateValidity(destination)){
				System.out.print("> Enter a valid coordinate: ");
				destination = input.nextLine();
			}
			int row1 = Integer.parseInt(String.valueOf(destination.charAt(0))) - 1;
    	int col1 = Integer.parseInt(String.valueOf((char) (destination.charAt(1) - 49)));
			if ( Board.getPiece(row0,col0).isLegitMove(row0,col0,row1,col1)) {
				gameEnd = Board.movePiece(row0,col0,row1,col1,Board.getPiece(row0,col0));
				Board.printBoard();
			}
			turnCheck *= -1;
		}
		if (turnCheck == 1) System.out.println("WHITES WON UwU");
		else System.out.println("BLACKS WON UwU");
	}

	//This method should not be edited
	public static void main (String args[]){
		Board.initialiseBoard();
		Board.initialisePieces();
		Board.printBoard();
		Game.play();	}
}
