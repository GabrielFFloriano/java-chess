package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch match = new ChessMatch();
		
		
		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(match.getPieces());
				System.out.print("\nSource: ");
				ChessPosition source = UI.readChessPosition(sc);
				boolean[][] possibleMoves = match.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(match.getPieces(), possibleMoves);
				System.out.print("\nTarget: ");
				ChessPosition target = UI.readChessPosition(sc);
				ChessPiece capturedPiece = match.peformChessMove(source, target);
			} catch (ChessException e) {
				System.out.print(e.getMessage());
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.print(e.getMessage());
				sc.nextLine();
			}
		}
	
	}

}
