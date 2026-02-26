package business;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommandTests {

    @Test
    public void testCommands_ValidExecution() {
        Command importCmd = new ImportCommand("dummy_path.txt");
        Command exportCmd = new ExportCommand();
        Command transCmd = new TransliterateCommand();

        assertTrue(importCmd.execute(), "ImportCommand should return true.");
        assertTrue(exportCmd.execute(), "ExportCommand should return true.");
        assertTrue(transCmd.execute(), "TransliterateCommand should return true.");
    }
}