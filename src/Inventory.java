/**
 * title: Inventory.java
 * description: Class representing the inventory of the player
 * date: Sep 16, 2022
 * @author Andrei Albu
 * @version 1.0
 * @copyright 2022 Andrei Albu
 */

// Import Java packages
import java.util.*;

/** The public class Inventory */
public class Inventory {

    /** Instance variable to store the items in the inventory */
    private Map<String, Item> inventory;

    /** Constructor for the Inventory class */
    public Inventory() {
        inventory = new HashMap<String, Item>();
    }

    /** Public method to return the number of items in the inventory */
    public int getSize() {
        return inventory.size();
    }

    /** Public method to add an item to the inventory */
    public void putItem(String name, Item item) {
        inventory.put(name, item);
    }

    /** Public method to check whether an item exists in the inventory */
    public boolean contains(String name) {
        return inventory.containsKey(name);
    }

    /** Public method to remove an item from the inventory */
    public void remove(String name) {
        inventory.remove(name);
    }

    /** Public method to return an item from the inventory */
    public Item getItem(String name) {
        return inventory.get(name);
    }

    /** Public method to return the inventory (returns the keys) */
    public Set<String> getItemsSet() {
        return inventory.keySet();
    }

}
