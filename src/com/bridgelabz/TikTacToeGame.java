package com.bridgelabz;

import java.util.Scanner;

public class TikTacToeGame {
    static char PLAYER, COMPUTER;

    public static char[] createBoard() {
        char[] board = new char[10];    // initializing size of board
        for (int index = 1; index < board.length; index++) {

            board[index] = ' ';   // assigning empty value
        }
        return board;
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Tik Tac Toe Game");
        char[] board = createBoard();
        System.out.println("Select the letter \n press 1. Choose X \n press 2.Choose O \n Enter your choice:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                PLAYER = 'X';
                COMPUTER = 'O';
                break;
            case 2:
                PLAYER = 'O';
                COMPUTER = 'X';
                break;

            default:
                System.out.println("Invalid Choice ! Retry Again!");
                return;

        }

    }
}


