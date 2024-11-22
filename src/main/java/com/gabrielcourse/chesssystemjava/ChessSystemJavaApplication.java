package com.gabrielcourse.chesssystemjava;

import com.gabrielcourse.chesssystemjava.boardgame.Position;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChessSystemJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChessSystemJavaApplication.class, args);

        Position position = new Position(3,5);

        System.out.println(position);
    }

}
