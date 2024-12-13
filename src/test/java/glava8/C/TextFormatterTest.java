package glava8.C;

import org.example.glava8.C.TextFormatter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class TextFormatterTest {

    @Test
    void testJustifyText() {
        String text = "Пример текста, который необходимо выровнять по обоим краям.";
        int lineWidth = 30;

        List<String> justifiedText = TextFormatter.justifyText(text, lineWidth);

        // Проверяем количество строк в отформатированном тексте
        assertEquals(3, justifiedText.size());

        // Проверяем, что строки имеют необходимую ширину
        for (String line : justifiedText) {
            assertEquals(lineWidth, line.length());
        }

        // Проверяем содержимое строк (примерно)
        assertTrue(justifiedText.get(0).contains("Пример"));
        assertTrue(justifiedText.get(0).contains("текста,"));
        assertTrue(justifiedText.get(1).contains("необходимо"));
    }

    @Test
    void testJustifyTextWithShortText() {
        String text = "Короткий текст";
        int lineWidth = 30;

        List<String> justifiedText = TextFormatter.justifyText(text, lineWidth);

        // Проверяем, что текст выровнен по левому краю
        assertEquals(1, justifiedText.size());
        assertEquals(lineWidth, justifiedText.get(0).length());
        assertTrue(justifiedText.get(0).startsWith("Короткий текст"));
    }
}
