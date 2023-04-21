import java.util.HashMap;
import java.util.Map;

class SongNode {
    String song;
    String user;
    SongNode prev;
    SongNode next;

    public SongNode(String song, String user) {
        this.song = song;
        this.user = user;
    }
}

public class RecentlyPlayedStore {
    private int capacity;
    private Map<String, SongNode> userLists;
    private SongNode head;
    private SongNode tail;
    private int size;

    public RecentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        userLists = new HashMap<>();
    }

    public void addPlayedSong(String song, String user) {
        SongNode node = userLists.get(user);

        if (node == null) {
            node = new SongNode(song, user);
            userLists.put(user, node);

            if (size < capacity) {
                if (head == null) {
                    head = node;
                    tail = node;
                } else {
                    node.next = head;
                    head.prev = node;
                    head = node;
                }

                size++;
            } else {
                SongNode tailNode = tail;
                userLists.remove(tailNode.user);

                tail = tail.prev;
                tail.next = null;

                node.next = head;
                head.prev = node;
                head = node;
            }
        } else {
            if (node == head) {
                // Song is already at the head, no need to move it
            } else if (node == tail) {
                // Song is at the tail, move it to the head
                tail = tail.prev;
                tail.next = null;

                node.next = head;
                head.prev = node;
                head = node;
            } else {
                // Song is in the middle, remove it from its current position
                node.prev.next = node.next;
                node.next.prev = node.prev;

                // Add the song to the head
                node.next = head;
                head.prev = node;
                head = node;
            }
        }
    }

    public String[] getRecentlyPlayedSongs(String user) {
        SongNode node = userLists.get(user);
        String[] songs = new String[size];

        int i = 0;
        while (node != null) {
            songs[i] = node.song;
            node = node.next;
            i++;
        }

        return songs;
    }
}
