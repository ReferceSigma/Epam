package glava8.A;

import org.example.glava8.A.TextAnalyzer;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextAnalyzerTest {

    @Test
    void testFindMostFrequentCharacters() {
        String text = "Горошина осталасьо";
        int n = 4;

        List<Map.Entry<Character, Integer>> result = TextAnalyzer.findMostFrequentCharacters(text, n);

        // Исправлены ожидания:
        assertEquals(4, result.size());
        assertEquals('о', result.get(0).getKey()); // 'о' - наиболее частый символ
        assertEquals(4, result.get(0).getValue());

        assertEquals('а', result.get(1).getKey()); // 'а' - следующий по частоте символ
        assertEquals(3, result.get(1).getValue());



        assertEquals('с', result.get(2).getKey()); // 'с' - ещё один символ
        assertEquals(2, result.get(2).getValue());
    }

    @Test
    void testEmptyString() {
        String text = "";
        int n = 3;

        List<Map.Entry<Character, Integer>> result = TextAnalyzer.findMostFrequentCharacters(text, n);

        assertEquals(0, result.size());
    }

    @Test
    void testLessThanNCharacters() {
        String text = "аб";
        int n = 5;

        List<Map.Entry<Character, Integer>> result = TextAnalyzer.findMostFrequentCharacters(text, n);

        assertEquals(2, result.size());
    }
}
