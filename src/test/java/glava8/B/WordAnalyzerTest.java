package glava8.B;

import org.example.glava8.B.WordAnalyzer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class WordAnalyzerTest {

    @Test
    void testAnalyzeWordOccurrences() {
        String text = "Пример текста. Текст содержит слова. Слова могут повторяться.";
        List<String> words = Arrays.asList("текст", "слова", "пример");

        Map<String, Integer> result = WordAnalyzer.analyzeWordOccurrences(text, words);

        // Проверяем общее количество уникальных слов
        assertEquals(3, result.size());

        // Проверяем конкретные значения
        assertEquals(1, result.get("текст"));
        assertEquals(2, result.get("слова"));
        assertEquals(1, result.get("пример"));
    }

    @Test
    void testAnalyzeWordOccurrencesWithEmptyText() {
        String text = "";
        List<String> words = Arrays.asList("текст", "слова");

        Map<String, Integer> result = WordAnalyzer.analyzeWordOccurrences(text, words);

        // Проверяем, что все слова имеют частоту 0
        assertEquals(0, result.get("текст"));
        assertEquals(0, result.get("слова"));
    }
}
