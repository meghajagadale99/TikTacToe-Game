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
        outerloop:
        while (flag == 0) {
            if ((turn + 1) % 2 == 0) {
                createBoard();
                userPlay();
                currentBoard();
                Move();
                flag=checkWin();
                if (flag==1) {
                    System.out.println("Excellent! You are the winner");
                    break outerloop;
                }
                //to check whether game is tie or not
                flag=checkTie();
                if (flag==1) {
                    System.out.println("Nice Play! It's Tie");;
                    break outerloop;
                }
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
    public static int checkWin() {
        for (int i=1;i<9;i++) {
            int win[]= winArray(i);
            if (board[win[0]]==board[win[1]]&&board[win[1]]==board[win[2]]) {
                flag=1;
            }
        }
        return flag;
    }

    private static int[] winArray(int number) {
        if (number==1) {
            int arrayWin[]= {1,2,3};
            return arrayWin;
        } else if (number==2) {
            int arrayWin[]= {4,5,6};
            return arrayWin;
        } else if (number==3) {
            int arrayWin[]= {7,8,9};
            return arrayWin;
        } else if (number==4) {
            int arrayWin[]= {1,4,7};
            return arrayWin;
        } else if (number==5) {
            int arrayWin[]= {2,5,8};
            return arrayWin;
        } else if (number==6) {
            int arrayWin[]= {3,6,9};
            return arrayWin;
        } else if (number==7) {
            int arrayWin[]= {1,5,9};
            return arrayWin;
        } else {
            int arrayWin[]= {3,5,7};
            return arrayWin;
        }
    }
    public static int checkTie() {
        for (int i=1; i<10; i++) {
            if (board[i]=='X' || board[i]=='O') {
                if (i==9) {
                    flag=1;
                }
            }
        }
        return flag;
    }

}