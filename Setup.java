import java.util.*;
import java.io.*;

public class Setup {

    public static HashMap<String, Item> createItems() {
        try (FileReader file = new FileReader("Items.txt");
                BufferedReader br = new BufferedReader(file)) {

            HashMap<String, Item> items = new HashMap<String, Item>();
            String line = br.readLine();

            while (line != null) { // while more lines to read
                String name = line;
                name = name.toLowerCase();
                line = br.readLine();

                String location = line.trim();
                line = br.readLine();

                String description = "";

                while (!line.equals("END")) { // while br has not hit "END"
                    description = description + line + '\n';
                    line = br.readLine();
                }

                // put new items object and items name into HashMap
                items.put(name, new Item(name, description, location));
                line = br.readLine(); // move line to beginning of next
                                      // section of text
            }

            return items;

        } catch (IOException e) {
            // If the file is not found, display a message
            System.out.println("Error reading file. Please check the filename and try again.");
            return null;
        }
    }

    public static HashMap<String, Room> createRooms(HashMap<String, Item> items, HashMap<String, NPC> NPCs) {
        try (FileReader file = new FileReader("Rooms.txt");
                BufferedReader br = new BufferedReader(file)) {

            HashMap<String, Room> rooms = new HashMap<String, Room>();
            String line = br.readLine();

            while (line != null) { // while more lines to read
                String name = line.trim();

                line = br.readLine();

                String[] neighbours = line.split(",");

                for (int i = 0; i < neighbours.length; i++) {
                    neighbours[i] = neighbours[i].trim();
                }

                line = br.readLine();
                String description = "";

                while (!line.equals("END")) { // while br has not hit "END"
                    description = description + line + '\n';
                    line = br.readLine();
                }

                rooms.put(name, new Room(name, description, neighbours, items, NPCs));
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

                line = br.readLine(); // move line to beginning of next
                                      // section of text
            }

            return actions;

        } catch (IOException e) {
            // If the file is not found, display a message
            System.out.println("Error reading file. Please check the filename and try again.");
            return null;
        }
    }

    public static HashMap<String, NPC> createNPCs() {
        try (FileReader file = new FileReader("NPCs.txt");
                BufferedReader br = new BufferedReader(file)) {

            HashMap<String, NPC> NPCs = new HashMap<String, NPC>();
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

                NPCs.put(name, new NPC(name, dialog, location));
                line = br.readLine();
            }

            return NPCs;

        } catch (IOException e) {
            // If the file is not found, display a message
            System.out.println("Error reading file. Please check the filename and try again.");
            return null;
        }
    }
}
