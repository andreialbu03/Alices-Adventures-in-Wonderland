/**
 * title: Character.java
 * description: Class that represents a non-playable character (NPC) in the game
 * date: Sep 16, 2022
 * @author Andrei Albu
 * @version 1.0
 * @copyright 2022 Andrei Albu
 */

/** The public class Character */
public class Character {

    /** Instance variables storing attributes of an NPC */
    private String dialogue;
    private String location;

    /** Constructor for the Character class, accepts 3 parameters */
    public Character(String dialog, String location) {
        // Initializes instance variables
        this.dialogue = dialog;
        this.location = location;
    }

    /** Public method that outputs the NPC's dialog */
    public void talk() {
        System.out.print("\n" + dialogue);
    }

    /** Public getter method that returns the NPC's location */
    public String getLocation() {
        return location;
    }
}
