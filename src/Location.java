/**
 * title: Location.java
 * description: Class that represents a location in the game
 * date: Sep 10, 2022
 * @author Andrei Albu
 * @version 1.0
 * @copyright 2022 Andrei Albu
 */

/**
 * Certain code for the Location class is adapted from: https://github.com/CRMinges/adventure
 * Accessed: Aug 29, 2022
 */

// Import Java packages
import java.util.*;

/** Primary (public) class Location */
public class Location {

	/** Instance variables storing a location's attributes */
	private String name;
	private String[] neighbours;
	private String description;
	private String[] restrictions;
	private HashMap<String, Item> items = new HashMap<String, Item>();
	private HashMap<String, Character> NPCs = new HashMap<String, Character>();

	/** Constructor for the Location class, accepts 6 parameters */
	public Location(String name, String description, String[] neighbours, HashMap<String, Item> items,
			HashMap<String, Character> NPCs, String[] restrictions) {
		this.name = name;
		this.description = description;
		this.neighbours = neighbours;
		this.restrictions = restrictions;

		// Calls the respective methods to add items and NPCs to the location
		populateItems(items);
		populateNPCs(NPCs);
	}

	/** Private method to add items to the room */
	private void populateItems(HashMap<String, Item> items) {
		// Iterate through items HashMap
		for (Map.Entry<String, Item> elt : items.entrySet()) {
			// If the item's location matches the room's name, put it in the room
			if (elt.getValue().getLocation().equals(name)) {
				this.items.put(elt.getKey(), elt.getValue());
			}
		}
	}

	/** Private method to add NPCs to the room */
	private void populateNPCs(HashMap<String, Character> NPCs) {
		// Iterate through NPCs HashMap
		for (Map.Entry<String, Character> elt : NPCs.entrySet()) {
			// If NPC's location matches room's name, put it in the room
			if (elt.getValue().getLocation().equals(name)) {
				this.NPCs.put(elt.getKey(), elt.getValue());
			}
		}
	}

	/**
	 * Public method that displays the room's description, its neighbouring rooms,
	 * and the items and NPCs found in the room
	 */
	public void look() {
		// Output room description
		System.out.println("\n" + description);

		// Output neighbouring rooms
		System.out.println("Can go to the ");

		// If "-" does not appear, player can exit in that direction
		if (!neighbours[0].equals("-")) {
			System.out.print("NORTH, ");
		}

		if (!neighbours[1].equals("-")) {
			System.out.print("SOUTH, ");
		}

		if (!neighbours[2].equals("-")) {
			System.out.print("EAST, ");
		}

		if (!neighbours[3].equals("-")) {
			System.out.print("WEST");
		}

		System.out.println();
		System.out.println();

		// If no items in the room, output a message, if there are, output them
		if (items.isEmpty()) {
			System.out.println("No items in room, sorry.");
		} else {
			int counter = 0;

			// Iterate through items HashMap and output each item
			for (Map.Entry<String, Item> elt : items.entrySet()) {
				System.out.print(elt.getKey() + ", ");
				counter++;
			}

			// Make sure the output is grammatically correct based on number of items
			if (counter == 1) {
				System.out.println("is in the room.");
			} else {
				System.out.println("are in the room.");
			}
		}

		// If no NPCs in the room, output a message, if there are, output them
		if (NPCs.isEmpty()) {
			System.out.println("\nThere is no one to talk to in this room.");
		} else {
			System.out.print("\nYou can talk to ");

			// Iterate through NPCs HashMap and output each NPC
			for (Map.Entry<String, Character> elt : NPCs.entrySet()) { // iterate
				System.out.print(elt.getKey() + ", ");
			}

			System.out.println();
		}

	}

	/** Public getter method to return neighbouring rooms */
	public String[] getNeighbours() {
		return neighbours;
	}

	/** Public getter method to return items in the room */
	public HashMap<String, Item> getItems() {
		return items;
	}

	/** Public getter method to return the room's description */
	public String getDescription() {
		return description;
	}

	/** Public getter method to return NPCs in the room */
	public HashMap<String, Character> getNPCs() {
		return NPCs;
	}

	/** Public getter method to return the room's restrictions */
	public String[] getRestrictions() {
		return restrictions;
	}

	/** Public method to add an item to the room */
	public void addItem(HashMap<String, Item> items) {
		// Iterate through items HashMap and add each item to the room
		for (Map.Entry<String, Item> name : items.entrySet()) {
			this.items.put(name.getKey(), name.getValue());
		}
	}

	/** Public method to remove an NPC from the room */
	public void removeCharacter(String name) {
		NPCs.remove(name);
	}

}
