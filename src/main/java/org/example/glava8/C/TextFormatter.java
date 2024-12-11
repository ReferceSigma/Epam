package org.example.glava8.C;

import java.util.*;

public class TextFormatter {
    public static void main(String[] args) {
        String text = "Пример текста, который необходимо выровнять по обоим краям.";
        int lineWidth = 30; // Ширина строки в символах

        List<String> justifiedText = justifyText(text, lineWidth);

        System.out.println("Форматированный текст:");
        justifiedText.forEach(System.out::println);
    }

    public static List<String> justifyText(String text, int lineWidth) {
        // Разделяем текст на слова
        String[] words = text.split("\\s+");
        List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int currentLength = 0;

        for (String word : words) {
            if (currentLength + word.length() + currentLine.size() > lineWidth) {
                // Форматируем текущую строку и добавляем ее в результат
                result.add(justifyLine(currentLine, lineWidth, false));
                currentLine.clear();
                currentLength = 0;
            }
            currentLine.add(word);
            currentLength += word.length();
        }

        // Обрабатываем последнюю строку (выравнивание по левому краю)
        if (!currentLine.isEmpty()) {
            result.add(justifyLine(currentLine, lineWidth, true));
        }

        return result;
    }

    private static String justifyLine(List<String> words, int lineWidth, boolean isLastLine) {
        if (words.size() == 1 || isLastLine) {
            // Если строка содержит одно слово или является последней, выравниваем по левому краю
            return String.join(" ", words) + " ".repeat(lineWidth - String.join(" ", words).length());
        }

        // Общая длина слов
        int totalWordLength = words.stream().mapToInt(String::length).sum();
        int totalSpaces = lineWidth - totalWordLength;

        // Распределяем пробелы
        int spacesBetweenWords = totalSpaces / (words.size() - 1);
        int extraSpaces = totalSpaces % (words.size() - 1);

        StringBuilder line = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            line.append(words.get(i));
            if (i < words.size() - 1) {
                line.append(" ".repeat(spacesBetweenWords + (i < extraSpaces ? 1 : 0)));
            }
        }

        return line.toString();
    }
}

