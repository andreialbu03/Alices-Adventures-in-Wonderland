import java.util.*;

// TODO change voicelines of character depending on situations?
// doorknob still says alice is too big even after she shrinks

public class Game {

    private Player player;
    private HashMap<String, Item> items;
    private HashMap<String, Character> NPCs;
    private HashMap<String, Location> rooms;
    private HashMap<String, Actions> actions;
    private HashMap<String, Item> queenItems;

    public Game() {
        String instructions = Setup.gameInstructions();
        System.out.println(instructions);

        this.player = new Player("Queen's Palace");
        this.items = Setup.createItems();
        this.NPCs = Setup.createNPCs();
        this.actions = Setup.createActions();
        this.queenItems = new HashMap<String, Item>();

        HashMap<String, Item> dummy = new HashMap<String, Item>();
        dummy.putAll(items);

        for (Map.Entry<String, Item> entry : dummy.entrySet()) {
            String name = entry.getKey();
            Item item = entry.getValue();

            if (name.substring(0, 5).equals("queen")) {
                this.queenItems.put(name, item);
                this.items.remove(name);
            }
        }
        this.rooms = Setup.createRooms(items, NPCs);
    }

    public static void main(String[] args) {
        Game game = new Game();

        Scanner in = new Scanner(System.in);

        String startingLoc = game.player.getLocation();
        System.out.println(game.rooms.get(startingLoc).getDescription());

        while (true) {

            // Check if player was won (inventory contains queen's staff and necklace)
            if (game.player.hasWon()) {
                String win = Setup.win();
                System.out.println("\n" + win);
                break;
            }

            String userInput = in.nextLine();
            userInput = userInput.toLowerCase();
            String[] userCommand = userInput.split(" ");

            String command = Control.checkInput(userCommand[0], game.actions);
            userCommand[0] = command;

            if (userCommand[0] == null) {
                System.out.println("\nInvalid command.");
            } else {
                switch (userCommand[0]) {
                    case "location":
                        System.out.println("\nYou are at the " + game.player.getLocation());
                        break;

                    case "get":
                        if (userCommand.length >= 2) {
                            String item = "";

                            for (int i = 1; i < userCommand.length; i++) {
                                item += userCommand[i] + " ";
                            }
                            game.player.add(game.rooms, item.trim());

                        } else {
                            System.out.println("\nYou must specify an item to get. Try 'get <item name>'.");
                        }
                        break;

                    case "drop":
                        if (userCommand.length >= 2) {
                            String item = "";

                            for (int i = 1; i < userCommand.length; i++) {
                                item += userCommand[i] + " ";
                            }
                            game.player.drop(game.rooms, item.trim());

                        } else {
                            System.out.println("\nYou must specify an item to get. Try 'get <item name>'.");
                        }
                        break;

                    case "look":
                        // User want to look at an item
                        if (userCommand.length >= 2) {
                            String item = "";

                            for (int i = 1; i < userCommand.length; i++) {
                                item += userCommand[i] + " ";
                            }

                            game.player.look(item.trim());
                        } else {
                            // User wants to look at the room
                            game.player.look(game.rooms);
                        }
                        break;

                    case "inventory":
                        game.player.getInventory();
                        break;

                    case "move":
                        if (userCommand.length == 2) {
                            String direction = Control.checkInput(userCommand[1], game.actions);
                            userCommand[1] = direction;

                            if (userCommand[1] == null) {
                                System.out.println("\nInvalid direction.");
                            } else {
                                game.player.move(game.rooms, userCommand[1]);
                            }
                        } else if (userCommand.length > 2) {
                            System.out.println(
                                    "\n You can only move in one direction at a time. Try 'move <direction>'.");
                        } else {
                            System.out.println("\nYou must specify a direction to move. Try 'move <direction>'.");
                        }
                        break;

                    case "talk":
                        // User want to look at an item
                        if (userCommand.length >= 2) {
                            String npc = "";

                            for (int i = 1; i < userCommand.length; i++) {
                                npc += userCommand[i] + " ";
                            }

                            game.player.talkTo(game.rooms, npc.trim().toLowerCase(), game.queenItems);
                        } else {
                            System.out
                                    .println("\nYou must specify a character to talk to. Try 'talk <character name>'.");
                        }
                        break;

                    case "use":
                        // User want to look at an item
                        if (userCommand.length >= 2) {
                            String item = "";

                            for (int i = 1; i < userCommand.length; i++) {
                                item += userCommand[i] + " ";
                            }

                            game.player.use(item.trim());
                        } else {
                            System.out.println("\nPlease specify an item to use. Try 'use <item name>'");
                        }
                        break;

                    case "level":
                        System.out.println("\nYou are level " + game.player.getLevel());
                        break;

                    case "exit":
                        System.out.println("\nSorry to see you go. Goodbye!");
                        System.exit(0);
                        break;
                    
                    case "help":
                        String help = Setup.help();
                        System.out.println("\n" + help);
                        break;
                }

            }
        }

        in.close();
    }
}
