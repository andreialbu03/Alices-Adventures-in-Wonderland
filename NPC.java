import java.util.*;

public class NPC {

    private String name;
    private String dialog;
    private String location;

    public NPC(String name, String dialog, String location) {
        this.name = name;
        this.dialog = dialog;
        this.location = location;
    }

    public void talk() {
        System.out.print("\n" + dialog);
    }

    public String getName() {
        return name;
    }

    public String getDialog() {
        return dialog;
    }

    public String getLocation() {
        return location;
    }

}
