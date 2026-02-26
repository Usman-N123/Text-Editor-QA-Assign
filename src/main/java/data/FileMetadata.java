package data;

public class FileMetadata {
    private String originalHash;
    private String currentSessionHash;

    public FileMetadata(String originalHash, String currentSessionHash) {
        this.originalHash = originalHash;
        this.currentSessionHash = currentSessionHash;
    }

    public String getOriginalHash() { return originalHash; }
    public String getCurrentSessionHash() { return currentSessionHash; }

    public void setCurrentSessionHash(String currentSessionHash) {
        this.currentSessionHash = currentSessionHash;
    }
}