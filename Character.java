/**
 * title: Character.java
 * description: Class that represents a non-playable character (NPC) in the game
 * date: Sep 10, 2022
 * @author Andrei Albu
 * @version 1.0
 * @copyright 2022 Andrei Albu
 */

/** Primary (public) class Character */
public class Character {

    /** Instance variables storing attributes of an NPC */
    private String name;
    private String dialog;
    private String location;

    /** Constructor for the Character class, accepts 3 parameters */
    public Character(String name, String dialog, String location) {
        // Initializes instance variables
        this.name = name;
        this.dialog = dialog;
        this.location = location;
    }

    /** Public method that outputs the NPC's dialog */
    public void talk() {
        System.out.print("\n" + dialog);
    }

    // TODO remove this method
    /** Public getter method that returns the NPC's name */
    public String getName() {
        return name;
    }

    /** Public getter method that returns the NPC's location */
    public String getLocation() {
        return location;
    }

}
