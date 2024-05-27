/* Siddharth Korukonda
   115607752
   CSE 114
   Paul Fodor
   Homework 8
 */

import java.util.*;

public class MusicService {
    public static ArrayList<User> users = new ArrayList<User>();
    public static void addUser(User newuser) {
        users.add(newuser);
    }
    public void removeUser(User user){
        for (int i=0; i<users.size(); i++) {
            if (users.get(i).equals(user)) {
                users.remove(i);
            }
        }
    }
    public static ArrayList<Playlist> getUserPlaylists(User user) {
        for (User value : users) {
            if (value.equals(user)) {
                return user.getPlaylists();
            }
        }
        return null;
    }
}