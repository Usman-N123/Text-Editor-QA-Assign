package business;

public class ImportCommand implements Command {
    private String data;
    public ImportCommand(String data) { this.data = data; }

    @Override
    public boolean execute() { return true; } // Dummy logic for testing
}