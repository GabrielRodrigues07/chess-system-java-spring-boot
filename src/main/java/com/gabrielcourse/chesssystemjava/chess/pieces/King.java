package com.gabrielcourse.chesssystemjava.chess.pieces;

import com.gabrielcourse.chesssystemjava.boardgame.Board;
import com.gabrielcourse.chesssystemjava.boardgame.Position;
import com.gabrielcourse.chesssystemjava.chess.ChessMatch;
import com.gabrielcourse.chesssystemjava.chess.ChessPiece;
import com.gabrielcourse.chesssystemjava.chess.Color;

import java.util.Objects;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return Objects.isNull(p) || !getColor().equals(p.getColor());
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return Objects.nonNull(p) && p instanceof Rook && getColor().equals(p.getColor()) && Objects.equals(p.getMoveCount(),0);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        // above
        p.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // below
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // left
        p.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // right
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // nw
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // ne
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // sw
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // se
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        // #specialMove castling
        if (Objects.equals(getMoveCount(),0) && !chessMatch.getCheck()) {
            // #specialMove castling kingSide move
            Position posT1 = new Position(position.getRow(), position.getColumn() + 3);

            if (testRookCastling(posT1)) {
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);

                if (Objects.isNull(getBoard().piece(p1)) && Objects.isNull(getBoard().piece(p2))) {
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }

            // #specialMove castling queenSide move
            Position posT2 = new Position(position.getRow(), position.getColumn() - 4);

            if (testRookCastling(posT2)) {
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);

                if (Objects.isNull(getBoard().piece(p1)) && Objects.isNull(getBoard().piece(p2)) && Objects.isNull(getBoard().piece(p3))) {
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

        return mat;
    }
}
