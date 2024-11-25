package com.gabrielcourse.chesssystemjava.chess;

import com.gabrielcourse.chesssystemjava.boardgame.Board;
import com.gabrielcourse.chesssystemjava.boardgame.Piece;
import com.gabrielcourse.chesssystemjava.boardgame.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public abstract class ChessPiece extends Piece {

    private Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return Objects.nonNull(p) && !color.equals(p.color);
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }
}
