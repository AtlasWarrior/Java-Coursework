/*
 * AUTHOR: Benjamin Nylen
 * FILE: Library.java
 * COURSE: CSc 210; Section 01; Spring 2022
 * PURPOSE: Library.java is responsible for keeping
 * track of all imported songs in the Spotify program.
 * It should be noted that the songs in the library stem from
 * a file titled "songs.txt" and is passed in through a command
 * line argument. The file should be formatted in the following format:
 * (For each song), Artist/Title.
 */


import java.util.*;


public class Library {

	private Map<String, Song> songMap;
	
	private Set<String> songMapKeys;
	
	
	/*
	 * Library is a constructor utilized to construct a TreeMap
	 * containing the title of the song as a key and the actual 
	 * song object as the value.
	 */
	public Library() {
		
		songMap = new TreeMap<String, Song>();
		
	}
	
	/*
	 * A getter method utilized to retrieve the song object
	 * associated with a title of a song.
	 * 
	 * @param title, which is the String representation of the
	 * title of the song.
	 * 
	 * @return songMap.get(title), which is the actual song
	 * object retrieved from the TreeMap songMap.
	 */
	public Song getSong (String title) {
		
				
		return songMap.get(title);
		
		
	}
	
	/*
	 * A method responsible for adding songs to the TreeMap.
	 * 
	 * @param song, which is the Song object to be added to 
	 * the TreeMap.
	 */
	public void addSong (Song song) {
		
		songMap.put(song.getTitle(), song);
		
		songMapKeys = songMap.keySet();
		
		
	}
	
	/*
	 * A method responsible for removing songs from the TreeMap.
	 * 
	 * @param song, which is the Song object to be removed from
	 * the TreeMap.
	 */
	public void removeSong (Song song) {
		
		
		songMap.remove(song.getTitle());
		
		
	}
	
	/*
	 * toString() is a method that is responsible for
	 * printing out a description of each song in the library.
	 * It should be noted that this method is actually calling
	 * the toString() method in the Song class, and printing out
	 * a description using that method.
	 * 
	 * @return str, which is a concatenated string containing
	 * descriptions of all songs in the library.
	 */
	public String toString() {
		
		String str = "";
		
		for (String element : songMapKeys) {
			
			str += songMap.get(element).toString() + "\n";
			
		}
		
		return str;
		
	}

}
