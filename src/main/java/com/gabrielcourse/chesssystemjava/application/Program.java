package com.gabrielcourse.chesssystemjava.application;

import com.gabrielcourse.chesssystemjava.chess.ChessMatch;
import com.gabrielcourse.chesssystemjava.chess.ChessPiece;
import com.gabrielcourse.chesssystemjava.chess.ChessPosition;
import com.gabrielcourse.chesssystemjava.chess.exceptions.ChessException;

import java.util.*;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (!chessMatch.getCheckMate()) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);

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
                if (Objects.nonNull(capturedPiece)) {
                    captured.add(capturedPiece);
                }

                if (Objects.nonNull(chessMatch.getPromoted())) {
                    System.out.print("Enter piece for promotion (B/N/R/Q): ");
                    String type = scanner.nextLine().toUpperCase();
                    while (!"B".equalsIgnoreCase(type) && !"N".equalsIgnoreCase(type) && !"R".equalsIgnoreCase(type) && !"Q".equalsIgnoreCase(type)) {
                        System.out.print("Invalid value! Enter piece for promotion (B/N/R/Q): ");
                        type = scanner.nextLine().toUpperCase();
                    }
                    chessMatch.replacePromotedPiece(type);
                }

            } catch (ChessException | InputMismatchException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);

        scanner.close();
    }
}
