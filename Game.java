/**
 * title: Game.java
 * description: The highest level class responsible for running the game
 * date: Sep 10, 2022
 * @author Andrei Albu
 * @version 1.0
 * @copyright 2022 Andrei Albu
 */

/**
 * DOCUMENTATION...
 */

/**
 * 
 * Alice's Adventures in Wonderland
 * 
 * Purpose and Description
 * 
 * This program is a text-based adventure game based on the novel Alice's Adventures in Wonderland by Lewis Carroll. 
 * 
 * This program is a fun game that allows the user to explore the world of Wonderland and interact with the characters
 * and items in the game. The user can play the game by typing in commands and the program will respond accordingly once
 * the ENTER key is pressed.
 * 
 * Compiling and running instructions
 * Compile: javac Game.java
 * Run    : java Game
 * 
 */

/**
 * 
 * Class:
 * 
 * public class Actions
 * This class represents an Action object.
 * 
 * Constructor:
 * 
 * public Actions(String[] actions)
 * Initializes the instance variable with the parameter it receives
 * 
 * Methods:
 * 
 * public String[] getActions()
 * Getter method that returns the actions instance variable
 * 
 * Instance Variables:
 * 
 * private String[] actions
 * A String array that holds all of the action words
 * 
 * ---------------------------------------------------------------------------------------------------------------------
 * 
 * Class:
 * 
 * public class Character
 * This class represents a non-playable character (NPC) in the game. These are the characters that are spawned in the game
 * and that the user can interact with.
 * 
 * Constructor:
 * 
 * public Character(String dialog, String location)
 * Initializes the instance variables to the parameters it receives
 * 
 * Methods:
 * 
 * public void talk()
 * Outputs the NPC's dialog
 * 
 * public String getLocation()
 * Getter method that returns the NPC's location
 * 
 * Instance Variables:
 * 
 * private String dialogue
 * A String that stores the text the character displays when the user talks to them
 * 
 * private String location
 * A String that stores the name of the location where the NPC is located in the game
 * 
 * ---------------------------------------------------------------------------------------------------------------------
 * 
 * Class:
 * 
 * public class Control
 * This class is responsible for validating the actions (or commands) the user enters. It works alongside the
 * Actions.java class to accomplish this.
 * 
 * Constructor:
 * None
 * 
 * Methods:
 * 
 * public static String checkInput(String command, HashMap<String, Actions> validActions)
 * A static method that accepts the action (or command) entered by the user and a HashMap that contains the main action
 * words and the Actions object as key-value pairs. It validates the action entered by the user against all the possible
 * action words stored in the HashMap using nested for loops.
 * 
 * Instance Variables:
 * None
 * 
 * ---------------------------------------------------------------------------------------------------------------------
 * 
 * Class:
 * 
 * public class Game
 * This class is the highest level class of the game. It is responsible for the flow of the game and for which events
 * happen in response to the user input.
 * 
 * Constructor:
 * 
 * public Game()
 * Initializes all the instance variables with the help of the Setup class. It also removes the Queen of Hearts’ items
 * from the location they spawn in.
 * 
 * Methods:
 * 
 * public static void main(String[] args)
 * The entry point of the game which controls the entire flow of the game.
 * 
 * Instance Variables:
 * 
 * private Player player
 * A Player object that represents the user in the game
 * 
 * private HashMap<String, Item> items
 * A HashMap object that stores the name of the item and an Item object representing the object as key-value pairs
 * 
 * private HashMap<String, Character> NPCs
 * A HashMap object that stores the name of the non-playable character and a Character object representing the character
 * as key-value pairs
 * 
 * private HashMap<String, Location> rooms
 * A HashMap object that stores the name of the location and a Location object representing the location as key-value
 * pairs
 * 
 * private HashMap<String, Actions> actions
 * A HashMap object that stores the main action word and an Action object representing the possible aliases as key-value
 * pairs
 * 
 * private HashMap<String, Item> queenItems
 * A HashMap object that stores the name of the Queen’s item and an Item object representing the object as key-value
 * pairs
 * 
 * ---------------------------------------------------------------------------------------------------------------------
 * 
 * Class:
 * 
 * public class Inventory
 * This class represents the inventory of the main player that is played by the user.
 * 
 * Constructor:
 * 
 * public Inventory()
 * Initializes the instance variable with an empty object
 * 
 * Methods:
 * 
 * public int getSize()
 * Getter method that returns the size of the inventory
 * 
 * public void putItem(String name, Item item)
 * Adds an item to the inventory
 * 
 * public boolean contains(String name)
 * Checks if the inventory contains an item
 * 
 * public void remove(String name)
 * Removes an item from the inventory
 * 
 * public Item getItem(String name)
 * Returns an item from the inventory
 * 
 * public Set<String> getItemsSet()
 * Returns the keys of the inventory as a Set object
 * 
 * Instance Variables:
 * 
 * private Map<String, Item> inventory
 * An object that stores the name of the item and an Item object representing the object as key-value pairs
 * 
 * ---------------------------------------------------------------------------------------------------------------------
 * 
 * Class:
 * 
 * public class Item
 * This class represents a single item in the game.
 * 
 * Constructor:
 * 
 * public Item(String description, String location, String action, String effect)
 * Initializes all of the instance variables to the parameters it receives
 * 
 * Methods:
 * 
 * public String getDescription()
 * Getter method that returns the description instance variable
 * 
 * public String getLocation()
 * Getter method that returns the location instance variable
 * 
 * public String getAction()
 * Getter method that returns the action instance variable
 * 
 * public String getEffect()
 * Getter method that returns the effect instance variable
 * 
 * Instance Variables:
 * 
 * private String description
 * A String that stores the description of the item
 * 
 * private String location
 * A String that stores the name of the location where the item is located in the game
 * 
 * private String action
 * A String that stores the action that the item has on the player when used (ex. level up, shrink, grow)
 * 
 * private String effect
 * A String that describes what happens to Alice when the item is used
 * 
 * ---------------------------------------------------------------------------------------------------------------------
 * 
 * Class:
 * 
 * public class Location
 * This class represents a single location in the game.
 * 
 * Constructor:
 * 
 * Location(String name, String description, String[] neighbours, HashMap<String, Item> items,
 *  		HashMap<String, Character> NPCs, String[] restrictions)
 * Initializes the instance variables to the parameters it receives. For the items and NPCs instance variables, the
 * constructor uses helper methods to initialize them (populateItems() and populateNPCs()).
 * 
 * Methods:
 * 
 * private void populateItems(HashMap<String, Item> items)
 * Iterates over the HashMap containing all of the items in the game and if the item’s location matches the current
 * location, it adds the item to the location
 * 
 * private void populateNPCs(HashMap<String, Character> NPCs)
 * Iterates over the HashMap containing all of the non-playable characters in the game and if the character’s location
 * matches the current location, it adds them to the location
 * 
 * public void look()
 * This method is called when the player uses the look command. It displays the information associated with the location,
 * such as the location’s description, its neighbouring locations and the items and NPCs that exist in the location.
 * 
 * public String[] getNeighbours()
 * Getter method that returns the neighbours instance variable
 * 
 * public HashMap<String, Item> getItems()
 * Getter method that returns the items instance variable
 * 
 * public String getDescription()
 * Getter method that returns the description instance variable
 * 
 * public HashMap<String, Character> getNPCs()
 * Getter method that returns the NPCs instance variable
 * 
 * public String[] getRestrictions()
 * Getter method that returns the restrictions instance variable
 * 
 * public void addItem(HahsMap<String, Item> items)
 * Adds the item passed as a parameter to the room
 * 
 * public void removeCharacter(String name)
 * Removes the character specified as a parameter from the room
 * 
 * Instance Variables:
 * 
 * private String name
 * A String that stores the name of the location
 * 
 * private String[] neighbours
 * An array of String objects that stores all the neighbouring rooms that can be accessed from the current room
 * 
 * private String description
 * A String that stores the description of the location
 * 
 * private String[] restrictions
 * An array of String objects that stores the restrictions that the player has to meet in order to access the room
 * 
 * private HashMap<String, Item> items
 * A HashMap object that stores the item name and an Item object representing the item as key-value pairs
 * 
 * private HashMap<String, Character> NPCs
 * A HashMap object that stores the non-playable character’s name and a Character object representing the character as
 * key-value pairs
 * 
 * ---------------------------------------------------------------------------------------------------------------------
 * 
 * Class:
 * 
 * public class Player
 * This class represents Alice in the game. This is also the main character that is played by the user.
 * 
 * Constructor:
 * 
 * Player(String startingLocation)
 * A constructor that initializes the instance variable to default values. It initializes the location instance variable
 * to the parameter it receives and also adds it to the visitedRooms instance variable.
 * 
 * Methods:
 * 
 * public void move(HashMap<String, Location> rooms, String direction)
 * Moves the player to a new location if the direction is valid and if the player meets the new location’s requirements
 * 
 * public void add(HashMap<String, Location> rooms, String item)
 * Adds an item to the players inventory if it exists in the location
 * 
 * public void drop(HashMap<String, Location> rooms, String item)
 * Removes an item from the player’s inventory if they have it
 * 
 * public void getInventory()
 * Displays all the items the player has in their inventory
 * 
 * public void look(String item)
 * Used when the player wants to look at an item and displays the item’s description
 * 
 * public void look(HashMap<String, Location> rooms)
 * Used when the player wants to look at the room. Calls the current room’s look method
 * 
 * public void talkTo(HashMap<String, Location> rooms, String npc, HashMap<String, Item> queenItems)
 * Outputs the non-playable character’s dialogue if they exist in the room
 * 
 * public void use(String item)
 * Uses an item if it exists in the player’s inventory
 * 
 * private boolean shrink()
 * Shrinks the player down a size
 * 
 * private boolean grow()
 * Grows the player up a size
 * 
 * private boolean isValidLocation(Location nextRoom)
 * Helper method that checks if the player can move to an adjacent location. It does this by ensuring the player meets
 * the location’s restrictions
 * 
 * private void addQueenItemsToRoom(HashMap<String, Location> rooms, HashMap<String, Item> items)
 * Adds the Queen’s items to the room and also removes the Queen from the room
 * 
 * public boolean hasWon()
 * Checks if the player has met the win condition of the game
 * 
 * public String getSize()
 * Getter method that returns the size instance variable
 * 
 * public String getLocation()
 * Getter method that returns the location instance variable
 * 
 * public int getLevel()
 * Getter method that returns the level instance variable
 * 
 * private void levelUp()
 * Levels up the player
 * 
 * Instance Variables:
 * 
 * ---------------------------------------------------------------------------------------------------------------------
 * 
 * Class:
 * 
 * public class Setup
 * This class is used to set up and initialize the game with the characters, items, locations etc.
 * 
 * Constructor:
 * None
 * 
 * Methods
 * 
 * public static HashMap<String, Item> createItems()
 * Loads the item data from Items.txt and create Item objects using it
 * 
 * public static HashMap<String, Location> createLocations(HashMap<String, Item> items,
 *         HashMap<String, Character> NPCs)
 * Loads the location data from Locations.txt and creates Location objects using it
 * 
 * public static HashMap<String, Actions> createActions()
 * Loads the action words from Actions.txt and creates Action objects using it
 * 
 * public static HashMap<String, Character> createCharacters()
 * Loads the character data from Characters.txt and creates Character objects using it
 * 
 * public static String gameInstructions()
 * Loads the data in Instructions.txt and returns it
 * 
 * public static String help()
 * Loads the data in Actions.txt and returns it in the form of a help menu
 * 
 * public static String win()
 * Loads the data in Win.txt and returns it
 * 
 * Instance Variables:
 * None
 * 
 */

