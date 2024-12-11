package org.example.glava2;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class zadB3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDateTime startDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.print("Введите n: ");
        double n = scanner.nextDouble();
        System.out.print("Введите m: ");
        double m = scanner.nextDouble();
        System.out.print("Введите значение k: ");
        double k = scanner.nextDouble();

        System.out.println("Проверка принадлежности k = " + k + " к интервалам:");

        if (k > n && k <= m) {
            System.out.println("k принадлежит интервалу (n, m]");
        } else {
            System.out.println("k не принадлежит интервалу (n, m]");
        }

        if (k >= n && k < m) {
            System.out.println("k принадлежит интервалу [n, m)");
        } else {
            System.out.println("k не принадлежит интервалу [n, m)");
        }

        if (k > n && k < m) {
            System.out.println("k принадлежит интервалу (n, m)");
        } else {
            System.out.println("k не принадлежит интервалу (n, m)");
        }

        if (k >= n && k <= m) {
            System.out.println("k принадлежит интервалу [n, m]");
        } else {
            System.out.println("k не принадлежит интервалу [n, m]");
        }
        System.out.println("Разработчик: Дансаранов");
        System.out.println("Дата и время получения задания: " + startDateTime.format(formatter));

        LocalDateTime endDateTime = LocalDateTime.now();
        System.out.println("Дата и время сдачи задания: " + endDateTime.format(formatter));
        scanner.close();
    }
}
