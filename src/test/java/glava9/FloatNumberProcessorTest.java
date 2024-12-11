package glava9;

import org.example.glava9.CustomException;
import org.example.glava9.FloatNumberProcessor;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FloatNumberProcessorTest {

    @Test
    void testValidFileProcessing() throws IOException, CustomException {
        String content = "123.45 en\n67,89 ru\n-98765.4321 en";
        Path tempFile = Files.createTempFile("test_numbers", ".txt");
        Files.writeString(tempFile, content);

        List<Double> numbers = FloatNumberProcessor.readAndParseFile(tempFile.toString());

        assertEquals(3, numbers.size());
        assertEquals(123.45, numbers.get(0));
        assertEquals(67.89, numbers.get(1));
        assertEquals(-98765.4321, numbers.get(2));

        Files.deleteIfExists(tempFile);
    }

    @Test
    void testInvalidNumber() throws IOException, CustomException {
        String content = "invalid_number ru\n123.45 en";
        Path tempFile = Files.createTempFile("test_invalid_numbers", ".txt");
        Files.writeString(tempFile, content);

        List<Double> numbers = FloatNumberProcessor.readAndParseFile(tempFile.toString());

        assertEquals(1, numbers.size());
        assertEquals(123.45, numbers.get(0));

        Files.deleteIfExists(tempFile);
    }

    @Test
    void testMissingFile() {
        assertThrows(CustomException.class, () -> {
            FloatNumberProcessor.readAndParseFile("non_existing_file.txt");
        });
    }

    @Test
    void testInvalidLocale() throws IOException {
        String content = "123.45 xx";
        Path tempFile = Files.createTempFile("test_invalid_locale", ".txt");
        Files.writeString(tempFile, content);



        Files.deleteIfExists(tempFile);
    }
}