/**
 * 
 * Test Plan
 * 
 * For this program to be successful, it must be able to:
 *      - properly load the game data from the text files
 *      - properly create the objects using the game data
 *      - handle invalid user input
 *      - allow the user to win the game by meeting the win condition
 * 
 * 
 * Scenario 1: The program successfully loads the game data from the text files
 * 
 * Input Data:
 *     - The text files containing the game data (Instructions.txt, Characters.txt, Items.txt, Locations.txt etc.)
 * EXPECTED:
 *      Welcome to Alice's Adventures in Wonderland! This is a roleplaying
 *      game based on the book by Lewis Carroll.  
 *      
 *      The game is set in Wonderland, a strange and magical place where
 *      anything can happen. You will be able to explore the world of 
 *      Wonderland and meet many strange and wonderful characters. You will
 *      also be able to interact with various items and objects in the game.
 *                                     . . .
 *      To play the game, type in a command and press enter.
 *      You can type in commands in lower or upper case, it doesn't matter.
 *      Many commands have synonyms, so you can type in a command in a
 *      variety of ways. For example, you can type in "go north" or "go n".
 *      
 *      You can type in "help" to get a list of all the commands.
 *      
 *      You are sitting on a tree branch in an open field, listening to you sister
 *      read a history book. You are very bored, when you suddenly notice a talking
 *      white rabbit with a pocket watch currying along the river bank. He quickly
 *      goes down a dark rabbit hole.
 *      
 *      NOTE: The expected output should be the data in Instructions.txt and the first location's description
 * ACTUAL:
 *      Results displayed as expected (confirmed by running the program).
 * 
 * ---------------------------------------------------------------------------------------------------------------------
 * 
 * NOTE: The rest of the scenarios are located in Test.txt as they are too long to fit in this document
 * 
 */

