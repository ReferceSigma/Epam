
package org.example.glava2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class zadB5 {
    public static void main(String[] args) {

        LocalDateTime startDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        int number = 129;

        // Преобразуем число в двоичную строку
        String binaryString = Integer.toBinaryString(number);
        System.out.println("Двоичная запись числа " + number + ": " + binaryString);

        // Подсчет значащих нулей
        int significantZerosCount = countSignificantZeros(binaryString);
        System.out.println("Количество значащих нулей: " + significantZerosCount);

        System.out.println("Разработчик: Дансаранов");
        System.out.println("Дата и время получения задания: " + startDateTime.format(formatter));

        LocalDateTime endDateTime = LocalDateTime.now();
        System.out.println("Дата и время сдачи задания: " + endDateTime.format(formatter));
    }

    // Метод для подсчета значащих нулей
    public static int countSignificantZeros(String binaryString) {
        int count = 0;
        boolean foundOne = false;

        for (char bit : binaryString.toCharArray()) {
            if (bit == '1') {
                if (foundOne) {
                    break;
                }
                foundOne = true;
            } else if (foundOne) {
                count++;
            }
        }

        return count;
    }
}