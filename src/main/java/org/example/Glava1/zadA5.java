package org.example.Glava1;

import java.util.Scanner;

public class zadA5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; true; i++) {
            int x = input.nextInt();
            int y = input.nextInt();

            System.out.println("Sum = " + (x + y));
            System.out.println("Multiply = " + (x * y));
        }
    }
}
