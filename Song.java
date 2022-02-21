/*
 * AUTHOR: Benjamin Nylen
 * FILE: Song.java
 * COURSE: CSc 210; Section 01; Spring 2022
 * PURPOSE: This file contains the Song class, which is
 * responsible for constructing new instances of the song class,
 * along with "playing" and printing out the song.
 */

public class Song {
	
	//Initializing variables
	
	private String title;
	private String artist;
	private int count = 0;
	
	/*
	 * Song is a contructor method that is responsible for creating
	 * an instance of the Song class.
	 * 
	 *  @param title, is the title of the song
	 *  @param artist, is the person who sings the song
	 */
	public Song (String title, String artist) {
		
		this.title = title;
		this.artist = artist;
		
	}
	
	/*
	 * A method responsible for retrieving the title
	 * of the song. This method is mainly utilized for usage in other
	 * classes.
	 * 
	 * @return this.title, which is the title of the song
	 * in a specific instance of the song class. 
	 */
	public String getTitle () {
		
		return this.title;
		
	}
	
	/*
	 * A method responsible for retrieving the artist of the
	 * song. This method is mostly utilized in other classes.
	 * 
	 * @return this.title. which is the artist of the song
	 * in a specific instance of the song class.
	 */
	public String getArtist () {
		
		return this.artist;
		
	}
	
	/*
	 * A method responsible for getting the amount of times a specific
	 * song has been played.
	 * 
	 * @return this.count, which is a variable that increments each time a
	 * song has been played for a specific song.
	 */
	public int getTimesPlayed () {
		
		return this.count;
		
	}
	
	/*
	 * A method responsible for "playing" a song. This method uses
	 * the below toString() method to play the song in the following 
	 * format: Title by artist, timesPlayed play(s). Additionally, 
	 * this method increments the count variable in a specific instance
	 * to indicate how many times the song has been played.
	 */
	public void play() {
		
		System.out.println(this.toString());
		
		this.count += 1;
		
	}
	
	/*
	 * A method responsible for printing out a description of a song
	 * in the following format: Title by artist, timesPlayed play(s).
	 * 
	 * @return, A String in the above-mentioned format is returned for
	 * usage across this class and other classes.
	 */
	public String toString() {
		
		return this.title + " by " + this.artist + ", " + this.count + " play(s)";
		
	}
	

}
