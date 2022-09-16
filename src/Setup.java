/**
 * title: Setup.java
 * description: Class responsible for setting up and initializing the game
 * date: Sep 16, 2022
 * @author Andrei Albu
 * @version 1.0
 * @copyright 2022 Andrei Albu
 */

/**
 * Certain code for the Setup class is adapted from: https://github.com/CRMinges/adventure
 * Accessed: Aug 29, 2022
 */

// Import Java packages
import java.util.*;
import java.io.*;

/** Primary (public) class Setup */
public class Setup {

    /** Public static method to create the game items */
    public static HashMap<String, Item> createItems() {

        // Create FileReader and BufferedReader objects to read the items from a file
        try (FileReader file = new FileReader("Items.txt");
                BufferedReader br = new BufferedReader(file)) {

            // Create a HashMap to store the items
            HashMap<String, Item> items = new HashMap<String, Item>();
            String line = br.readLine();

            // While there are still lines to read in the file
            while (line != null) {

                // Get the name of the item
                String name = line;
                name = name.toLowerCase();
                line = br.readLine();

                // Get the location of the item
                String location = line.trim();
                line = br.readLine();

                // Get the action of the item
                String action = line.trim();
                line = br.readLine();

                // Get the effect of the item
                String effect = line.trim();
                line = br.readLine();

                // Get the description of the item, until "END" is reached
                String description = "";
                while (!line.equals("END")) {
                    description = description + line + '\n';
                    line = br.readLine();
                }

                // Put the item name and the Item object in the HashMap
                items.put(name, new Item(description, location, action, effect));

                // Read the next line
                line = br.readLine();
            }

            // Return the HashMap
            return items;

        } catch (IOException e) {
            // If the file is not found, display an error message
            System.out.println("Error reading file. Please check the filename and try again.");
            return null;
        }
    }

    /** Public static method to create the game locations */
    public static HashMap<String, Location> createLocations(HashMap<String, Item> items,
            HashMap<String, Character> NPCs) {

        // Create FileReader and BufferedReader objects to read the locations from a
        // file
        try (FileReader file = new FileReader("Locations.txt");
                BufferedReader br = new BufferedReader(file)) {

            // Create a HashMap to store the locations
            HashMap<String, Location> rooms = new HashMap<String, Location>();
            String line = br.readLine();

            // While there are still lines to read in the file
            while (line != null) {

                // Get the name of the location
                String name = line.trim();
                line = br.readLine();

                // Get the neighbouring locations
                String[] neighbours = line.split(",");
                for (int i = 0; i < neighbours.length; i++) {
                    neighbours[i] = neighbours[i].trim();
                }
                line = br.readLine();

                // Get the restrictions of the location
                String[] restrictions = line.split(" ");
                for (int i = 0; i < restrictions.length; i++) {
                    restrictions[i] = restrictions[i].trim();
                }
                line = br.readLine();

                // Get the description of the location, until "END" is reached
                String description = "";
                while (!line.equals("END")) {
                    description = description + line + '\n';
                    line = br.readLine();
                }

                // Put the location name and the Location object in the HashMap
                rooms.put(name, new Location(name, description, neighbours, items, NPCs, restrictions));

                // Read the next line
                line = br.readLine();
            }

            // Return the HashMap
            return rooms;

        } catch (IOException e) {
            // If the file is not found, display a error message
            System.out.println("Error reading file. Please check the filename and try again.");
            return null;
        }
    }

    /** Public static method to create the game actions */
    public static HashMap<String, Actions> createActions() {

        // Create FileReader and BufferedReader objects to read the actions from a file
        try (FileReader file = new FileReader("Actions.txt");
                BufferedReader br = new BufferedReader(file)) {

            // Create a HashMap to store the actions
            HashMap<String, Actions> actions = new HashMap<String, Actions>();
            String line = br.readLine();

            // While there are still lines to read in the file
            while (line != null) {

                // Split the line into the main action name and the action aliases
                String[] actionsList = line.split(",");
                String mainAction = actionsList[0];

                // Put the main action name and the Actions object in the HashMap
                actions.put(mainAction, new Actions(actionsList));

                // Read the next line
                line = br.readLine();
            }

            // Return the HashMap
            return actions;

        } catch (IOException e) {
            // If the file is not found, display a error message
            System.out.println("Error reading file. Please check the filename and try again.");
            return null;
        }
    }

    /** Public static method to create the game characters */
    public static HashMap<String, Character> createCharacters() {

        // Create FileReader and BufferedReader objects to read the characters from a
        // file
        try (FileReader file = new FileReader("Characters.txt");
                BufferedReader br = new BufferedReader(file)) {

            // Create a HashMap to store the characters
            HashMap<String, Character> NPCs = new HashMap<String, Character>();
            String line = br.readLine();

            // While there are still lines to read in the file
            while (line != null) {

                // Get the name of the character
                String name = line.trim().toLowerCase();
                line = br.readLine();

                // Get the location of the character
                String location = line.trim();
                line = br.readLine();

                // Get the dialogue of the character, until "END" is reached
                String dialog = "";
                while (!line.equals("END")) {
                    dialog = dialog + line + '\n';
                    line = br.readLine();
                }

                // Put the character name and the Character object in the HashMap
                NPCs.put(name, new Character(dialog, location));

                // Read the next line
                line = br.readLine();
            }

            // Return the HashMap
            return NPCs;

        } catch (IOException e) {
            // If the file is not found, display a error message
            System.out.println("Error reading file. Please check the filename and try again.");
            return null;
        }
    }

    /** Public static method to create the game instructions */
    public static String gameInstructions() {

        // Create FileReader and BufferedReader objects to read the instructions from a
        // file
        try (FileReader file = new FileReader("Instructions.txt");
                BufferedReader br = new BufferedReader(file)) {

            // Create a String to store the instructions
            String line = br.readLine();
            String instructions = "";

            // While there are still lines to read in the file, append them to the
            // instructions
            while (line != null) {
                instructions = instructions + line + '\n';
                line = br.readLine();
            }

            // Return the instructions
            return instructions;

        } catch (IOException e) {
            // If the file is not found, display a error message
            System.out.println("Error reading file. Please check the filename and try again.");
            return null;
        }
    }

    /** Public static method to create the game help menu */
    public static String help() {

        // Create FileReader and BufferedReader objects to read the help menu from a
        // file
        try (FileReader file = new FileReader("Actions.txt");
                BufferedReader br = new BufferedReader(file)) {

            // Create a String to store the help menu
            String line = br.readLine();
            String help = "The following are the commands that are available to you:\n\n";

            // While there are still lines to read in the file, append them to the help
            // variable
            while (line != null) {
                help = help + line + '\n';
                line = br.readLine();
            }
            help = help + "\nAll commands on the same line act as synonyms and all are case insensitive.\n";

            // Return the help menu
            return help;

        } catch (IOException e) {
            // If the file is not found, display a error message
            System.out.println("Error reading file. Please check the filename and try again.");
            return null;
        }
    }

    /** Public static method to create the game win message */
    public static String win() {

        // Create FileReader and BufferedReader objects to read the win message from a
        // file
        try (FileReader file = new FileReader("Win.txt");
                BufferedReader br = new BufferedReader(file)) {

            // Create a String to store the win message
            String line = br.readLine();
            String win = "";

            // While there are still lines to read in the file, append them to the win
            // variable
            while (line != null) {
                win = win + line + '\n';
                line = br.readLine();
            }

            // Return the win message
            return win;

        } catch (IOException e) {
            // If the file is not found, display a error message
            System.out.println("Error reading file. Please check the filename and try again.");
            return null;
        }
    }
}
