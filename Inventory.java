import java.util.*;

public class Inventory {

    private static Map<String, Item> inventory;

    public Inventory() {
        inventory = new HashMap<String, Item>();
    }

    // TODO implement get number of items in inventory
    public int getSize() {
        return inventory.size();
    }

    public void putItem(String name, Item item) {
        inventory.put(name, item);
    }

    public boolean contains(String name) {
        return inventory.containsKey(name);
    }

    public void remove(String name) {
        inventory.remove(name);
    }

    public Item getItem(String name) {
        return inventory.get(name);
    }

    public Set<String> getItemsSet() {
        return inventory.keySet();
    }

}
