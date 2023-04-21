We can combine a dictionary and a doubly linked list to construct an in-memory storage for recently played songs that can hold N songs per user. 
Song-user pairs will be stored in the linked list nodes and the mapping between users and linked list nodes will be stored in the dictionary.

-> The 'song' and 'user' attributes of the 'SongNode' class, which represents a node in the linked list, respectively store the song and the person who played it. The linked list's previous and subsequent nodes are indicated by the 'prev' and 'next' properties, respectively.

-> The 'RecentlyPlayedStore' class contains some Java-specific syntax but the same fields and methods as before. User lists are stored in the 'userLists' field, which is a 'Map' with 'String' keys denoting users and 'SongNode' values denoting the linked list's head node. The 'addPlayedSong' and 'getRecentlyPlayedSongs' methods now return 'void' and 'String[]', respectively.
