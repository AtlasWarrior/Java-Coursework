/*
 * AUTHOR: Benjamin Nylen
 * FILE: PA2Main.java
 * ASSIGNMENT: PA2 - Job Skills
 * COURSE: CSc 210; Section 01; Spring 2022
 * PURPOSE: The purpose of doing this assignment to 
 * create a better understanding of using and implementing HashMaps 
 * within programs. In this program, job skills will be analyzed.
 * This program requires that a CSV file be taken in as the first
 * argument. For the 2nd argument, this will be one of two allowed commands.
 * The first command is CATCOUNT, which will display each job category and
 * the amount of positions available for that category. The second command
 * is LOCATIONS. For this command, the argument will first specify LOCATIONS
 * as an argument, then it must specify a job category to search for. 
 * Once this has been done, the program will print each location which
 * has a job opening available in that given category.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PA2Main {
    public static void main(String[] args) throws FileNotFoundException {

        // Taking in the CSV file from the arguments.

        Scanner file = new Scanner(new File(args[0]));

        // Taking in the Command from the arguments

        Scanner command = new Scanner(args[1]);

        // Initializing categoryArgument and categoryString

        // categoryArgument is a scanner which will grab the category

        // categoryString is the above argument converted to a string

        Scanner categoryArgument;

        String categoryString;

        String commandLine = command.nextLine();

        // Checking if the 2nd argument is LOCATIONS

        if (commandLine.equals("LOCATIONS")) {

            categoryArgument = new Scanner(args[2]);

            categoryString = categoryArgument.nextLine();

        } else {

            // Setting both variables to null if the command is CATCOUNT

            categoryArgument = null;

            categoryString = null;
        }


        // Initializing categoryMap, which is a HashMap used to store the
        // necessary information for each command to run.

        Map<String, Integer> categoryMap = new HashMap<String, Integer>();

        ReadCommandLine(command, categoryMap, file,
                categoryString, commandLine);

        // Closing all scanners following their use.

        file.close();

        command.close();

        if (categoryArgument != null) {

            categoryArgument.close();
        }

    }

    /*
     * A method which is utilized to read in the first argument, which
     * is the CSV file provided. This method will update the HashMap
     * categoryMap, which is created in main, in order to create a HashMap
     * that will handle each command properly. Depending on the command that
     * is provided to this method, the method will populate the HashMap in
     * different ways for CATCOUNT and LOCATIONS.
     * 
     * @param file, is the CSV file which is provided as an argument
     * 
     * @param categoryMap, is a HashMap which is utilized to store the
     * necessary information to run a given command.
     * 
     * @param categoryArgument, is the string containing the category argument.
     * It should be noted that this is primarily used for the LOCATIONS command
     * 
     * @param commandLine, which is a String that holds the command in the
     * arguments.
     * 
     * @return categoryMap, which is now populated following the running
     * of this method
     */

    public static Map<String, Integer> OpenFile(Scanner file,
            Map<String, Integer> categoryMap,
            String categoryArgument, String commandLine) {

        // Using .nextLine() in order to get titles in the first row of CSV

        file.nextLine();

        // Using a while loop, to get to the end of the file.

        while (file.hasNext()) {
            // Initializing variables to store category and location,
            // as well as reading each line and splitting it by commas.

            String line = file.nextLine();

            String data[] = line.split(",");

            String category = data[2];

            String location = data[3];

            // If statement to populate HashMap if command is CATCOUNT.

            if (commandLine.equals("CATCOUNT")) {

                if (categoryMap.containsKey(category)) {

                    categoryMap.put(category, categoryMap.get(category) + 1);

                } else {

                    categoryMap.put(category, 1);
                }

                // If statement to populate HashMap if command is LOCATIONS.

            }else {

                // The below if statement will place in the HashMap if the
                // location is not already in the map, and the category
                // equals the one in the given argument.

                if (!categoryMap.containsKey(location)
                        && category.equals(categoryArgument)) {

                    categoryMap.put(location, 1);

                }

                // This statement will increment the value on the HashMap
                // if the location is in the HashMap, and the category
                // equals the one in the given argument.

                else if (categoryMap.containsKey(location)
                        && category.equals(categoryArgument)) {

                    categoryMap.put(location, categoryMap.get(location) + 1);
                }
            }

        }

        return categoryMap;
    }

    /*
     * A method which is essentially the heart and soul of the program.
     * This method will grab the command portion of the argument, and
     * utilize it to determine which other methods to call.
     * 
     * @param command, is the Scanner object which holds the command
     * from the arguments.
     * 
     * @param categoryMap, is a HashMap which is utilized to store the
     * necessary information to run a given command.
     * 
     * @param file, is the CSV file which is provided as an argument
     * 
     * @param categoryString, is the string containing the category argument.
     * It should be noted that this is primarily used for the LOCATIONS command.
     * 
     * @param commandLine, which is a String that holds the command in the
     * arguments.
     * 
     * 
     */

    public static void ReadCommandLine(Scanner command,
            Map<String, Integer> categoryMap, Scanner file,
            String categoryString, String commandLine) {

        if (commandLine.equals("CATCOUNT")) {
            
            categoryMap = OpenFile(file, categoryMap,
                    categoryString, commandLine);

            CatCount(categoryMap);
        }
        else if (commandLine.equals("LOCATIONS")) {

            categoryMap = OpenFile(file, categoryMap,
                    categoryString, commandLine);

            Locations(categoryMap, categoryString);
         } 
            else {

                // Printing out "Invalid Command" if the command
                // is neither "CATCOUNT" or "LOCATIONS"

               System.out.println("Invalid Command");
           }
                
       }

       /*
        * A method which is primarily utilized for handling the execution
        * of the LOCATIONS command. This function will utilize the created
        * and updated HashMap in OpenFile in order to create an ArrayList
        * of
        * keys, and then sort them. Following this, the keys are printed
        * with
        * their values in alphabetical order.
        * 
        * @param categoryMap, is a HashMap which is utilized to store the
        * necessary information to run a given command.
        * 
        * @param categoryString, is the string containing the category argument.
        * It should be noted that this is primarily used for the LOCATIONS
        * command.
        */

    public static void Locations( Map<String, Integer> categoryMap,
              String categoryString) {
        
                // Initializing the sortedKeys ArrayList, which is using
                // .keySet()
                // to grab all of the keys from the categoryMap.

        List<String> sortedKeys = new ArrayList<String>(categoryMap.keySet());

                // Using Collections.sort in order to sort all of the keys in
                // order

        Collections.sort(sortedKeys);

        System.out.println("LOCATIONS for category: " + categoryString);
        System.out.println("-------------------------------------");

        // Looping through the sortedKeys ArrayList to print out each
        // key and value in order.

        for (String key : sortedKeys) {
            System.out.println(key + ", " + categoryMap.get(key));

    }

    }

    /*
     * A method which is primarily utilized for handling the execution
     * of the CATCOUNT command. This function will utilize the created
     * and updated HashMap in OpenFile in order to create an ArrayList of
     * keys, and then sort them. Following this, the keys are printed with
     * their values in alphabetical order.
     * 
     * @param categoryMap, is a HashMap which is utilized to store the
     * necessary information to run a given command.
     */

    public static void CatCount(Map<String, Integer> categoryMap) {

        // Initializing the sortedKeys ArrayList, which is using .keySet()
        // to grab all of the keys from the categoryMap.

        List<String> sortedKeys = new ArrayList<String>(categoryMap.keySet());

        // Using Collections.sort in order to sort all of the keys in order

        Collections.sort(sortedKeys);

        System.out.println("Number of positions for each category");
        System.out.println("-------------------------------------");

        // Looping through the sortedKeys ArrayList to print out each
        // key and value in order.

        for (String key : sortedKeys) {
            System.out.println(key + ", " + categoryMap.get(key));

        }

    }

}

