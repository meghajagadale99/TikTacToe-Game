package com.bridgelabz;

import java.util.Scanner;

public class TikTacToeGame {
    static Scanner sc = new Scanner(System.in);
    static char PLAYER, COMPUTER;
    static char[] board = new char[10];
    static int userNumber ,  computerNumber;
    static int turn = 1, flag = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game");
        createBoard();
        showBoard();
        choosingXorO();
        toss();
        while (flag == 0) {
            if ((turn + 1) % 2 == 0) {
                userPlay();
                currentBoard();
                Move();
                turn++;
            }
        }
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
        userPlay();
    }

    static void Move() {
        boolean played = false;
        while (!played) {
            int playMove = (int) (Math.random() * 10) % 9 + 1;
            if (playMove > 0 && playMove < 10) {
                if (board[playMove] == ' ') {
                    board[playMove] = COMPUTER;
                    played = true;
                    Move();
                    userPlay();
                }
            }
        }
        showBoard();
    }

    static void toss() {
        int turn = (int) Math.floor(Math.random() * 10) % 2;
        System.out.println("To start the game enter 1 to play the toss: ");
        Scanner sc = new Scanner(System.in);
        int playerToss = sc.nextInt();
        if (playerToss == turn) {
            System.out.println("Player won the toss, enter your first Move");
            userPlay();
            Move();

        } else {
            System.out.println("Computer won the toss, enter your first move");
            toss();

        }

    }
    public static void computerFirstTurn() {
        computerNumber = Utility.getRandomInt(9)+1;
        board[computerNumber]=COMPUTER;
        System.out.println("Computer chooses '"+computerNumber+"' now user turn");
    }
}