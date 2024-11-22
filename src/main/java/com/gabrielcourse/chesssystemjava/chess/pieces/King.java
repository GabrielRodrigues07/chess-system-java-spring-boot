package com.gabrielcourse.chesssystemjava.chess.pieces;

import com.gabrielcourse.chesssystemjava.boardgame.Board;
import com.gabrielcourse.chesssystemjava.chess.ChessPiece;
import com.gabrielcourse.chesssystemjava.chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }
}
