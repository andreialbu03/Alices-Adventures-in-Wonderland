import java.util.*;

public class Player {

    private static String location;
    private static Inventory inventory;
    // sizes are large, normal, small
    private static String size;
    private static int level;
    private static HashMap<String, String> visitedRooms;

    public Player(String startingLocation) {
        inventory = new Inventory();
        location = startingLocation;
        size = "normal";
        level = 0;
        visitedRooms = new HashMap<String, String>();
        visitedRooms.put(startingLocation, "You are back at the " + startingLocation);
    }

    public void move(HashMap<String, Location> rooms, String direction) {
        Location currentRoom = rooms.get(location);
        Location nextRoom;

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
                        System.out.println("\nYou do not meet the level or size requirements to go that way.");
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
                        System.out.println("\nYou do not meet the level or size requirements to go that way.");
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
                        System.out.println("\nYou do not meet the level or size requirements to go that way.");
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
                        System.out.println("\nYou do not meet the level or size requirements to go that way.");
                    }

                }
                break;
        }

    }

    // TODO
    public void add(HashMap<String, Location> rooms, String item) {
        Location currentRoom = rooms.get(location);

        if (currentRoom.getItems().containsKey(item)) {
            inventory.putItem(item, currentRoom.getItems().get(item));
            currentRoom.getItems().remove(item);

            System.out.println("\nYou picked up the " + item + " and places it in your inventory.");
        } else {
            System.out.println("\nThere is no " + item + " in this room.");
        }
    }

    // TODO
    public void drop(HashMap<String, Location> rooms, String item) {
        Location currentRoom = rooms.get(location);

        if (inventory.contains(item)) {
            currentRoom.getItems().put(item, inventory.getItem(item));
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
        if (inventory.getSize() == 0) {
            System.out.println("\nYou have no items in your inventory.");
        } else {
            System.out.println("\nYou have the following items in your inventory:");
            for (String item : inventory.getItemsSet()) {
                System.out.println("- " + item);
            }
        }
    }

    public void look(String item) {
        if (inventory.contains(item)) {
            System.out.println("\n" + inventory.getItem(item).getDescription());
        } else {
            System.out.println("\nYou do not have the " + item + " in your inventory.");
        }
    }

    public void look(HashMap<String, Location> rooms) {
        rooms.get(location).look();
    }

    public void talkTo(HashMap<String, Location> rooms, String npc, HashMap<String, Item> queenItems) {
        Location currentRoom = rooms.get(location);

        if (currentRoom.getNPCs().containsKey(npc)) {
            currentRoom.getNPCs().get(npc).talk();

            if (npc.equals("queen of hearts")) {
                addQueenItemsToRoom(rooms, queenItems);
            }

        } else {
            System.out.println("\n" + npc + " is not in this room.");
        }
    }

    public void use(String item) {
        if (inventory.contains(item)) {
            String action = inventory.getItem(item).getAction();

            switch (action) {
                case "none":
                    System.out.println("\nThis item cannot be used.");
                    break;

                case "shrink":
                    shrink();
                    System.out.println("\n" + inventory.getItem(item).getEffect());
                    inventory.remove(item);
                    break;

                case "grow":
                    grow();
                    System.out.println("\n" + inventory.getItem(item).getEffect());
                    inventory.remove(item);
                    break;

                case "level up":
                    if (!(location.equalsIgnoreCase("safe room"))) {
                        System.out.println("\nYou cannot use this item here.");
                    } else {
                        levelUp();
                        System.out.println("\n" + inventory.getItem(item).getEffect());
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

    private boolean isValidLocation(Location nextRoom) {
        String[] restrictions = nextRoom.getRestrictions();

        if (restrictions[0].equals("none")) {
            return true;
        }

        String[] sizeRestriction = { "small", "normal", "large" };

        for (String element : sizeRestriction) {
            if (element.equals(restrictions[0])) {
                if (restrictions[0].equals(size)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                int levelRequirement = Integer.parseInt(restrictions[0].substring(3));

                if (restrictions[0].substring(0, 3).equals("lvl")) {
                    if (level >= levelRequirement) {
                        return true;
                    }
                }
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

    private void addQueenItemsToRoom(HashMap<String, Location> rooms, HashMap<String, Item> items) {
        
        Location currentRoom = rooms.get(location);
        currentRoom.addItem(items);
        currentRoom.removeCharacter("queen of hearts");
    }

    public boolean hasWon() {
        if (inventory.contains("queen's staff") && inventory.contains("queen's pearl necklace")) {
            return true;
        }
        return false;
    }

}
