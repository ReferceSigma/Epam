package org.example.glava2;




import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class zadB8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LocalDateTime startDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        System.out.print("Введите число: ");
        String number = scanner.nextLine();

        System.out.print("Введите основание исходной системы счисления (от 2 до 16): ");
        int sourceBase = scanner.nextInt();

        System.out.print("Введите основание целевой системы счисления (от 2 до 16): ");
        int targetBase = scanner.nextInt();

        if ((sourceBase < 2 || sourceBase > 16) || (targetBase < 2 || targetBase > 16)) {
            System.out.println("Основание должно быть в диапазоне от 2 до 16.");
            return;
        }

        int decimalValue = convertToDecimal(number, sourceBase);

        String result = convertFromDecimal(decimalValue, targetBase);
        System.out.println("Число " + number + " в системе счисления с основанием " + targetBase + " равно: " + result);
        System.out.println("Разработчик: Дансаранов");
        System.out.println("Дата и время получения задания: " + startDateTime.format(formatter));

        LocalDateTime endDateTime = LocalDateTime.now();
        System.out.println("Дата и время сдачи задания: " + endDateTime.format(formatter));
    }

    public static int convertToDecimal(String number, int base) {
        int decimalValue = 0;
        int length = number.length();

        for (int i = 0; i < length; i++) {
            char digit = number.charAt(length - 1 - i);
            int value = getValueForCharacter(digit);
            decimalValue += value * Math.pow(base, i);
        }

        return decimalValue;
    }

    public static String convertFromDecimal(int decimalNumber, int base) {
        if (decimalNumber == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        boolean isNegative = decimalNumber < 0;

        decimalNumber = Math.abs(decimalNumber);

        while (decimalNumber > 0) {
            int remainder = decimalNumber % base;
            result.append(getCharacterForValue(remainder));
            decimalNumber /= base;
        }

        if (isNegative) {
            result.append('-');
        }

        return result.reverse().toString();
    }

    public static int getValueForCharacter(char character) {
        if (character >= '0' && character <= '9') {
            return character - '0';
        } else if (character >= 'A' && character <= 'Z') {
            return character - 'A' + 10;
        } else {
            throw new IllegalArgumentException("Неверный символ: " + character);
        }
    }

    public static char getCharacterForValue(int value) {
        if (value < 10) {
            return (char) ('0' + value);
        } else {
            return (char) ('A' + (value - 10));
        }
    }
}
