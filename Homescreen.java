/* Siddharth Korukonda
   115607752
   CSE 114
   Paul Fodor
   Homework 8
 */

// This is the "Main" class

public class Homescreen {
    public static void main(String[] args) {
        Playlist p0 = new Playlist("Study Songs");
        Song s1 = new Song("Studying1", "ABC", "3:00");
        Song s2 = new Song("Studying2", "XYZ", "4:50");
        p0.addSong(s1);
        p0.addSong(new Song("Studying3", "CDE", "2:50"));
        p0.addSong(new Song("Studying4", "EFG", "3:25"));
        Playlist p1 = new Playlist("Workout Songs");
        p1.addSong(new Song("Exercising1", "JKL", "3:00"));
        p1.addSong(new Song("Exercising2", "OPQRS", "2:50"));
        p1.addSong(new Song("Exercising3", "Wxyz", "4:35"));
        p1.addSong(new Song("Exercising3", "Stu", "3:25"));

        User u0 = new User("Paul");
        User u1 = new User("Mary");
        MusicService.addUser(u0);
        MusicService.addUser(u1);
        u0.addPlayList(p0);
        u1.addPlayList(p1);
        System.out.println("ORIGINAL STUDY SONGS PLAYLIST BY "+u0.getUserName() + ":");

        for (Playlist p : MusicService.getUserPlaylists(u0)) {
            System.out.println(p);
        }
        System.out.println("ORIGINAL STUDY SONGS PLAYLIST BY "+u1.getUserName() + ":");

        for (Playlist p : MusicService.getUserPlaylists(u1)) {
            System.out.println(p);
        }
        u0.makeCollaborativePlaylist("Study Songs", u1);
        u0.getPlaylist("Study Songs").setPlaylistTitle("Study Songs with "+u1.getUserName());
        u1.getPlaylist("Study Songs with "+u1.getUserName()).removeSong("Studying4");
        u1.getPlaylist("Study Songs with "+u1.getUserName()).addSong(s2);
        u1.getPlaylist("Study Songs with "+u1.getUserName()).swapSongs(s1, s2);
        u1.getPlaylist("Study Songs with "+u1.getUserName()).swapSongs(new Song("Does Not Exist", "In Playlist", "5:00"), s2);
        System.out.println("UPDATED PLAYLISTS BY "+u0.getUserName());

        for (Playlist p : MusicService.getUserPlaylists(u1)) {
            System.out.println(p);
        }
        u0.getPlaylist("Study Songs with "+u1.getUserName()).sortSongs();
        u1.getPlaylist("Workout Songs").sortSongs();
        System.out.println("AFTER SORTING BOTH PLAYLISTS:");

        for (Playlist p : MusicService.getUserPlaylists(u1)) {
            System.out.println(p);
        }
    }
}
