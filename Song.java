/* Siddharth Korukonda
   115607752
   CSE 114
   Paul Fodor
   Homework 8
 */

import java.util.*;

public class Song implements Comparable<Song> {
    private String songName;
    private String artistName;
    private String duration;

    public Song() {
        songName = null;
        artistName = null;
        this.duration = null;
    }
    public Song(String song,String artist,String duration) {
        songName = song;
        artistName = artist;
        this.duration = duration;
    }
    public String getSongName() {
        return songName;
    }
    public String getArtistName() {
        return artistName;
    }
    public String getDuration() {
        return duration;
    }
    public void setSongName(String songName) {
        this.songName = songName;
    }
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return songName + " by " + artistName + " (" + duration + ")\n";
    }
    @Override
    public int compareTo(Song o) {
        return this.toString().compareTo(o.toString());
    }
}






