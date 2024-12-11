package org.example.glava2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class zadA6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = new ArrayList<>();

        LocalDateTime startDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("Введите числа (введите 'exit' для завершения ввода):");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            numbers.add(input);
        }

        String firstIncreasingNumber = findFirstIncreasingNumber(numbers);

        if (firstIncreasingNumber != null) {
            System.out.println("Первое число с цифрами в строгом порядке возрастания: " + firstIncreasingNumber);
        } else {
            System.out.println("Нет чисел с цифрами в строгом порядке возрастания.");
        }
        System.out.println("Разработчик: Дансаранов");
        System.out.println("Дата и время получения задания: " + startDateTime.format(formatter));

        LocalDateTime endDateTime = LocalDateTime.now();
        System.out.println("Дата и время сдачи задания: " + endDateTime.format(formatter));
    }

    private static String findFirstIncreasingNumber(List<String> numbers) {
        for (String number : numbers) {
            if (isStrictlyIncreasing(number)) {
                return number;
            }
        }
        return null;
    }

    private static boolean isStrictlyIncreasing(String number) {
        for (int i = 0; i < number.length() - 1; i++) {
            if (number.charAt(i) >= number.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
