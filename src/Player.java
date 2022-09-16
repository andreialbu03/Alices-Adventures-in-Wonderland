/**
 * title: Player.java
 * description: Class that represents the main player in the game
 * date: Sep 10, 2022
 * @author Andrei Albu
 * @version 1.0
 * @copyright 2022 Andrei Albu
 */

// Import Java packages
import java.util.*;

/** Primary (public) class Player */
public class Player {

    /** Instance variables to store the player's attributes */
    private static String location;
    private static Inventory inventory;
    private static String size;
    private static int level;
    private static HashMap<String, String> visitedRooms;

    /**
     * Constructor for the Player class, accepts the starting location as parameter
     */
    public Player(String startingLocation) {
        inventory = new Inventory();
        location = startingLocation;
        size = "normal";
        level = 0;
        visitedRooms = new HashMap<String, String>();
        visitedRooms.put(startingLocation, "You are back at the " + startingLocation);
    }

    /** Public method that moves the player to a new location */
    public void move(HashMap<String, Location> rooms, String direction) {
        // Get the current location
        Location currentRoom = rooms.get(location);
        Location nextRoom;

        // Get the neighbouring rooms based on the current location
        String[] neighbours = currentRoom.getNeighbours();

        // Based on the direction, move the player to the next room if it exists
        switch (direction) {
            // If the direction is north, try to move the player to the north room
            case "north":
                // If the north room does not exist, display an error message
                if (neighbours[0].equals("-")) {
                    System.out.println("\nYou cannot go that way.");
                } else {
                    nextRoom = rooms.get(neighbours[0]);

                    // Check whether the player is eligible to enter the room
                    if (isValidLocation(nextRoom)) {
                        // If the player is eligible, move them to the room
                        location = neighbours[0];
                        System.out.println("\nYou move north to the " + neighbours[0] + ".");

                        if (visitedRooms.containsKey(location)) {
                            // If the room already exists in the visitedRooms HashMap, display its
                            // description
                            System.out.println(visitedRooms.get(location));
                        } else {
                            // If the room does not exist in the visitedRooms HashMap, add it and display a
                            // custom description
                            visitedRooms.put(location, "You are back at the " + location);
                            System.out.println("\n" + nextRoom.getDescription());
                        }

                    } else {
                        // If the player is not eligible to enter the room, display an error message
                        System.out.println("\nYou do not meet the level or size requirements to go that way.");
                    }
                }
                break;

            // If the direction is south, try to move the player to the south room
            case "south":
                // If the south room does not exist, display an error message
                if (neighbours[1].equals("-")) {
                    System.out.println("\nYou cannot go that way.");
                } else {
                    nextRoom = rooms.get(neighbours[1]);

                    // Check whether the player is eligible to enter the room
                    if (isValidLocation(nextRoom)) {
                        // If the player is eligible, move them to the room
                        location = neighbours[1];
                        System.out.println("\nYou move south to the " + neighbours[1] + ".");

                        if (visitedRooms.containsKey(location)) {
                            // If the room already exists in the visitedRooms HashMap, display its
                            // description
                            System.out.println(visitedRooms.get(location));
                        } else {
                            // If the room does not exist in the visitedRooms HashMap, add it and display a
                            // custom description
                            visitedRooms.put(location, "You are back at the " + location);
                            System.out.println("\n" + nextRoom.getDescription());
                        }

                    } else {
                        // If the player is not eligible to enter the room, display an error message
                        System.out.println("\nYou do not meet the level or size requirements to go that way.");
                    }
                }
                break;

            // If the direction is east, try to move the player to the east room
            case "east":
                // If the east room does not exist, display an error message
                if (neighbours[2].equals("-")) {
                    System.out.println("\nYou cannot go that way.");
                } else {
                    nextRoom = rooms.get(neighbours[2]);

                    // Check whether the player is eligible to enter the room
                    if (isValidLocation(nextRoom)) {
                        // If the player is eligible, move them to the room
                        location = neighbours[2];
                        System.out.println("\nYou move east to the " + neighbours[2] + ".");

                        if (visitedRooms.containsKey(location)) {
                            // If the room already exists in the visitedRooms HashMap, display its
                            // description
                            System.out.println(visitedRooms.get(location));
                        } else {
                            // If the room does not exist in the visitedRooms HashMap, add it and display a
                            // custom description
                            visitedRooms.put(location, "You are back at the " + location);
                            System.out.println("\n" + nextRoom.getDescription());
                        }

                    } else {
                        // If the player is not eligible to enter the room, display an error message
                        System.out.println("\nYou do not meet the level or size requirements to go that way.");
                    }
                }
                break;

            // If the direction is west, try to move the player to the west room
            case "west":
                // If the west room does not exist, display an error message
                if (neighbours[3].equals("-")) {
                    System.out.println("\nYou cannot go that way.");
                } else {
                    nextRoom = rooms.get(neighbours[3]);

                    // Check whether the player is eligible to enter the room
                    if (isValidLocation(nextRoom)) {
                        // If the player is eligible, move them to the room
                        location = neighbours[3];
                        System.out.println("\nYou move west to the " + neighbours[3] + ".");

                        if (visitedRooms.containsKey(location)) {
                            // If the room already exists in the visitedRooms HashMap, display its
                            // description
                            System.out.println(visitedRooms.get(location));
                        } else {
                            // If the room does not exist in the visitedRooms HashMap, add it and display a
                            // custom description
                            visitedRooms.put(location, "You are back at the " + location);
                            System.out.println("\n" + nextRoom.getDescription());
                        }

                    } else {
                        // If the player is not eligible to enter the room, display an error message
                        System.out.println("\nYou do not meet the level or size requirements to go that way.");
                    }
                }
                break;
        }
    }

