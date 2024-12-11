package org.example.glava2;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class zadB6 {
    public static void main(String[] args) {

        LocalDateTime startDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        int decimalNumber = 81;
        int base = findBase(decimalNumber);

        if (base != -1) {
            System.out.println("Основание системы счисления, в которой число 81 записывается как 100: " + base);
        } else {
            System.out.println("Не найдено подходящее основание.");
        }
        System.out.println("Разработчик: Дансаранов");
        System.out.println("Дата и время получения задания: " + startDateTime.format(formatter));

        LocalDateTime endDateTime = LocalDateTime.now();
        System.out.println("Дата и время сдачи задания: " + endDateTime.format(formatter));
    }

    // Метод для нахождения основания
    public static int findBase(int decimalNumber) {
        int base = (int) Math.sqrt(decimalNumber);

        // Проверяем, действительно ли основание корректно
        if (base * base == decimalNumber) {
            return base;
        } else {
            return -1;
        }
    }
}
