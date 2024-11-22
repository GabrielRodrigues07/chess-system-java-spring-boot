package com.gabrielcourse.chesssystemjava.boardgame;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Position {

    private Integer row;
    private Integer column;

    public void setValues(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return row + ", " + column;
    }
}
