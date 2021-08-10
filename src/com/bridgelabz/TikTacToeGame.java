package com.bridgelabz;

public class TikTacToeGame {
    public static void main(String[] args) {
        System.out.println("Welcome to Tik Tac Toe Game");
        createBoard();
    }

    public static char[] createBoard() {
        char[] board = new char[10];    // initializing size of board
        for (int index = 1; index < board.length; index++) {

            board[index] = ' ';   // assigning empty value
        }
        return board;
    }
}


