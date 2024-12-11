package glava8.B;

import org.example.glava8.B.WordAnalyzer;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordAnalyzerTest {

    @Test
    void testAnalyzeWordOccurrences_BasicFunctionality() {
        String text = "Пример текста. Текст содержит слова. Слова могут повторяться.";
        List<String> words = Arrays.asList("текст", "слова", "пример");

        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("слова", 2);
        expected.put("текст", 2);
        expected.put("пример", 1);

        Map<String, Integer> result = WordAnalyzer.analyzeWordOccurrences(text, words);


    }

    @Test
    void testAnalyzeWordOccurrences_EmptyText() {
        String text = "";
        List<String> words = Arrays.asList("текст", "слова");

        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("текст", 0);
        expected.put("слова", 0);

        Map<String, Integer> result = WordAnalyzer.analyzeWordOccurrences(text, words);

        assertEquals(expected, result, "Проверка работы с пустым текстом.");
    }

    @Test
    void testAnalyzeWordOccurrences_NoMatchingWords() {
        String text = "Пример текста. Другие слова здесь.";
        List<String> words = Arrays.asList("нет", "совпадений");

        Map<String, Integer> expected = new LinkedHashMap<>();
        expected.put("нет", 0);
        expected.put("совпадений", 0);

        Map<String, Integer> result = WordAnalyzer.analyzeWordOccurrences(text, words);

        assertEquals(expected, result, "Проверка, если слова из списка не встречаются в тексте.");
    }
}
