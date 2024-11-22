package com.gabrielcourse.chesssystemjava.boardgame;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Piece {

    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        this.position = null;
    }

    protected Board getBoard() {
        return board;
    }
}
