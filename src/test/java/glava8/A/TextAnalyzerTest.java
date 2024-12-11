package glava8.A;

import org.example.glava8.A.TextAnalyzer;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class TextAnalyzerTest {

    @Test
    void testFindMostFrequentCharacters() {
        String text = "Горошина Осталась";
        int n = 3;

        // Redirect system output to capture printed lines
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            TextAnalyzer.findMostFrequentCharacters(text, n);

            String output = outputStream.toString().trim(); // Trim to handle extra spaces or newlines

            // Verify the output contains the expected most frequent characters
            assertTrue(output.contains("Символ: 'а', количество: 3"), "Output should contain the character 'а' with frequency 3.");
            assertTrue(output.contains("Символ: 'о', количество: 2"), "Output should contain the character 'о' with frequency 2.");


            // Ensure the output contains only 'n' entries
            Pattern pattern = Pattern.compile("Символ: '.', количество: ");
            long count = pattern.matcher(output).results().count();
            assertEquals(n, count, "Output should contain exactly " + n + " entries.");

        } finally {
            // Restore the original system output
            System.setOut(originalOut);
        }
    }

    @Test
    void testFindMostFrequentCharactersWithEmptyText() {
        String text = "";
        int n = 3;

        // Redirect system output to capture printed lines
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            TextAnalyzer.findMostFrequentCharacters(text, n);
            String output = outputStream.toString().trim(); // Trim to handle extra spaces or newlines

            // Verify the output is empty
            assertTrue(output.startsWith("Наиболее частые символы:"), "Output should start with the header.");
            assertEquals("Наиболее частые символы:", output, "Output should only contain the header for empty input.");
        } finally {
            // Restore the original system output
            System.setOut(originalOut);
        }
    }
}
