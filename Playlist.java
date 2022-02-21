/*
 * AUTHOR: Benjamin Nylen
 * FILE: Playlist.java
 * COURSE: CSc 210; Section 01; Spring 2022
 * PURPOSE: Playlist.java is responsible for
 * handling playlists within the Spotify program
 */


import java.util.*;



public class Playlist {
	
	String name;
	List<Song> contents;
	
	/*
	 * Playlist is a constructor responsible for building
	 * a new instance of the playlist class. 
	 * 
	 * @param name, is the name of the playlist
	 */
	public Playlist(String name) {
		
		this.name = name;
		
		contents = new ArrayList<Song>();
		
	}
	
	/*
	 * This version of playlist is a secondary constructor
	 * of the playlist class, where this time the playlist
	 * songs are included in the constructor as well.
	 * 
	 * @param name, is the name of the playlist
	 * 
	 * @param contents, is an ArrayList of Song objects
	 * containing all of the songs in the playlist.
	 */
	public Playlist (String name, List<Song> contents) {
		
		this.name = name;
		this.contents = contents;
		
	}
	
	/*
	 * A getter method responsible for retrieving the name of
	 * the playlist.
	 * 
	 * @return name, which is the name of the playlist.
	 */
	public String getName() {
		
		return name;
		
	}
	
	/*
	 * A method responsible for adding song objects to the
	 * ArrayList named contents.
	 * 
	 * @param song, A Song object to be added to contents
	 */
	public void addSong (Song song) {
		
		contents.add(song);
		
	}
	
	/*
	 * play() is responsible for "playing" each song within
	 * a playlist. It should be noted that this method actually
	 * calls the play() method within the Song class, since
	 * the ArrayList contains all Song objects.
	 */
	public void play() {
		
		for (Song element : contents) {
			
			element.play();
			
		}
		
	}
	
	/*
	 * A method responsible for removing a Song object from
	 * the ArrayList named contents, if the object exists. 
	 * 
	 * @param song, which is a Song object to be removed from
	 * contents.
	 */
	public void removeSong(Song song) {
		
		for (Song element : contents) {
			if (element.equals(song)) {
				
				contents.remove(song);
				
			}
		}
		
	}

}