// Import Java packages
import java.util.*;

/** Primary (public) class Game */
public class Game {

    /** Private instance variables to store various attributes */
    private Player player;
    private HashMap<String, Item> items;
    private HashMap<String, Character> NPCs;
    private HashMap<String, Location> rooms;
    private HashMap<String, Actions> actions;
    private HashMap<String, Item> queenItems;

    /** Default constructor for the Game object */
    public Game() {

        // Display the game instructions
        String instructions = Setup.gameInstructions();
        System.out.println(instructions);

        // Using the Setup class, initialize the game instance variables
        this.player = new Player("Open field");
        this.items = Setup.createItems();
        this.NPCs = Setup.createCharacters();
        this.actions = Setup.createActions();
        this.queenItems = new HashMap<String, Item>();

        HashMap<String, Item> dummy = new HashMap<String, Item>();
        dummy.putAll(items);

        // Remove the queen's items from the items list
        for (Map.Entry<String, Item> entry : dummy.entrySet()) {
            String name = entry.getKey();
            Item item = entry.getValue();

            // Check if the item is a queen item
            if (name.substring(0, 5).equals("queen")) {
                this.queenItems.put(name, item);
                this.items.remove(name);
            }
        }

        // Create the rooms
        this.rooms = Setup.createLocations(items, NPCs);
    }

