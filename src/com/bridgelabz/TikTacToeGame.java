package com.bridgelabz;
import java.util.Scanner;
public class TikTacToeGame {
    static char userSymbol, compSymbol;
    private static char[] board;
    static int userInput;
    static int turn = 1, flag = 0;


    private static void generateBoard() {
        char[] board = new char[10];
        for (int i = 1; i < 10; i++) {
            board[i] = ' ';
        }
    }

    public static void chooseLetter(){
        System.out.println("Choose letter 'X' or 'O' (in Caps) : ");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (str.contains("X")){
            char userSymbol='X';
            char compSymbol='O';
            System.out.println("User Symbol : "+userSymbol+" ; Comp Symbol : "+compSymbol);
        }
        else{
            char userSymbol='O';
            char compSymbol='X';
            System.out.println("User Symbol : "+userSymbol+" ; Comp Symbol : "+compSymbol);
        }
    }
    static void printBoard()
    {
        System.out.println("\n  "+board[1]+" | "+board[2]+" | "+board[3]+" ");
        System.out.println(" ----------- ");
        System.out.println("  "+board[4]+" | "+board[5]+" | "+board[6]+" ");
        System.out.println(" ----------- ");
        System.out.println("  "+board[7]+" | "+board[8]+" | "+board[9]+" \n");
    }
    private static void currentBoard() {
        for (int i=1;i<10;i++) {
            if (board[i] != 'X' && board[i] !='O') {
                board[i]=(char) (i+'0');
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
    private static void userMoveCheck() {
        if(board[userInput]=='X' || board[userInput]=='O') {
            currentBoard();
            System.out.println("Number which is selected is not free");
            userMove();
            userMoveCheck();
        } else {
            board[userInput]=userSymbol;
        }
    }
    private static void tossingCoin() {
        System.out.println(" Tossing Coin to decide first move \n Choose 1 : Head and 2 :Tail :");
        Scanner sc =new Scanner(System.in);
        int UserToss=sc.nextInt();

        if ( UserToss==1 || UserToss==2 ) {
            int flip = (int) Math.floor(Math.random() * 10) % 2;

            if (flip==1) {
                System.out.println("\nBy tossing Coin it shows HEAD\n");
            } else {
                System.out.println("\nBy tossing Coin it shows TAIL\n");
            }
            if (flip == UserToss) {
                System.out.println("User will start the game\n");
            } else {
                System.out.println("Computer will start the game\n");
                computerFirstTurn();
            }
        } else {
            System.out.println("\nInvalid input ");
            tossingCoin();
        }
    }
    public static void computerFirstTurn() {
        int CompInput = (int) Math.floor(Math.random() * 10) % 9;
        board[CompInput]=compSymbol;
        System.out.println("Computer choses '"+CompInput+"' now user turn");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game");
        generateBoard();
        chooseLetter();
        printBoard();
        currentBoard();
        userMove();
        userMoveCheck();
        while(flag==0) {
            if((turn+1)%2==0) {
                //for display the current board
                currentBoard();
                //for calling the user for number
                userMove();
                //for making the mark on user number
                userMoveCheck();
                turn++;
            }
        }
    }
}