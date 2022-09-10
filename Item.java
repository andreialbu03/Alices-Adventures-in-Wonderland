/**
 * title: Item.java
 * description: Class that represents an item in the game
 * date: Sep 10, 2022
 * @author Andrei Albu
 * @version 1.0
 * @copyright 2022 Andrei Albu
 */

/** Primary (public) class Item */
public class Item {

    /** Instance variables to store the item's attributes */
    private String name;
    private String description;
    private String location;
    private String action;
    private String effect;

    /** Constructor for the Item class, accepts 5 parameters */
    public Item(String name, String description, String location, String action, String effect) {
        this.name = name;
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