    /** Entry point of the program */
    public static void main(String[] args) {

        // Create a new Game and Scanner objects
        Game game = new Game();
        Scanner in = new Scanner(System.in);

        // Display the description of the starting room
        String startingLoc = game.player.getLocation();
        System.out.println(game.rooms.get(startingLoc).getDescription());

        // While loop to keep the game running until the player wins
        while (true) {

            // Check if player was won (inventory contains queen's staff and necklace)
            if (game.player.hasWon()) {
                String win = Setup.win();
                System.out.println("\n" + win);
                break;
            }

            // Split the user input into an array of strings
            String userInput = in.nextLine();
            userInput = userInput.toLowerCase();
            String[] userCommand = userInput.split(" ");

            // Using the Control class, ensure the user input is valid
            String command = Control.checkInput(userCommand[0], game.actions);
            userCommand[0] = command;

            // If the user input is invalid, display an error message, otherwise continue
            if (userCommand[0] == null) {
                System.out.println("\nInvalid command.");
            } else {

                // Based on the first command, execute the appropriate action
                switch (userCommand[0]) {
                    // If the user wants their current location
                    case "location":
                        System.out.println("\nYou are at the " + game.player.getLocation());
                        break;

                    // If the user wants to get an item from the room
                    case "get":
                        // Check if the user specified an item
                        if (userCommand.length >= 2) {
                            String item = "";

                            // Parse the item name from the user input
                            for (int i = 1; i < userCommand.length; i++) {
                                item += userCommand[i] + " ";
                            }

                            // Call the Player add method to add the item to the inventory
                            game.player.add(game.rooms, item.trim());

                        } else {
                            System.out.println("\nYou must specify an item to get. Try 'get <item name>'.");
                        }
                        break;

                    // If the user wants to drop an item from their inventory
                    case "drop":
                        // Check if the user specified an item
                        if (userCommand.length >= 2) {
                            String item = "";

                            // Parse the item name from the user input
                            for (int i = 1; i < userCommand.length; i++) {
                                item += userCommand[i] + " ";
                            }

                            // Call the Player drop method to remove the item from the inventory
                            game.player.drop(game.rooms, item.trim());

                        } else {
                            System.out.println("\nYou must specify an item to get. Try 'get <item name>'.");
                        }
                        break;

                    // If the user wants to look around the room
                    case "look":
                        // If the user wants to look at an item
                        if (userCommand.length >= 2) {
                            String item = "";

                            // Parse the item name from the user input
                            for (int i = 1; i < userCommand.length; i++) {
                                item += userCommand[i] + " ";
                            }

                            // Call the Player look method to display the item description
                            game.player.look(item.trim());
                        } else {
                            // If the user wants to look at the room
                            game.player.look(game.rooms);
                        }
                        break;

                    // If the user wants to see their inventory
                    case "inventory":
                        // Call the Player getInventory method to display the inventory
                        game.player.getInventory();
                        break;

                    // If the user wants to move to a different room
                    case "move":
                        // Check if the user specified a direction
                        if (userCommand.length == 2) {
                            // Parse direction from user input and check if it's valid using Control class
                            String direction = Control.checkInput(userCommand[1], game.actions);
                            userCommand[1] = direction;

                            // If direction is valid, call the Player move method to move to the new room
                            if (userCommand[1] == null) {
                                System.out.println("\nInvalid direction.");
                            } else {
                                game.player.move(game.rooms, userCommand[1]);
                            }

                        } else if (userCommand.length > 2) {
                            // If the user specified more than one direction, display an error message
                            System.out.println(
                                    "\n You can only move in one direction at a time. Try 'move <direction>'.");
                        } else {
                            // If the user didn't specify a direction, display an error message
                            System.out.println("\nYou must specify a direction to move. Try 'move <direction>'.");
                        }
                        break;

                    // If the user wants to talk to an NPC
                    case "talk":
                        // Check if the user specified an NPC, if not display an error message
                        if (userCommand.length >= 2) {
                            String npc = "";

                            // Parse the NPC name from the user input
                            for (int i = 1; i < userCommand.length; i++) {
                                npc += userCommand[i] + " ";
                            }

                            // Call the Player talkTo method to display the NPC's dialogue
                            game.player.talkTo(game.rooms, npc.trim().toLowerCase(), game.queenItems);
                        } else {
                            System.out
                                    .println("\nYou must specify a character to talk to. Try 'talk <character name>'.");
                        }
                        break;

                    // If the user wants to use an item
                    case "use":
                        // Check if the user specified an item, if not display an error message
                        if (userCommand.length >= 2) {
                            String item = "";

                            // Parse the item name from the user input
                            for (int i = 1; i < userCommand.length; i++) {
                                item += userCommand[i] + " ";
                            }

                            // Call the Player use method to use the item
                            game.player.use(item.trim());
                        } else {
                            System.out.println("\nPlease specify an item to use. Try 'use <item name>'");
                        }
                        break;

                    // If the user wants to get their current level
                    case "level":
                        // Call the Player getLevel method to display the player's current level
                        System.out.println("\nYou are level " + game.player.getLevel());
                        break;

                    // If the user wants to quit the game
                    case "exit":
                        // Break out of the loop and end the game
                        System.out.println("\nSorry to see you go. Goodbye!");
                        System.exit(0);
                        break;

                    // If the user wants to see the help menu
                    case "help":
                        // Call the Setup help method to display the help menu
                        String help = Setup.help();
                        System.out.println("\n" + help);
                        break;

                    // If the user wants to see their size
                    case "size":
                        // Call the Player getSize method to display the player's current size
                        String size = game.player.getSize();
                        System.out.println("\nYou are " + size + ".");
                        break;
                }

            }
        }

        // Close the scanner object
        in.close();
    }
}
