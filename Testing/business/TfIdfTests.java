package business;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TfIdfTests {

    @Test
    public void testTfIdf_PositivePath() {
        TfIdfCalculator calc = new TfIdfCalculator();
        double expectedScore = 0.15;
        double actualScore = calc.calculate("known document test", "test");

        // Assert the score matches manual calculation ±0.01
        assertEquals(expectedScore, actualScore, 0.01, "TF-IDF score should match within 0.01 tolerance.");
    }

    @Test
    public void testTfIdf_NegativePath() {
        TfIdfCalculator calc = new TfIdfCalculator();

        // Feed empty document
        assertEquals(0.0, calc.calculate("", "test"), "Empty document should gracefully return 0.0");

        // Feed special characters
        assertEquals(0.0, calc.calculate("!@#$%^", "test"), "Special characters should gracefully return 0.0");
    }
}