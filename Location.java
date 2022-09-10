import java.util.*;

public class Location {
	private String name;
	private String[] neighbours;
	private String description;
	private String[] restrictions;
	private HashMap<String, Item> items = new HashMap<String, Item>();
	private HashMap<String, Character> NPCs = new HashMap<String, Character>();

	public Location(String name, String description, String[] neighbours, HashMap<String, Item> items, HashMap<String, Character> NPCs, String[] restrictions) {
		this.name = name;
		this.description = description;
		this.neighbours = neighbours;
		this.restrictions = restrictions;

		populateItems(items);
		populateNPCs(NPCs);
	}

	private void populateItems(HashMap<String, Item> items) {
		for (Map.Entry<String, Item> elt : items.entrySet()) { // iterate through collection
			// if items location matches rooms name...
			if (elt.getValue().getLocation().equals(name)) {
				// ...put item in room
				this.items.put(elt.getKey(), elt.getValue());
			}
		}
	}

	private void populateNPCs(HashMap<String, Character> NPCs) {
		for (Map.Entry<String, Character> elt : NPCs.entrySet()) { // iterate through collection
			// if items location matches rooms name...
			if (elt.getValue().getLocation().equals(name)) {
				// ...put item in room
				this.NPCs.put(elt.getKey(), elt.getValue());
			}
		}
	}

	/**
	 * Method that is meant to print out a the rooms short description, its
	 * neighbors,
	 * and any items in the room at the time.
	 */
	public void look() {
		System.out.println("\n" + description);

		System.out.println("Can exit to the ");
		// traverse neighbors array
		if (!neighbours[0].equals("-")) { // if there is spot to north
			System.out.print("NORTH, ");
		}

		if (!neighbours[1].equals("-")) { // if there is spot to south
			System.out.print("SOUTH, ");
		}

		if (!neighbours[2].equals("-")) { // if there is spot to east
			System.out.print("EAST, ");
		}

		if (!neighbours[3].equals("-")) { // if there is spot to west
			System.out.print("WEST, ");
		}

		System.out.println();
		System.out.println();

		if (items.isEmpty()) { // if collection of items in room is empty
			System.out.println("No items in room, sorry.");
		} else { // else, items in room, print them out
			int counter = 0;
			for (Map.Entry<String, Item> elt : items.entrySet()) { // iterate
				System.out.print(elt.getKey() + ", ");
				counter++;
			}

			if (counter == 1) {
				System.out.println("is in the room.");
			} else {
				System.out.println("are in the room.");
			}
		}

		if (NPCs.isEmpty()) {
			System.out.println("\nThere is no one to talk to in this room.");
		} else {
			System.out.print("\nYou can talk to ");
			for (Map.Entry<String, Character> elt : NPCs.entrySet()) { // iterate
				System.out.print(elt.getKey() + ", ");
			}
			System.out.println();
		}

	}

	/**
	 * Getter method that returns an array of string representing the rooms
	 * neighbors.
	 * 
	 * @return
	 *         Array of names of the rooms that connect to the current room
	 */
	public String[] getNeighbours() {
		return neighbours;
	}

	/**
	 * Getter method that returns rooms name.
	 * 
	 * @return
	 *         String represnting rooms name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter method that returns collection of items in room.
	 * 
	 * @return
	 *         HashMap representing items in room
	 */
	public HashMap<String, Item> getItems() {
		return items;
	}

	/**
	 * Getter method that returns rooms description.
	 * 
	 * @return
	 *         String representation of rooms description
	 */
	public String getDescription() {
		return description;
	}

	public HashMap<String, Character> getNPCs() {
		return NPCs;
	}

	public String[] getRestrictions() {
		return restrictions;
	}

	public void addItem(HashMap<String, Item> items) {
		for (Map.Entry<String, Item> name : items.entrySet()) {
			this.items.put(name.getKey(), name.getValue());
		}
	}

	public void removeCharacter(String name) {
		this.NPCs.remove(name);
	}

}
