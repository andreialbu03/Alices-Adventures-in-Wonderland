public class Item {
    
    private String name;
    private String description;
    private String location;

    public Item(String name, String description, String location) {
        this.name = name;
        this.description = description;
        this.location = location;
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
}
