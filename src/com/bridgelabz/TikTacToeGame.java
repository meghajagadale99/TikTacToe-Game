package com.bridgelabz;

import java.util.Scanner;

public class TikTacToeGame {
    static char PLAYER, COMPUTER;
    private static char[] board = new char[10];
    static int User, computerNo;
    static int turn =1, flag =0;

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game");
        createBoard();
        choosingXorO();
        showBoard();
        tossCoin();
        while (flag==0){
            if ((turn+1)%2==0){
                currentBoard();
                userCall();
                userMove();
                turn++;
            }
        }

    }

    private static void createBoard() {
        board = new char[10];
        for (int i = 1; i < 10; i++) {
            board[i] = ' ';
        }
    }

    private static void choosingXorO() {
        System.out.println("Choose 1 for 'X' or Choose 2 for 'O' as your mark");
        int option = Utility.getUserInteger();
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
        System.out.println("\n PLAYER: '"+PLAYER+"' and COMPUTER: '"+COMPUTER+"'");
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
    private static void userCall() {
        System.out.println("\nEnter a number from board to make the mark:\n");
        User = Utility.getUserInteger();
        if (User < 1 || User > 9) {
            currentBoard();
            System.out.println("Your input is Invalid");
            userCall();
        }
    }
    private static void userMove() {
        if(board[User]=='X' || board[User]=='O') {
            currentBoard();
            System.out.println("Number which is selected is not free");
            userCall();
            userMove();
        } else {
            board[User]=PLAYER;
        }
    }
    private static void tossCoin() {
        System.out.println("\nMaking a toss to check who plays first\nChoose 1 for Head or 2 for Tail");
        int option = Utility.getUserInteger();;
        if ( option==1 || option==2 ) {
            int flip = Utility.getRandomInt(2)+1;
            if (flip==1) {
                System.out.println("\nBy tossing Coin it shows HEAD\n");
            } else {
                System.out.println("\nBy tossing Coin it shows TAIL\n");
            }
            if (flip == option) {
                System.out.println("User will start the game\n");
            } else {
                System.out.println("Computer will start the game\n");
                computerFirstTurn();
            }
        } else {
            System.out.println("\nInvalid input ");
            tossCoin();
        }
    }

    public static void computerFirstTurn() {
        computerNo = Utility.getRandomInt(9)+1;
        board[computerNo]=PLAYER;
        System.out.println("Computer chooses '"+computerNo+"' now user turn");
    }
}
