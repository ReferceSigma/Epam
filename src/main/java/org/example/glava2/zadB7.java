package org.example.glava2;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class zadB7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDateTime startDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.print("Введите десятичное число: ");
        int decimalNumber = scanner.nextInt();

        System.out.print("Введите основание системы счисления (от 2 до 16): ");
        int base = scanner.nextInt();

        if (base < 2 || base > 16) {
            System.out.println("Основание должно быть в диапазоне от 2 до 16.");
            return;
        }

        String result = convertDecimalToBase(decimalNumber, base);
        System.out.println("Число " + decimalNumber + " в системе счисления с основанием " + base + " равно: " + result);
        System.out.println("Разработчик: Дансаранов");
        System.out.println("Дата и время получения задания: " + startDateTime.format(formatter));

        LocalDateTime endDateTime = LocalDateTime.now();
        System.out.println("Дата и время сдачи задания: " + endDateTime.format(formatter));
    }

    public static String convertDecimalToBase(int decimalNumber, int base) {
        if (decimalNumber == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        boolean isNegative = decimalNumber < 0;

        decimalNumber = Math.abs(decimalNumber);

        while (decimalNumber > 0) {
            int remainder = decimalNumber % base;
            result.append(getCharacterForValue(remainder)); // Получаем символ для остатка
            decimalNumber /= base; // Делим число на основание
        }

        // Если число было отрицательным, добавляем минус
        if (isNegative) {
            result.append('-');
        }

        return result.reverse().toString();
    }

    public static char getCharacterForValue(int value) {
        if (value < 10) {
            return (char) ('0' + value); // Для значений 0-9
        } else {
            return (char) ('A' + (value - 10)); // Для значений 10-35
        }
    }
}
