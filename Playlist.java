/* Siddharth Korukonda
   115607752
   CSE 114
   Paul Fodor
   Homework 8
 */

import java.util.*;

public class Playlist {
    private String playlistTitle;
    ArrayList<Song> songs;

    public Playlist(String playlistTitle) {
        this.playlistTitle = playlistTitle;
        songs = new ArrayList<>();
    }
    public String getPlaylistTitle() {
        return playlistTitle;
    }
    public void setPlaylistTitle(String playlistTitle) {
        this.playlistTitle = playlistTitle;
    }
    public void addSong(Song song) {
        songs.add(song);
    }
    public void removeSong(String songName) {
        for (int i=0; i<songs.size(); i++) {
            if (songs.get(i).getSongName().equals(songName)) {
                songs.remove(i);
            }
        }
    }
    public void swapSongs(Song song1, Song song2) {
        int song1Index=-1;
        int song2Index=-1;

        for (int i=0; i<songs.size(); i++) {
            if (songs.get(i)==song1)
                song1Index=i;
            if (songs.get(i)==song2)
                song2Index=i;
        }
        if (song1Index!=-1 && song2Index!=-1) {
            Song temp = songs.get(song1Index);
            songs.set(song1Index, songs.get(song2Index));
            songs.set(song2Index, temp);
        }
    }
    public String getTotalTime() {

        int totalmin=0;
        int totalsec=0;

        for (Song song : songs) {
            String duration = song.getDuration();
            String[] min_sec = duration.split(":");
            totalmin += (int) Double.parseDouble(min_sec[0]);
            totalsec += (int) Double.parseDouble(min_sec[1]);
        }
        if (totalsec>60) {
            totalmin += (int) totalsec/60;
            totalsec = totalsec%60;
        }
        return totalmin +"min, "+ totalsec+" sec";
    }
    public void sortSongs() {
        Collections.sort(songs);
    }

    @Override
    public String toString() {
        StringBuilder songList = new StringBuilder();
        for (int i=0;i<songs.size();i++) {
            songList.append((i+1)).append(". ").append(songs.get(i).toString());
        }
        return  playlistTitle + " - " + getTotalTime()+"\n"+ songList;
    }
}