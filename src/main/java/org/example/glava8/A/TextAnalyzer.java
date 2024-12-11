package org.example.glava8.A;

import java.util.*;

public class TextAnalyzer {

    public static void main(String[] args) {
        String text = "Горошина Осталась";
        int n = 3;

        findMostFrequentCharacters(text, n);
    }

    public static void findMostFrequentCharacters(String text, int n) {

        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }


        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        System.out.println("Наиболее частые символы:");
        for (int i = 0; i < n && i < sortedEntries.size(); i++) {
            Map.Entry<Character, Integer> entry = sortedEntries.get(i);
            System.out.println("Символ: '" + entry.getKey() + "', количество: " + entry.getValue());
        }
    }
}
