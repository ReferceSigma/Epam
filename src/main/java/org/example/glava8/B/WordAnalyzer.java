package org.example.glava8.B;

import java.util.*;
import java.util.stream.Collectors;

public class WordAnalyzer {
    public static void main(String[] args) {
        String text = "Пример текста. Текст содержит слова. Слова могут повторяться.";
        List<String> words = Arrays.asList("текст", "слова", "пример");

        Map<String, Integer> result = analyzeWordOccurrences(text, words);

        System.out.println("Сортировка слов по убыванию общего количества вхождений:");
        result.forEach((word, count) -> System.out.println(word + ": " + count));
    }

    public static Map<String, Integer> analyzeWordOccurrences(String text, List<String> words) {
        // Разделяем текст на предложения
        String[] sentences = text.split("\\.");

        // Словарь для хранения общего количества вхождений каждого слова
        Map<String, Integer> totalOccurrences = new HashMap<>();

        for (String word : words) {
            totalOccurrences.put(word, 0); // Инициализация подсчета для каждого слова
        }

        for (String sentence : sentences) {
            String[] tokens = sentence.toLowerCase().split("\\s+");
            Map<String, Integer> sentenceOccurrences = new HashMap<>();

            for (String token : tokens) {
                token = token.replaceAll("[^а-яА-ЯёЁa-zA-Z]", ""); // Убираем пунктуацию
                sentenceOccurrences.put(token, sentenceOccurrences.getOrDefault(token, 0) + 1);
            }

            for (String word : words) {
                totalOccurrences.put(word, totalOccurrences.get(word) + sentenceOccurrences.getOrDefault(word, 0));
            }
        }

        // Сортируем слова по убыванию их общего количества вхождений
        return totalOccurrences.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
