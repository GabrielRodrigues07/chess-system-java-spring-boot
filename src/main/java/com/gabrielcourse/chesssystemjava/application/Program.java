package com.gabrielcourse.chesssystemjava.application;

import com.gabrielcourse.chesssystemjava.chess.ChessMatch;
import com.gabrielcourse.chesssystemjava.chess.ChessPiece;
import com.gabrielcourse.chesssystemjava.chess.ChessPosition;
import com.gabrielcourse.chesssystemjava.chess.exceptions.ChessException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces());

                System.out.println();
                System.out.print("Source: ");

                ChessPosition source = UI.readChessPosition(scanner);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(scanner);
                System.out.println();

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            } catch (ChessException | InputMismatchException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }

//            scanner.close();
    }
}
