package Animals;
import java.util.List;

public class Horse extends PackAnimals {
    private String clas = "Лошадь";

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public Horse(int id, String name, List<String> commands, String birthdate) {
        this.setId(id);
        this.setName(name);
        this.setCommands(commands);
        this.setBirthdate(birthdate);
    }


    @Override
    public String toString() {
        return "id: " + getId() + ", class: " + clas +", name: " + getName() + ", commands: " + getCommands() + ", birthdate: " + getBirthdate();
    }
}
