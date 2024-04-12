package Animals;

import java.util.ArrayList;
import java.util.List;

public class Animals {
    private int id;
    private String clas;
    private String name;
    private List<String> commands =new ArrayList<>();
    private String birthdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }


    @Override
    public String toString() {

        return "id: " + id + " class: " + clas +", name: " + name + ", commands: " + commands + ", birthdate: " + birthdate;
    }
}
