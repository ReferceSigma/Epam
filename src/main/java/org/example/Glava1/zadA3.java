package org.example.Glava1;

public class zadA3 {

    public static void main(String[] args) {

        int a = 0;
        int b = 2500;
        for (int i = 0; i < 10; i++) {
            int random_number1 = a + (int) (Math.random() * b);
            System.out.print(" " + random_number1);}
    }
}