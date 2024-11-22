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

    @Override
    public String toString() {
        return row + ", " + column;
    }
}
