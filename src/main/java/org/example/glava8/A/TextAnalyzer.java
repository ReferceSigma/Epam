package org.example.glava8.A;

import java.util.*;

public class TextAnalyzer {

    public static void main(String[] args) {
        String text = "Горошина осталась";
        int n = 3;

        List<Map.Entry<Character, Integer>> mostFrequentCharacters = findMostFrequentCharacters(text, n);

        System.out.println("Наиболее частые символы:");
        for (Map.Entry<Character, Integer> entry : mostFrequentCharacters) {
            System.out.println("Символ: '" + entry.getKey() + "', количество: " + entry.getValue());
        }
    }

    public static List<Map.Entry<Character, Integer>> findMostFrequentCharacters(String text, int n) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        return sortedEntries.subList(0, Math.min(n, sortedEntries.size()));
    }
}