    /** Public method to add an item to the player's inventory */
    public void add(HashMap<String, Location> rooms, String item) {
        // Get the current room
        Location currentRoom = rooms.get(location);

        // Check whether the item exists in the current room
        if (currentRoom.getItems().containsKey(item)) {
            // If the item exists, add it to the player's inventory
            inventory.putItem(item, currentRoom.getItems().get(item));
            currentRoom.getItems().remove(item);

            System.out.println("\nYou picked up the " + item + " and place it in your inventory.");
        } else {
            // If the item does not exist, display an error message
            System.out.println("\nThere is no " + item + " in this room.");
        }
    }

    /** Public method to remove an item from the player's inventory */
    public void drop(HashMap<String, Location> rooms, String item) {
        // Get the current room
        Location currentRoom = rooms.get(location);

        // Check whether the item exists in the player's inventory
        if (inventory.contains(item)) {
            // If the item exists, remove it from the player's inventory
            currentRoom.getItems().put(item, inventory.getItem(item));
            inventory.remove(item);

            System.out.println("\nYou dropped the " + item + " and placed it in the room.");
        } else {
            // If the item does not exist, display an error message
            System.out.println("\nYou do not have the " + item + " in your inventory.");
        }
    }

    /** Public method to display the player's inventory */
    public void getInventory() {
        // Check whether the player's inventory is empty
        if (inventory.getSize() == 0) {
            System.out.println("\nYou have no items in your inventory.");
        } else {
            // If the player's inventory is not empty, display the items in the inventory
            System.out.println("\nYou have the following items in your inventory:");
            for (String item : inventory.getItemsSet()) {
                System.out.println("- " + item);
            }
        }
    }

    /** Public method to look at an item */
    public void look(String item) {
        // If the player has the item in their inventory, display its description, if
        // not, display an error message
        if (inventory.contains(item)) {
            System.out.println("\n" + inventory.getItem(item).getDescription());
        } else {
            System.out.println("\nYou do not have the " + item + " in your inventory.");
        }
    }

    /** Public method to look at a room */
    public void look(HashMap<String, Location> rooms) {
        // Call the rooms look method based on the current location
        rooms.get(location).look();
    }

    /** Public method to talk to an NPC */
    public void talkTo(HashMap<String, Location> rooms, String npc, HashMap<String, Item> queenItems) {
        // Get the current room
        Location currentRoom = rooms.get(location);

        // Check whether the NPC exists in the current room
        if (currentRoom.getNPCs().containsKey(npc)) {
            // If the NPC exists, call the NPC's talk method
            currentRoom.getNPCs().get(npc).talk();

            // If the NPC is the Queen, add the Queen's items to the room using a method
            if (npc.equals("queen of hearts")) {
                addQueenItemsToRoom(rooms, queenItems);
            }

        } else {
            // If the NPC does not exist, display an error message
            System.out.println("\n" + npc + " is not in this room.");
        }
    }

