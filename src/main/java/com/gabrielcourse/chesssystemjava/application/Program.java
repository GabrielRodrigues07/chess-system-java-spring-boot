package com.gabrielcourse.chesssystemjava.application;

import com.gabrielcourse.chesssystemjava.chess.ChessMatch;
import com.gabrielcourse.chesssystemjava.chess.ChessPiece;
import com.gabrielcourse.chesssystemjava.chess.ChessPosition;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ChessMatch chessMatch = new ChessMatch();

        while (true) {
            UI.printBoard(chessMatch.getPieces());

            System.out.println();
            System.out.print("Source: ");

            ChessPosition source = UI.readChessPosition(scanner);

            System.out.println();
            System.out.print("Target: ");
            ChessPosition target = UI.readChessPosition(scanner);
            System.out.println();

            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
        }

//            scanner.close();
    }
}
