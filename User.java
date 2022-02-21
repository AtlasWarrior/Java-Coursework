/*
 * AUTHOR: Benjamin Nylen
 * FILE: User.java
 * COURSE: CSc 210; Section 01; Spring 2022
 * PURPOSE: User.java is responsible for controlling
 * a specific user within the Spotify program. This file
 * contains methods and data structures utilized to carry
 * out functions in the Spotify program.
 */


import java.util.*;


public class User {
	
	String name;
	String password;
	List<Playlist> playlists = new ArrayList<Playlist>();
	
	
	/*
	 * User is a constructor which builds a new instance of the
	 * User class. 
	 * 
	 * @param name, which is the Username of the new user.
	 * 
	 * @param password, which is the password of the new user.
	 */
	public User (String name, String password) {
		
		this.name = name;
		
		this.password = password;
		
		
	}
	
	/*
	 * A getter method responsible for getting the specific username
	 * of a User. 
	 * 
	 * @ return name, which is the name of the user.
	 */
	public String getName() {
		
		return name;
		
	}
	
	/*
	 * attemptLogin is a method which is responsible for 
	 * handling user login attempts. For a specific user,
	 * if the password is valid, the method will return true. If not,
	 * it will return false.
	 * 
	 * @param password, which is the inputted password to be tested for login.
	 * 
	 * @return true, in this case the password is valid for the given user.
	 * 
	 * @return false, in this case the password is invalid for the given user.
	 */
	public boolean attemptLogin (String password) {
		
		if (this.password.equals(password)) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	/*
	 * addPlaylist is a method responsible for adding a new playlist
	 * to a data structure containing all of the playlists for that
	 * specific user.
	 * 
	 * @param newPlaylist, which is the new playlist to be added to the
	 * ArrayList of playlists.
	 */
	public void addPlaylist (Playlist newPlaylist) {
		
		playlists.add(newPlaylist);
		
		
	}
	
	/*
	 * A getter method responsible for retrieving the ArrayList
	 * of playlists for a specific user.
	 * 
	 * @return playlists, which is an ArrayList of playlists for
	 * a specific user.
	 */
	public List<Playlist> getPlaylists() {
		
		
		return playlists;
		
	}
	
	/*
	 * selectPlaylist is responsible for retrieving a specific playlist
	 * for a certain user in the playlists ArrayList. Once it has been retrieved,
	 * the playlist will be "played" by calling first the play() method in the
	 * Playlist class, which then will call the play() method in the Song class.
	 * 
	 * @param name, which is the name of a specified playlist.
	 */
	public void selectPlaylist (String name) {
		
		for (Playlist element : playlists) {
			
			if (element.getName().equals(name)) {
				
				element.play();
				
			}
			
		}
		
	}
	
	/*
	 * toString() is responsible for printing out a String containing the
	 * User's name as well as how many playlists they have created.
	 * 
	 * @return this.name + " " + playlists.size() + " playlists", which is
	 * the String indicating the username of the user and how many
	 * playlists they have.
	 */
	public String toString() {
		
		
		return this.name + " " + playlists.size() + " playlists";
		
	}

}
