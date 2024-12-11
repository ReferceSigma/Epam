package org.example.glava2;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class zadB1 {
    public static void main(String[] args) {

        LocalDateTime startDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.printf("%-10s", " ");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%-10d", i);
        }
        System.out.println();

        for (int i = 1; i <= 10; i++) {

            System.out.printf("%-10d", i);
            for (int j = 1; j <= 10; j++) {
                
                System.out.printf("%-10d", i * j);
            }
            System.out.println(); // Переход на новую строку после каждого множителя
        }
        System.out.println("Разработчик: Дансаранов");
        System.out.println("Дата и время получения задания: " + startDateTime.format(formatter));

        LocalDateTime endDateTime = LocalDateTime.now();
        System.out.println("Дата и время сдачи задания: " + endDateTime.format(formatter));
    }
}