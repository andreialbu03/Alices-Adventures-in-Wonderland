import java.util.*;
import java.io.*;

public class Setup {

    public static HashMap<String, Item> createItems() {
        try (FileReader file = new FileReader("Items.txt");
                BufferedReader br = new BufferedReader(file)) {

            HashMap<String, Item> items = new HashMap<String, Item>();
            String line = br.readLine();

            while (line != null) { // while more lines to read

                boolean isQueenItem = false;

                String name = line;
                name = name.toLowerCase();
                line = br.readLine();

                if (name.substring(0, 5).equals("queen")) {
                    isQueenItem = true;
                }

                String location = line.trim();
                line = br.readLine();

                String action = line.trim();
                line = br.readLine();

                String effect = line.trim();
                line = br.readLine();

                String description = "";

                while (!line.equals("END")) { // while br has not hit "END"
                    description = description + line + '\n';
                    line = br.readLine();
                }

                // if (!isQueenItem) {
                //     // put new items object and items name into HashMap
                //     items.put(name, new Item(name, description, location, action, effect));
                // }

                // put new items object and items name into HashMap
                items.put(name, new Item(name, description, location, action, effect));
                
                line = br.readLine(); // move line to beginning of next
            }

            return items;

        } catch (IOException e) {
            // If the file is not found, display a message
            System.out.println("Error reading file. Please check the filename and try again.");
            return null;
        }
    }

    public static HashMap<String, Location> createRooms(HashMap<String, Item> items, HashMap<String, Character> NPCs) {
        try (FileReader file = new FileReader("Locations.txt");
                BufferedReader br = new BufferedReader(file)) {

            HashMap<String, Location> rooms = new HashMap<String, Location>();
            String line = br.readLine();

            while (line != null) { // while more lines to read
                String name = line.trim();

                line = br.readLine();

                String[] neighbours = line.split(",");

                for (int i = 0; i < neighbours.length; i++) {
                    neighbours[i] = neighbours[i].trim();
                }

                line = br.readLine();

                String[] restrictions = line.split(" ");

                for (int i = 0; i < restrictions.length; i++) {
                    restrictions[i] = restrictions[i].trim();
                }

                line = br.readLine();

                String description = "";

                while (!line.equals("END")) { // while br has not hit "END"
                    description = description + line + '\n';
                    line = br.readLine();
                }

                rooms.put(name, new Location(name, description, neighbours, items, NPCs, restrictions));
                line = br.readLine();
            }

            return rooms;

        } catch (IOException e) {
            // If the file is not found, display a message
            System.out.println("Error reading file. Please check the filename and try again.");
            return null;
        }
    }

    public static HashMap<String, Actions> createActions() {
        try (FileReader file = new FileReader("Actions.txt");
                BufferedReader br = new BufferedReader(file)) {

            HashMap<String, Actions> actions = new HashMap<String, Actions>();
            String line = br.readLine();

            while (line != null) { // while more lines to read
                String[] actionsList = line.split(",");
                String mainAction = actionsList[0];

                // put new items object and items name into HashMap
                actions.put(mainAction, new Actions(actionsList));

                line = br.readLine(); 
            }

            return actions;

        } catch (IOException e) {
            // If the file is not found, display a message
            System.out.println("Error reading file. Please check the filename and try again.");
            return null;
        }
    }

    public static HashMap<String, Character> createNPCs() {
        try (FileReader file = new FileReader("Characters.txt");
                BufferedReader br = new BufferedReader(file)) {

            HashMap<String, Character> NPCs = new HashMap<String, Character>();
            String line = br.readLine();

            while (line != null) { // while more lines to read
                String name = line.trim().toLowerCase();
                line = br.readLine();

                String location = line.trim();
                line = br.readLine();

                String dialog = "";

                while (!line.equals("END")) { // while br has not hit "END"
                    dialog = dialog + line + '\n';
                    line = br.readLine();
                }

                NPCs.put(name, new Character(name, dialog, location));
                line = br.readLine();
            }

            return NPCs;

        } catch (IOException e) {
            // If the file is not found, display a message
            System.out.println("Error reading file. Please check the filename and try again.");
            return null;
        }
    }

    public static String gameInstructions() {
        try (FileReader file = new FileReader("Instructions.txt");
                BufferedReader br = new BufferedReader(file)) {

            String line = br.readLine();
            String instructions = "";

            while (line != null) { // while more lines to read
                instructions = instructions + line + '\n';
                line = br.readLine();
            }

            return instructions;

        } catch (IOException e) {
            // If the file is not found, display a message
            System.out.println("Error reading file. Please check the filename and try again.");
            return null;
        }
    }

    public static String help() {
        try (FileReader file = new FileReader("Actions.txt");
                BufferedReader br = new BufferedReader(file)) {

            String line = br.readLine();
            String help = "The following are the commands that are available to you:\n\n";

            while (line != null) { // while more lines to read
                help = help + line + '\n';
                line = br.readLine();
            }
            help = help + "\nAll commands on the same line act as synonyms and all are are case insensitive.\n";
            return help;

        } catch (IOException e) {
            // If the file is not found, display a message
            System.out.println("Error reading file. Please check the filename and try again.");
            return null;
        }
    }

    public static String win () {
        try (FileReader file = new FileReader("Win.txt");
                BufferedReader br = new BufferedReader(file)) {

            String line = br.readLine();
            String win = "";

            while (line != null) { // while more lines to read
                win = win + line + '\n';
                line = br.readLine();
            }

            return win;

        } catch (IOException e) {
            // If the file is not found, display a message
            System.out.println("Error reading file. Please check the filename and try again.");
            return null;
        }
    }
}
