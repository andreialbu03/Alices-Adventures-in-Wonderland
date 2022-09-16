/**
 * title: Actions.java
 * description: Class that stores the valid actions that can be performed in the game
 * date: Sep 16, 2022
 * @author Andrei Albu
 * @version 1.0
 * @copyright 2022 Andrei Albu
 */

/** The public class Actions */
public class Actions {

    /** Instance variable to keep track of valid actions */
    private String[] actions;

    /** Constructor for Actions class accepting a String array */
    public Actions(String[] actions) {
        // Initializes instance variable
        this.actions = actions;
    }

    /** Public getter method to return the valid actions */
    public String[] getActions() {
        return actions;
    }
}
