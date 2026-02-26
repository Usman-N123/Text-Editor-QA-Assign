package data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HashingIntegrityTests {

    @Test
    public void testFileEditChangesSessionHashButRetainsOriginalHash() {
        // 1. Mock the Database (Data Persistence Layer Mocking)
        MetadataRepository mockDatabase = mock(MetadataRepository.class);

        // 2. Setup initial file state
        String originalContent = "Original Document Text";
        String originalHash = HashUtil.generateSHA1(originalContent);
        FileMetadata metadata = new FileMetadata(originalHash, originalHash);

        // 3. Define the Mock Database behavior
        when(mockDatabase.getMetadata("file_001")).thenReturn(metadata);

        // 4. Simulate a user editing the file during a session
        String editedContent = "Original Document Text has been modified!";
        String newSessionHash = HashUtil.generateSHA1(editedContent);

        // Retrieve file metadata from the "Database" and update the session hash
        FileMetadata dbFile = mockDatabase.getMetadata("file_001");
        dbFile.setCurrentSessionHash(newSessionHash);

        // 5. Verify the assignment constraints
        assertNotEquals(dbFile.getOriginalHash(), dbFile.getCurrentSessionHash(),
                "Editing a file should change the current session hash.");

        assertEquals(originalHash, dbFile.getOriginalHash(),
                "The original import hash must be strictly retained in the database metadata.");
    }
}