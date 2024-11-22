package com.gabrielcourse.chesssystemjava.chess;

import com.gabrielcourse.chesssystemjava.boardgame.Board;
import com.gabrielcourse.chesssystemjava.boardgame.Piece;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ChessPiece extends Piece {

    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }
}
