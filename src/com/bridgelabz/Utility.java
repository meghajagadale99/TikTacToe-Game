package com.bridgelabz;

import java.util.Random;
import java.util.Scanner;

public class Utility {
    private static final Scanner scan = new Scanner(System.in);


    public static int getUserInteger() {
        return scan.nextInt();
    }

    private static final Random random = new Random();

    public static int getRandomInt(int number) {
        return random.nextInt(number);
    }

}
