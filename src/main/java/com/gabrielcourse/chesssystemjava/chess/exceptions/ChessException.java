package com.gabrielcourse.chesssystemjava.chess.exceptions;

import com.gabrielcourse.chesssystemjava.boardgame.exceptions.BoardException;

public class ChessException extends BoardException {

    public ChessException(String message) {
        super(message);
    }
}
