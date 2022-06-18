import java.util.*;

public class Player {

    private static String location;
    private static Map<String, Item> inventory;
    // sizes are large, normal, small
    private static String size;
    private static int level;
    private static HashMap<String, String> visitedRooms;

    public Player(String startingLocation) {
        inventory = new HashMap<String, Item>();
        // location = "Bright orange hallway";
        location = startingLocation;
        size = "normal";
        level = 0;
        visitedRooms = new HashMap<String, String>();
        visitedRooms.put(startingLocation, "You are back at the " + startingLocation);
    }

    public void move(HashMap<String, Room> rooms, String direction) {
        Room currentRoom = rooms.get(location);
        Room nextRoom;

        String[] neighbours = currentRoom.getNeighbours();

        switch (direction) {
            case "north":
                if (neighbours[0].equals("-")) {
                    System.out.println("\nYou cannot go that way.");
                } else {
                    nextRoom = rooms.get(neighbours[0]);

                    if (isValidLocation(nextRoom)) {
                        location = neighbours[0];
                        System.out.println("\nYou move north to the " + neighbours[0] + ".");

                        if (visitedRooms.containsKey(location)) {
                            System.out.println(visitedRooms.get(location));
                        } else {
                            visitedRooms.put("\n" + location, "You are back at the " + location);
                            System.out.println("\n" + nextRoom.getDescription());
                        }
                        
                    } else {
                        System.out.println("\nYou do not meet the requirements to go that way.");
                    }
                    
                }
                break;

            case "south":
                if (neighbours[1].equals("-")) {
                    System.out.println("\nYou cannot go that way.");
                } else {
                    nextRoom = rooms.get(neighbours[1]);

                    if (isValidLocation(nextRoom)) {
                        location = neighbours[1];
                        System.out.println("\nYou move south to the " + neighbours[1] + ".");

                        if (visitedRooms.containsKey(location)) {
                            System.out.println(visitedRooms.get(location));
                        } else {
                            visitedRooms.put("\n" + location, "You are back at the " + location);
                            System.out.println("\n" + nextRoom.getDescription());
                        }
                        
                    } else {
                        System.out.println("\nYou do not meet the requirements to go that way.");
                    }
                    
                }
                break;

            case "east":
                if (neighbours[2].equals("-")) {
                    System.out.println("\nYou cannot go that way.");
                } else {
                    nextRoom = rooms.get(neighbours[2]);

                    if (isValidLocation(nextRoom)) {
                        location = neighbours[2];
                        System.out.println("\nYou move south to the " + neighbours[2] + ".");

                        if (visitedRooms.containsKey(location)) {
                            System.out.println(visitedRooms.get(location));
                        } else {
                            visitedRooms.put("\n" + location, "You are back at the " + location);
                            System.out.println("\n" + nextRoom.getDescription());
                        }
                        
                    } else {
                        System.out.println("\nYou do not meet the requirements to go that way.");
                    }
                    
                }
                break;

            case "west":
                if (neighbours[3].equals("-")) {
                    System.out.println("\nYou cannot go that way.");
                } else {
                    nextRoom = rooms.get(neighbours[3]);

                    if (isValidLocation(nextRoom)) {
                        location = neighbours[3];
                        System.out.println("\nYou move south to the " + neighbours[3] + ".");

                        if (visitedRooms.containsKey(location)) {
                            System.out.println(visitedRooms.get(location));
                        } else {
                            visitedRooms.put("\n" + location, "You are back at the " + location);
                            System.out.println("\n" + nextRoom.getDescription());
                        }
                        
                    } else {
                        System.out.println("\nYou do not meet the requirements to go that way.");
                    }
                    
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

    public void use(String item) {
        if (inventory.containsKey(item)) {
            String action = inventory.get(item).getAction();
            
            switch (action) {
                case "none":
                    System.out.println("\nThis item cannot be used.");
                    break;

                case "shrink":
                    shrink();
                    System.out.println("\n" + inventory.get(item).getEffect());
                    inventory.remove(item);
                    break;

                case "grow":
                    grow();
                    System.out.println("\n" + inventory.get(item).getEffect());
                    inventory.remove(item);
                    break;

                case "level up":
                    if (!(location.equalsIgnoreCase("safe room"))) {
                        System.out.println("\nYou cannot use this item here.");
                    } else {
                        levelUp();
                        System.out.println("\n" + inventory.get(item).getEffect());
                        System.out.println("You are now level " + level + "!");
                        inventory.remove(item);
                    }
                    break;
            }

        } else {
            System.out.println("\nYou do not have the " + item + " in your inventory.");
        }
    }

    public void shrink() {
        switch (size) {
            case "large":
                size = "normal";
                break;

            case "normal":
                size = "small";
                break;

            case "small":
                break;
        }
    }

    public void grow() {
        switch (size) {
            case "small":
                size = "normal";
                break;

            case "normal":
                size = "large";
                break;

            case "large":
                break;
        }
    }

    private boolean isValidLocation(Room nextRoom) {
        String[] restrictions = nextRoom.getRestrictions();

        if (restrictions[0].equals("none")) {
            return true;
        }

        for (int i = 0; i < restrictions.length; i++) {
            if (restrictions[i].equals(size)) {
                return true;
            }
        }
        return false;
    }

    public int getLevel() {
        return level;
    }

    private void levelUp() {
        level++;
    }

}
