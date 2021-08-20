package com.bridgelabz;
import java.util.Scanner;
public class TikTacToeGame {
    static char[] board = new char[10];

    private static void generateBoard() {

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

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game");
        generateBoard();
        chooseLetter();
    }

}