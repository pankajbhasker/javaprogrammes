package com.bhasker.programs;


import java.util.*;

public class RecentlyPlayedStore {
    private final int capacity;
    private final Map<String, LinkedList<String>> userSongMap;

    public RecentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        this.userSongMap = new HashMap<>();
    }

    // Method to play a song for a user
    public void playSong(String user, String song) {
        LinkedList<String> playlist = userSongMap.getOrDefault(user, new LinkedList<>());

        // If the song is already in the playlist, remove it to update its recentness
        playlist.remove(song);

        // If the playlist exceeds the capacity, remove the least recently played song
        if (playlist.size() == capacity) {
            playlist.removeFirst();
        }

        // Add the song to the end of the playlist (most recently played)
        playlist.addLast(song);
        userSongMap.put(user, playlist);
    }

    // Method to get the recently played songs for a user
    public List<String> getRecentlyPlayedSongs(String user) {
        return userSongMap.getOrDefault(user, new LinkedList<>());
    }

    public static void main(String[] args) {
        RecentlyPlayedStore store = new RecentlyPlayedStore(3);

        // Simulate playing songs for a user
        store.playSong("user1", "S1");
        store.playSong("user1", "S2");
        store.playSong("user1", "S3");
        System.out.println("Recently played: " + store.getRecentlyPlayedSongs("user1"));

        store.playSong("user1", "S4"); // S1 should be removed
        System.out.println("Recently played: " + store.getRecentlyPlayedSongs("user1"));

        store.playSong("user1", "S2"); // S2 should be moved to the most recent position
        System.out.println("Recently played: " + store.getRecentlyPlayedSongs("user1"));

        store.playSong("user1", "S1"); // S3 should be removed
        System.out.println("Recently played: " + store.getRecentlyPlayedSongs("user1"));
    }
}
