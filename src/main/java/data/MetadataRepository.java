package data;

public interface MetadataRepository {
    FileMetadata getMetadata(String fileId);
    void saveMetadata(String fileId, FileMetadata metadata);
}