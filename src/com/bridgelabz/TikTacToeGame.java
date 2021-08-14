package com.bridgelabz;

import java.util.Scanner;

public class TikTacToeGame {
    static char PLAYER, COMPUTER;
    static char[] board = new char[10];

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game");
        createBoard();
        choosingXorO();
        currentBoard();
    }

    private static void createBoard() {
        board = new char[10];
        for (int i = 1; i < 10; i++) {
            board[i] = ' ';
        }
    }

    private static void choosingXorO() {
        Scanner s = new Scanner(System.in);
        System.out.println("Choose 1 for 'X' or Choose 2 for 'O' as your mark");
        int option = s.nextInt();
        switch (option) {
            case 1: PLAYER = 'X';
                COMPUTER = 'O';
                break;
            case 2: PLAYER = 'O';
                COMPUTER = 'X';
                break;
            default:
                System.out.println("Your input is invalid");
                choosingXorO();
        }
    }

    private static void showBoard() {
        System.out.println("\n  "+board[1]+" | "+board[2]+" | "+board[3]+" ");
        System.out.println(" ----------- ");
        System.out.println("  "+board[4]+" | "+board[5]+" | "+board[6]+" ");
        System.out.println(" ----------- ");
        System.out.println("  "+board[7]+" | "+board[8]+" | "+board[9]+" \n");
    }

    private static void currentBoard() {
        for (int i=1;i<10;i++) {
            if (board[i] !='X'&&board[i] !='O') {
                board[i]=(char) (i+'0');
            }
        }
        showBoard();
    }
}
