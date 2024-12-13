package org.example.Glava1;

public class zadA4 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Ошибка: Укажите пароль в качестве аргумента.");
            return;
        }

        String inputPassword = args[0];
        String correctPassword = "password";

        if (inputPassword.equals(correctPassword)) {
            System.out.println("Пароль верный");
        } else {
            System.out.println("Пароль неверный");
        }
    }
}
