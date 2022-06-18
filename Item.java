public class Item {
    
    private String name;
    private String description;
    private String location;
    private String action;
    private String effect;

    public Item(String name, String description, String location, String action, String effect) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.action = action;
        this.effect = effect;
    }

    public void inspect() {
        System.out.println(description);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getAction() {
        return action;
    }

    public String getEffect() {
        return effect;
    }
}
