/**
 * title: Game.java
 * description: The highest level class responsible for running the game
 * date: Sep 16, 2022
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
 * This program is a text-based adventure game based on the novel Alice's Adventures in Wonderland
 * by Lewis Carroll. 
 * 
 * This program is a fun game that allows the user to explore the world of Wonderland and interact
 * with the characters and items in the game. The user can play the game by typing in commands and
 * the program will respond accordingly once the ENTER key is pressed.
 * 
 * Compiling and running instructions:
 * Change to the src directory containing the source code and type the following:
 * Compile: javac Game.java
 * Run    : java Game
 * 
 */

// Import Java packages
import java.util.*;

/** Primary public class Game */
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
                            System.out.println("\nYou must specify an item to drop. Try 'drop <item name>'.");
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
