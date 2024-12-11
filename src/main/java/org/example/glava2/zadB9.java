package org.example.glava2;


import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class zadB9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDateTime startDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.print("Введите число от 1 до 12: ");
        int monthNumber = scanner.nextInt();

        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Ошибка: Введите число в диапазоне от 1 до 12.");
        } else {
            String monthName = getMonthName(monthNumber);
            System.out.println("Месяц: " + monthName);
            System.out.println("Разработчик: Дансаранов");
            System.out.println("Дата и время получения задания: " + startDateTime.format(formatter));

            LocalDateTime endDateTime = LocalDateTime.now();
            System.out.println("Дата и время сдачи задания: " + endDateTime.format(formatter));
        }
    }

    // Метод для получения названия месяца по номеру
    public static String getMonthName(int monthNumber) {
        switch (monthNumber) {
            case 1: return "Январь";
            case 2: return "Февраль";
            case 3: return "Март";
            case 4: return "Апрель";
            case 5: return "Май";
            case 6: return "Июнь";
            case 7: return "Июль";
            case 8: return "Август";
            case 9: return "Сентябрь";
            case 10: return "Октябрь";
            case 11: return "Ноябрь";
            case 12: return "Декабрь";
            default: return "";
        }
    }
}
