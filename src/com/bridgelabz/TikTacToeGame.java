package com.bridgelabz;

public class TikTacToeGame {
    static char[] board = new char[10];

    private static void generateBoard() {

        for (int i = 1; i < 10; i++) {
            board[i] = ' ';
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game");
        generateBoard();
    }

}