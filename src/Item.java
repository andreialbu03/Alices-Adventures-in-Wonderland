/**
 * title: Item.java
 * description: Class that represents an item in the game
 * date: Sep 16, 2022
 * @author Andrei Albu
 * @version 1.0
 * @copyright 2022 Andrei Albu
 */

/**
 * Certain code for the Item class is adapted from: https://github.com/CRMinges/adventure
 * Accessed: Aug 30, 2022
 */

/** Primary (public) class Item */
public class Item {

    /** Instance variables to store the item's attributes */
    private String description;
    private String location;
    private String action;
    private String effect;

    /** Constructor for the Item class, accepts 5 parameters */
    public Item(String description, String location, String action, String effect) {
        this.description = description;
        this.location = location;
        this.action = action;
        this.effect = effect;
    }

    /** Public getter method that returns the item's description */
    public String getDescription() {
        return description;
    }

    /** Public getter method that returns the item's location */
    public String getLocation() {
        return location;
    }

    /** Public getter method that returns the item's action */
    public String getAction() {
        return action;
    }

    /** Public getter method that returns the item's effect */
    public String getEffect() {
        return effect;
    }
}
