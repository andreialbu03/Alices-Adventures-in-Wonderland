import java.util.*;

public class Player {

    private static String location;
    private static Map<String, Item> inventory;

    public Player(String startingLocation) {
        inventory = new HashMap<String, Item>();
        // location = "Bright orange hallway";
        location = startingLocation;
    }

    public void move(HashMap<String, Room> rooms, String direction) {
        Room currentRoom = rooms.get(location);

        String[] neighbours = currentRoom.getNeighbours();

        switch (direction) {
            case "north":
                if (neighbours[0].equals("-")) {
                    System.out.println("\nYou cannot go that way.");
                } else {
                    location = neighbours[0];
                    System.out.println("\nYou move north to the " + neighbours[0] + ".");
                }
                break;

            case "south":
                if (neighbours[1].equals("-")) {
                    System.out.println("\nYou cannot go that way.");
                } else {
                    location = neighbours[1];
                    System.out.println("\nYou move south to the " + neighbours[1] + ".");
                }
                break;
            
            case "east":
                if (neighbours[2].equals("-")) {
                    System.out.println("\nYou cannot go that way.");
                } else {
                    location = neighbours[2];
                    System.out.println("\nYou move east to the " + neighbours[2] + ".");
                }
                break;

            case "west":
                if (neighbours[3].equals("-")) {
                    System.out.println("\nYou cannot go that way.");
                } else {
                    location = neighbours[3];
                    System.out.println("\nYou move west to the " + neighbours[3] + ".");
                }
                break;
        }

    }

    // TODO
    public void add(HashMap<String, Room> rooms, String item) {
        Room currentRoom = rooms.get(location);

        if (currentRoom.getItems().containsKey(item)) {
            inventory.put(item, currentRoom.getItems().get(item));
            currentRoom.getItems().remove(item);

            System.out.println("\nYou picked up the " + item + " and places it in your inventory.");
        } else {
            System.out.println("\nThere is no " + item + " in this room.");
        }
    }

    // TODO
    public void drop(HashMap<String, Room> rooms, String item) {
        Room currentRoom = rooms.get(location);

        if (inventory.containsKey(item)) {
            currentRoom.getItems().put(item, inventory.get(item));
            inventory.remove(item);

            System.out.println("\nYou dropped the " + item + " and placed it in the room.");
        } else {
            System.out.println("\nYou do not have the " + item + " in your inventory.");
        }
    }

    public String getLocation() {
        return location;
    }

    public void getInventory() {
        if (inventory.size() == 0) {
            System.out.println("\nYou have no items in your inventory.");
        } else {
            System.out.println("\nYou have the following items in your inventory:");
            for (String item : inventory.keySet()) {
                System.out.println("- " + item);
            }
        }
    }

    public void look(String item) {
        if (inventory.containsKey(item)) {
            System.out.println("\n" + inventory.get(item).getDescription());
        } else {
            System.out.println("\nYou do not have the " + item + " in your inventory.");
        }
    }

    public void look(HashMap<String, Room> rooms) {
        rooms.get(location).look();
    }

    public void talkTo(HashMap<String, Room> rooms, String npc) {
        Room currentRoom = rooms.get(location);

        if (currentRoom.getNPCs().containsKey(npc)) {
            currentRoom.getNPCs().get(npc).talk();
        } else {
            System.out.println("\n" + npc + " is not in this room.");
        }
    }

}
