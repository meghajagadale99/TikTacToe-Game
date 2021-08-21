package com.bridgelabz;

import java.util.Scanner;

public class TikTacToeGame {
    static char userSymbol, compSymbol;
    private static char[] board;
    static int userInput;


    private static void generateBoard() {
        char[] board = new char[10];
        for (int i = 1; i < 10; i++) {
            board[i] = ' ';
        }
    }

    public static void chooseLetter() {
        System.out.println("Choose letter 'X' or 'O' (in Caps) : ");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (str.contains("X")) {
            char userSymbol = 'X';
            char compSymbol = 'O';
            System.out.println("User Symbol : " + userSymbol + " ; Comp Symbol : " + compSymbol);
        } else {
            char userSymbol = 'O';
            char compSymbol = 'X';
            System.out.println("User Symbol : " + userSymbol + " ; Comp Symbol : " + compSymbol);
        }
    }

    static void printBoard() {
        System.out.println("\n  " + board[1] + " | " + board[2] + " | " + board[3] + " ");
        System.out.println(" ----------- ");
        System.out.println("  " + board[4] + " | " + board[5] + " | " + board[6] + " ");
        System.out.println(" ----------- ");
        System.out.println("  " + board[7] + " | " + board[8] + " | " + board[9] + " \n");
    }

    private static void currentBoard() {
        for (int i = 1; i < 10; i++) {
            if (board[i] != 'X' && board[i] != 'O') {
                board[i] = (char) (i + '0');
            }
        }
        printBoard();
    }

    private static void userMove() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter your move : ");
        userInput = s.nextInt();
        if (userInput < 1 || userInput > 9) {
            currentBoard();
            System.out.println("Your input is Invalid");
            userMove();
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game");
        generateBoard();
        chooseLetter();
        printBoard();
        currentBoard();
        userMove();
    }


}