package com.gorakh.lldrunner.chessgame;

public class ChessGameDemo {
    public static void run() {
        ChessBoard chessGame = new ChessBoard();
        chessGame.setPlayers("Alice", "Bob");
        chessGame.start();
    }
}
