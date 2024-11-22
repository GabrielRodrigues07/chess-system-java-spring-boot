package com.gabrielcourse.chesssystemjava.application;

import com.gabrielcourse.chesssystemjava.chess.ChessMatch;

public class Program {

    public static void main(String[] args) {

        ChessMatch chessMatch = new ChessMatch();

        UI.printBoard(chessMatch.getPieces());
    }
}
