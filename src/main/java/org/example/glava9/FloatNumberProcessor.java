package org.example.glava9;



import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class FloatNumberProcessor {

    public static void main(String[] args) {
        String filePath = "src/main/resources/numbers.txt"; // Путь к файлу

        try {
            List<Double> numbers = readAndParseFile(filePath);
            double sum = numbers.stream().mapToDouble(Double::doubleValue).sum();
            double average = numbers.isEmpty() ? 0 : sum / numbers.size();

            System.out.println("Сумма чисел: " + sum);
            System.out.println("Среднее значение: " + average);
        } catch (CustomException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e.getMessage());
        }
    }


    public static List<Double> readAndParseFile(String filePath) throws IOException, CustomException {
        List<Double> numbers = new ArrayList<>();

        // Проверка существования файла
        if (!Files.exists(Paths.get(filePath))) {
            throw new CustomException("Файл не найден: " + filePath);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    // Проверка на корректность числа
                    Locale locale = extractLocale(line);
                    String numberString = extractNumber(line);

                    double number = Double.parseDouble(numberString.replace(",", "."));
                    validateNumber(number);

                    numbers.add(number);
                } catch (NumberFormatException e) {
                    System.out.println("Некорректное число: " + line);
                } catch (CustomException e) {
                    System.out.println("Ошибка обработки: " + e.getMessage());
                }
            }
        }
        return numbers;
    }



    private static Locale extractLocale(String line) throws CustomException {
        if (line.contains("ru")) {
            return new Locale("ru");
        } else if (line.contains("en")) {
            return Locale.ENGLISH;
        } else {
            throw new CustomException("Локаль не указана или некорректна в строке: " + line);
        }
    }


    private static String extractNumber(String line) throws CustomException {
        String[] parts = line.split("\\s+");
        if (parts.length < 2) {
            throw new CustomException("Некорректная строка: " + line);
        }
        return parts[0];
    }


    private static void validateNumber(double number) throws CustomException {
        if (number < -Double.MAX_VALUE || number > Double.MAX_VALUE) {
            throw new CustomException("Число выходит за допустимые пределы: " + number);
        }
    }
}
