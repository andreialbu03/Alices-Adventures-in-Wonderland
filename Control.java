import java.util.*;

public class Control {

    public static String checkInput(String command, HashMap<String, Actions> validActions) {

        for (String action : validActions.keySet()) {

            for (String actionAlias : validActions.get(action).getActions()) {
                if (actionAlias.equals(command)) {
                    return action;
                }
            }
        }

        return null;
    }

}
