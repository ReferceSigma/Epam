package glava8.C;

import org.example.glava8.C.TextFormatter;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TextFormatterTest {

    @Test
    void testJustifyText_BasicFunctionality() {
        String text = "Пример текста, который необходимо выровнять по обоим краям.";
        int lineWidth = 30;

        List<String> expected = Arrays.asList(
                "Пример    текста,    который",
                "необходимо   выровнять   по",
                "обоим краям.               "
        );

        List<String> result = TextFormatter.justifyText(text, lineWidth);


    }

    @Test
    void testJustifyText_SingleWordLine() {
        String text = "Слово";
        int lineWidth = 10;

        List<String> expected = Collections.singletonList("Слово     ");
        List<String> result = TextFormatter.justifyText(text, lineWidth);

        assertEquals(expected, result, "Проверка форматирования строки с одним словом.");
    }

    @Test
    void testJustifyText_LastLineLeftAligned() {
        String text = "Пример текста. Короткий.";
        int lineWidth = 20;

        List<String> expected = Arrays.asList(
                "Пример текста.     ",
                "Короткий.          "
        );

        List<String> result = TextFormatter.justifyText(text, lineWidth);


    }
}
