package org.example.glava2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class zadA3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> numbers = new ArrayList<>();

        LocalDateTime startDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("Введите числа (введите 'exit' для завершения ввода):");


        while (true) {
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            numbers.add(input);
        }


        int totalLength = 0;
        for (String number : numbers) {
            totalLength += number.length();
        }
        double averageLength = (double) totalLength / numbers.size();


        System.out.println("Числа с длиной меньше средней (" + averageLength + "):");
        for (String number : numbers) {
            if (number.length() < averageLength) {
                System.out.println(number + " (длина: " + number.length() + ")");
            }
        }


        System.out.println("Числа с длиной больше средней (" + averageLength + "):");
        for (String number : numbers) {
            if (number.length() > averageLength) {
                System.out.println(number + " (длина: " + number.length() + ")");
            }
        }
        System.out.println("Разработчик: Дансаранов");
        System.out.println("Дата и время получения задания: " + startDateTime.format(formatter));

        LocalDateTime endDateTime = LocalDateTime.now();
        System.out.println("Дата и время сдачи задания: " + endDateTime.format(formatter));
    }
}