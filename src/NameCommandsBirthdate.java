import java.util.ArrayList;
import java.util.List;

public class NameCommandsBirthdate {

    private int id;
    private String name;
    private List<String> commands =new ArrayList<>();
    private String birthdate;

    public NameCommandsBirthdate(int id, String name, List<String> commands, String birthdate) {
        this.id = id;
        this.name = name;
        this.commands = commands;
        this.birthdate = birthdate;
    }

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
}
