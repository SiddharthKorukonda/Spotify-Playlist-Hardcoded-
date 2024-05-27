/* Siddharth Korukonda
   115607752
   CSE 114
   Paul Fodor
   Homework 8
 */

import java.util.*;

public class User {
    private String userName;
    ArrayList<Playlist> playlists;
    public User(String userName) {
        this.userName = userName;
        playlists = new ArrayList<Playlist>();
    }
    public String getUserName() {
        return userName;
    }
    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }
    public Playlist getPlaylist(String playlistTitle) {
        for (Playlist playlist : playlists) {
            if (playlist.getPlaylistTitle().equals(playlistTitle))
                return playlist;
        }
        return null;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPlaylist(ArrayList<Playlist> playlist) {
        this.playlists = playlist;
    }
    public void addPlayList(Playlist playlist) {
        playlists.add(playlist);
    }
    public void removePlaylist(String playlistTitle) {
        for (int i=0; i<playlists.size(); i++) {
            if (playlists.get(i).getPlaylistTitle().equals(playlistTitle)) {
                playlists.remove(i);
            }
        }
    }

    public void makeCollaborativePlaylist(String playlistTitle, User friend) {
        for (Playlist playlist : playlists) {
            if (playlist.getPlaylistTitle().equals(playlistTitle)) {
                friend.addPlayList(playlist);
            }
        }
    }
}

