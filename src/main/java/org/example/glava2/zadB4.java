package org.example.glava2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class zadB4 {
    public static void main(String[] args) {

        LocalDateTime startDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("Числа от 1 до 100, которые делятся на 3 без остатка:");

        // Цикл от 1 до 100
        for (int i = 1; i <= 100; i++) {
            // Проверка на делимость на 3
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println("Разработчик: Дансаранов");
        System.out.println("Дата и время получения задания: " + startDateTime.format(formatter));

        LocalDateTime endDateTime = LocalDateTime.now();
        System.out.println("Дата и время сдачи задания: " + endDateTime.format(formatter));
    }
}
