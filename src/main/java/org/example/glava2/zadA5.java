package org.example.glava2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class zadA5 {
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

        int countEvenOnly = countEvenOnlyNumbers(numbers);
        int countEqualEvenOdd = countEqualEvenOddNumbers(numbers);

        System.out.println("Количество чисел, содержащих только четные цифры: " + countEvenOnly);
        System.out.println("Количество чисел с равным числом четных и нечетных цифр: " + countEqualEvenOdd);
        System.out.println("Разработчик: Дансаранов");
        System.out.println("Дата и время получения задания: " + startDateTime.format(formatter));

        LocalDateTime endDateTime = LocalDateTime.now();
        System.out.println("Дата и время сдачи задания: " + endDateTime.format(formatter));
    }

    private static int countEvenOnlyNumbers(List<String> numbers) {
        int count = 0;
        for (String number : numbers) {
            if (isEvenOnly(number)) {
                count++;
            }
        }
        return count;
    }

    private static int countEqualEvenOddNumbers(List<String> numbers) {
        int count = 0;
        for (String number : numbers) {
            if (hasEqualEvenOddDigits(number)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isEvenOnly(String number) {
        for (char digit : number.toCharArray()) {
            if ((digit - '0') % 2 != 0) { // Проверка на четность цифры
                return false;
            }
        }
        return true;
    }

    private static boolean hasEqualEvenOddDigits(String number) {
        int evenCount = 0;
        int oddCount = 0;

        for (char digit : number.toCharArray()) {
            if ((digit - '0') % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return evenCount == oddCount;
    }
}