    /** Public method to use an item */
    public void use(String item) {
        // Check whether the item exists in the player's inventory
        if (inventory.contains(item)) {
            // Get the action that the item performs
            String action = inventory.getItem(item).getAction();

            // Based on the action, perform the action
            switch (action) {
                // If the item has the action "none", display an error message
                case "none":
                    System.out.println("\nThis item cannot be used.");
                    break;

                // If the item has the action "shrink", shrink the player
                case "shrink":
                    // Store the boolean value of whether the player has shrunk or not return by
                    // shrink()
                    boolean hasShrunk = shrink();

                    // If the player has shrunk, display the item's effect and remove it from the
                    // player's inventory
                    if (hasShrunk) {
                        System.out.println("\n" + inventory.getItem(item).getEffect());
                        inventory.remove(item);
                    } else {
                        // If the player has not shrunk, display an error message
                        System.out.println("\nYou are already the smallest size.");
                    }
                    break;

                // If the item has the action "grow", grow the player
                case "grow":
                    boolean hasGrown = grow();

                    // If the player has grown, display the item's effect and remove it from the
                    // player's inventory
                    if (hasGrown) {
                        System.out.println("\n" + inventory.getItem(item).getEffect());
                        inventory.remove(item);
                    } else {
                        // If the player has not grown, display an error message
                        System.out.println("\nYou are already the largest size.");
                    }
                    break;

                // If the item has the action "level up", level up the player
                case "level up":
                    // If the player is not in the "safe room", display an error message
                    if (!(location.equalsIgnoreCase("safe room"))) {
                        System.out.println("\nYou cannot use this item here.");
                    } else {
                        // If the player is in the "safe room", level up the player and remove the
                        // item from the player's inventory
                        levelUp();
                        System.out.println("\n" + inventory.getItem(item).getEffect());
                        System.out.println("You are now level " + level + "!");
                        inventory.remove(item);
                    }
                    break;
            }

        } else {
            // If the item does not exist in the player's inventory, display an error
            // message
            System.out.println("\nYou do not have the " + item + " in your inventory.");
        }
    }

    /** Private method to shrink the player */
    private boolean shrink() {
        // Based on the current size, either shrink the player or not
        switch (size) {
            // If the player is "large", shrink the player to "normal"
            case "large":
                size = "normal";
                return true;

            // If the player is "normal", shrink the player to "small"
            case "normal":
                size = "small";
                return true;

            // If the player is "small", do not shrink the player
            case "small":
                break;
        }

        // Return false if the player is already small
        return false;
    }

    /** Private method to grow the player */
    private boolean grow() {
        // Based on the current size, either grow the player or not
        switch (size) {
            // If the player is "small", grow the player to "normal"
            case "small":
                size = "normal";
                return true;

            // If the player is "normal", grow the player to "large"
            case "normal":
                size = "large";
                return true;

            // If the player is "large", do not grow the player
            case "large":
                break;
        }

        // Return false if the player is already large
        return false;
    }

    /** Private method to check whether a room is valid to move to */
    private boolean isValidLocation(Location nextRoom) {
        // Get the restrictions of the room
        String[] restrictions = nextRoom.getRestrictions();

        // If there are no restrictions, return true
        if (restrictions[0].equals("none")) {
            return true;
        }

        // Store the different size restrictions in an array
        String[] sizeRestriction = { "small", "normal", "large" };

        // Loop through the size restrictions
        for (String element : sizeRestriction) {
            // If the room's restriction is a size restriction, check whether the player is
            // the
            // correct size or not
            if (element.equals(restrictions[0])) {
                if (restrictions[0].equals(size)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                // Parse the level to an integer
                int levelRequirement = Integer.parseInt(restrictions[0].substring(3));

                // If the room's restriction is a level restriction, check whether the player
                // is the correct level or not
                if (restrictions[0].substring(0, 3).equals("lvl")) {
                    if (level >= levelRequirement) {
                        return true;
                    }
                }
            }
        }

        // Return false if the player does not meet the room's restrictions
        return false;
    }

    /** Private method to add the Queen's items to a room */
    private void addQueenItemsToRoom(HashMap<String, Location> rooms, HashMap<String, Item> items) {
        // Get the current room and add the Queen's items to the room
        Location currentRoom = rooms.get(location);
        currentRoom.addItem(items);

        // Remove the Queen from the room using a method
        currentRoom.removeCharacter("queen of hearts");
    }

    /** Public method to check if the player has won */
    public boolean hasWon() {
        // If the player has the 2 items required to win, return true
        if (inventory.contains("queen's staff") && inventory.contains("queen's pearl necklace")) {
            return true;
        }

        // Return false if the player does not have the items
        return false;
    }

    /** Public getter method to return the player's size */
    public String getSize() {
        return size;
    }

    /** Public getter method to return the player's location */
    public String getLocation() {
        return location;
    }

    /** Public getter method to return the player's level */
    public int getLevel() {
        return level;
    }

    /** Private method to increase the player's level */
    private void levelUp() {
        level++;
    }

}
