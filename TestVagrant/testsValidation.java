import java.util.Arrays;

public class RecentlyPlayedStoreTest {
    public static void main(String[] args) {
        testRecentlyPlayedStore();
    }

    private static void testRecentlyPlayedStore() {
        RecentlyPlayedStore store = new RecentlyPlayedStore(3);

        // Test adding songs for a user
        store.addPlayedSong("S1", "User1");
        store.addPlayedSong("S2", "User1");
        store.addPlayedSong("S3", "User1");
        assert Arrays.equals(store.getRecentlyPlayedSongs("User1"), new String[] { "S3", "S2", "S1" });

        // Test adding songs for another user
        store.addPlayedSong("S4", "User2");
        assert Arrays.equals(store.getRecentlyPlayedSongs("User2"), new String[] { "S4" });

        // Test adding songs for the first user again
        store.addPlayedSong("S2", "User1");
        assert Arrays.equals(store.getRecentlyPlayedSongs("User1"), new String[] { "S2", "S3", "S1" });

        // Test adding songs for a new user and reaching capacity
        store.addPlayedSong("S1", "User3");
        store.addPlayedSong("S5", "User1");
        assert Arrays.equals(store.getRecentlyPlayedSongs("User1"), new String[] { "S5", "S2", "S3" });
        assert Arrays.equals(store.getRecentlyPlayedSongs("User2"), new String[] { "S4" });
        assert Arrays.equals(store.getRecentlyPlayedSongs("User3"), new String[] { "S1" });
    }
}
