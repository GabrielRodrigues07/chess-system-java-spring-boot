package com.gabrielcourse.chesssystemjava.chess;

import com.gabrielcourse.chesssystemjava.boardgame.Position;
import com.gabrielcourse.chesssystemjava.chess.exceptions.ChessException;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ChessPosition {

    private char column;
    private Integer row;

    public ChessPosition(char column, Integer row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Error instantiating ChessPosition. Valid values are from A1 to H8.");
        }
        this.column = column;
        this.row = row;
    }

    protected Position toPosition() {
        return new Position(8 - row, column - 'a');
    }

    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}
