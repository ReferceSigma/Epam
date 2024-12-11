package org.example.glava2;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class zadA4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = new ArrayList<>();

        LocalDateTime startDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("Введите числа (введите 'exit' для завершения ввода):");

        // Чтение чисел
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            numbers.add(input);
        }

        String result = findNumberWithMinUniqueDigits(numbers);
        if (result != null) {
            System.out.println("Число с минимальным количеством различных цифр: " + result);
            System.out.println("Разработчик: Дансаранов");
            System.out.println("Дата и время получения задания: " + startDateTime.format(formatter));

            LocalDateTime endDateTime = LocalDateTime.now();
            System.out.println("Дата и время сдачи задания: " + endDateTime.format(formatter));
        } else {
            System.out.println("Список чисел пуст.");

        }
    }

    private static String findNumberWithMinUniqueDigits(List<String> numbers) {
        String minNumber = null;
        int minUniqueCount = Integer.MAX_VALUE;

        for (String number : numbers) {
            int uniqueDigitCount = countUniqueDigits(number);
            if (uniqueDigitCount < minUniqueCount) {
                minUniqueCount = uniqueDigitCount;
                minNumber = number;
            }
        }

        return minNumber;
    }

    private static int countUniqueDigits(String number) {
        HashSet<Character> uniqueDigits = new HashSet<>();
        for (char digit : number.toCharArray()) {
            uniqueDigits.add(digit);
        }
        return uniqueDigits.size();

    }

}
