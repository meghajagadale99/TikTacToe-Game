package com.bridgelabz;

import java.util.Scanner;

public class TikTacToeGame {
    static Scanner sc = new Scanner(System.in);
    static char PLAYER, COMPUTER;
    static char[] board = new char[10];

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game");
        createBoard();
        choosingXorO();
        currentBoard();
        userPlay();
        Move();
    }

    private static char[] createBoard() {
        for (int index = 1; index < board.length; index++) {
            board[index] = ' ';
        }
        return board;
    }

    private static void choosingXorO() {
        Scanner s = new Scanner(System.in);
        System.out.println("Choose 1 for 'X' or Choose 2 for 'O' as your mark");
        int option = s.nextInt();
        switch (option) {
            case 1:
                PLAYER = 'X';
                COMPUTER = 'O';
                break;
            case 2:
                PLAYER = 'O';
                COMPUTER = 'X';
                break;
            default:
                System.out.println("Your input is invalid");
                choosingXorO();
        }
    }

    private static void showBoard() {
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
        showBoard();
    }
    static void userPlay() {
        System.out.println("Enter board index(1-9) to set your game move ");
        int userMove = sc.nextInt();
        switch (userMove) {
            case 1:
               if (board[1] == ' ') {
                   board[1] = PLAYER;
                }
               break;
           case 2:
               if (board[2] == ' ') {
                   board[2] = PLAYER;
                }
                break;
           case 3:
               if (board[3] == ' ') {
                    board[3] = PLAYER;
                }
              break;
            case 4:
                if (board[4] == ' ') {
                    board[4] = PLAYER;
                }
                break;
            case 5:
                if (board[5] == ' ') {
                    board[5] = PLAYER;
                }
                break;
            case 6:
                if (board[6] == ' ') {
                    board[6] = PLAYER;
                }
                break;
            case 7:
                if (board[7] == ' ') {
                    board[7] = PLAYER;
                }
                break;
            case 8:
                if (board[8] == ' ') {
                    board[8] = PLAYER;
                }
                break;
            case 9:
                if (board[9] == ' ') {
                    board[9] = PLAYER;
                }
                break;
            default:
                System.out.println("Invalid Move");
        }
        showBoard();
    }

    static void Move() {
        boolean played = false;
        while (!played) {
            int playMove = (int) (Math.random() * 10) % 9 + 1;
            if (playMove > 0 && playMove < 10) {
                if (board[playMove] == ' ') {
                    board[playMove] = COMPUTER;
                    played = true;
                }
            }
        }
        showBoard();
    }
}