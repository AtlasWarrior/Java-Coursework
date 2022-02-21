/*
 * AUTHOR: Benjamin Nylen
 * FILE: UserCollection.java
 * COURSE: CSc 210; Section 01; Spring 2022
 * PURPOSE: UserCollection.java is responsible
 * for handling all of the created users during
 * a session of the Spotify program.
 */


import java.util.*;


public class UserCollection {
	
	Set<User> users = new HashSet<User>();
	
	Map<String, User> userMap = new TreeMap<String, User>();
	
	/*
	 * UserCollection is a constructor responsible for creating a
	 * new instance of the UserCollection class. In this case, nothing
	 * is constructed.
	 */
	public UserCollection () {
		
		
	}
	
	/*
	 * userExists is responsible for looking through the Set
	 * of Users and checking if the inputted username exists.
	 * The method returns a boolean which will be true if the
	 * user exists, and false if the user does not exist.
	 * 
	 * @param username, which is the username of the specific
	 * user to be checked for. 
	 * 
	 * @return true, in this case the user exists.
	 * 
	 * @return false, in this case the user does not exist.
	 */
	public boolean userExists(String username) {
		
		for (User element : users) {
			
			if (element.getName().equals(username)) {
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	/*
	 * login is responsible for handling a login attempt from a user.
	 * This method will check first to see if the user name exists. After this,
	 * it will utilize the value of the userMap, which is a User object, and
	 * call the attemptLogin method in the User class to ensure that the inputted
	 * password matches the given user. If the login attempt is successful, the
	 * method will return the user with the affiliated credentials. If the login
	 * fails, the method will simply return null.
	 * 
	 * @param username, is the username of the specified user.
	 * 
	 * @param password, is the password of the specified user.
	 * 
	 * @return userMap.get(username), which is the User object affiliated with
	 * the given credentials.
	 * 
	 * @return null, in this case the login attempt was unsuccessful
	 */
	public User login(String username, String password) {
		
		if (userMap.containsKey(username) && userMap.get(username).attemptLogin(password)) {
			
			return userMap.get(username);
			
		}
		
		
		return null;
		
	}
	
	/*
	 * addUser is responsible for adding a new user to the data structures
	 * within this class. 
	 * 
	 * @param add, which is the User object to be added to the collection of users.
	 */
	public void addUser (User add) {
		
		users.add(add);
		userMap.put(add.getName(), add);
		
		
	}
	
	/*
	 * toString() is responsible for printing out each User object
	 * and indicating how many playlists each specific user has created
	 * while logged in. It should be noted that this method retrieves the
	 * name of the user through the User class, as well as the amount of
	 * playlists through the Playlist class.
	 */
	public String toString() {
		
		String str = "{ ";
		
		for (User element : userMap.values()) {	
			
			str += element.getName() + ": " + 
			element.getPlaylists().size() + " playlist(s), ";
			
		}
		
		str += "}";
		
		return str;
		
	}

}
