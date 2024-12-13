package org.example.Glava1;

public class zadA5 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Ошибка: Введите целые числа в качестве аргументов.");
            return;
        }

        int sum = 0;
        int product = 1;

        try {
            for (String arg : args) {
                int number = Integer.parseInt(arg);
                sum += number;
                product *= number;
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Все аргументы должны быть целыми числами.");
            return;
        }

        System.out.println("Сумма чисел = " + sum);
        System.out.println("Произведение чисел = " + product);
    }
}
