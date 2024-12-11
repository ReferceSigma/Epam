package org.example.glava2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class zadA8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDateTime startDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.println("Введите числа, разделенные пробелами:");
        String[] inputNumbers = scanner.nextLine().split(" ");

        List<String> palindromes = findPalindromes(inputNumbers);

        if (palindromes.size() >= 2) {
            System.out.println("Второе число-палиндром: " + palindromes.get(1));
        } else if (palindromes.size() == 1) {
            System.out.println("Есть только одно число-палиндром: " + palindromes.get(0));
        } else {
            System.out.println("Нет палиндромов среди введенных чисел.");
        }
        System.out.println("Разработчик: Дансаранов");
        System.out.println("Дата и время получения задания: " + startDateTime.format(formatter));

        LocalDateTime endDateTime = LocalDateTime.now();
        System.out.println("Дата и время сдачи задания: " + endDateTime.format(formatter));
        scanner.close();
    }

    private static List<String> findPalindromes(String[] numbers) {
        List<String> palindromes = new ArrayList<>();

        for (String number : numbers) {
            if (isPalindrome(number)) {
                palindromes.add(number);
            }
        }

        return palindromes;
    }

    private static boolean isPalindrome(String number) {
        int left = 0;
        int right = number.length() - 1;

        while (left < right) {
            if (number.charAt(left) != number.charAt(right)) {
                return false; // Если символы не совпадают, не палиндром
            }
            left++;
            right--;
        }

        return true; // Если все символы совпали, это палиндром
    }
}
