import java.util.*;

import Animals.*;

public class Methods {
    Counter counter = new Counter();

// Обновляет счетчик при добавлении животных не через консоль

    /**
     * Обновляет счетчик при добавлении животных не через консоль
     * @param upId число, на которое увеличивается счетчик
     */
    public void updateCounter(int upId){
    counter.setCounter(counter.getCounter() + upId);
    }

    /**
     * Выводит список всех животных
     * @param animalList список всех животных
     */
    public void showAllAnimals (List<List<Animals>> animalList){
        for (List<Animals> animals : animalList) {
            for (Animals animal : animals) {
                System.out.println(animal);
            }
        }
    }

    /**
     * Выводит список выбранного класса животных
     * @param animalList список животных
     */
    public void showAnimals (LinkedList<Animals> animalList){
        for (Animals animal : animalList) {
            System.out.println("id: " + animal.getId() + ", name: " + animal.getName() +
                    ", commands: " + animal.getCommands() + ", birthdate: " +animal. getBirthdate());
        }
    }

    /**
     * Добавляет новую собаку в список собак
     * @param dogs список собак
     */
    public void addDog (LinkedList<Animals> dogs){
        NameCommandsBirthdate inf = nameCommandsBirthdate();
        if (inf != null){
            dogs.add(new Dog(inf.getId(), inf.getName(), inf.getCommands(), inf.getBirthdate()));
        }
    }

    /**
     * Добавляет новую кошку в список кошек
     * @param cats список кошек
     */
    public void addCat (LinkedList<Animals> cats){
        NameCommandsBirthdate inf = nameCommandsBirthdate();
        if (inf != null){
            cats.add(new Cat(inf.getId(), inf.getName(), inf.getCommands(), inf.getBirthdate()));
        }
    }

    /**
     * Добавляет нового хомяка в список хомяков
     * @param hamsters список хомяков
     */
    public void addHamster (LinkedList<Animals> hamsters){
        NameCommandsBirthdate inf = nameCommandsBirthdate();
        if (inf != null){
            hamsters.add(new Hamster(inf.getId(), inf.getName(), inf.getCommands(), inf.getBirthdate()));
        }
    }

    /**
     * Добавляет новую лошадь в список лошадей
     * @param horses список лошадей
     */
    public void addHorse (LinkedList<Animals> horses){
        NameCommandsBirthdate inf = nameCommandsBirthdate();
        if (inf != null){
            horses.add(new Horse(inf.getId(), inf.getName(), inf.getCommands(), inf.getBirthdate()));
        }
    }

    /**
     * Добавляет нового верблюда в список верблюдов
     * @param camels список верблюдов
     */
    public void addCamel (LinkedList<Animals> camels){
        NameCommandsBirthdate inf = nameCommandsBirthdate();
        if (inf != null){
            camels.add(new Camel(inf.getId(), inf.getName(), inf.getCommands(), inf.getBirthdate()));
        }
    }

    /**
     * Добавляет нового осла в список ослов
     * @param donkeys список ослов
     */
    public void addDonkey (LinkedList<Animals> donkeys){
        NameCommandsBirthdate inf = nameCommandsBirthdate();
        if (inf != null){
            donkeys.add(new Donkey(inf.getId(), inf.getName(), inf.getCommands(), inf.getBirthdate()));
        }
    }

    /**
     * Добавляет id, имя, команды и день рождения для животного
     * @return
     */
    public NameCommandsBirthdate nameCommandsBirthdate(){
        try {
            String name = prompt("Введите имя: ");
            if (name.isEmpty()){
                System.out.println("Имя не может быть пустым");
                return null;
            }
            List<String> commands = new ArrayList<String>();
            while (true){
                String cmd = prompt("\nВыберите команду:\n1 - Добавить команду\n2 - Завершить добавление команд\nВыберите действие: ");
                System.out.println(cmd);
                if (cmd.equals("1")) {
                    String command = prompt("Введите команду: ");
                    if (!command.isEmpty()) {
                        commands.add(command);
                        System.out.println("Команда добавлена.");
                    }
                    else
                        System.out.println("Команда не может быть пустой.");
                }

                else if (cmd.equals("2")) {
                    break;
                }
                else{
                    System.out.println("Команда введена неверно");
                }

            }
            String birthdate = prompt("Введите день рождения: ");
            if (birthdate.isEmpty()){
                System.out.println("День рождения не может быть пустым");
                return null;
            }
            int id = counter.add();
            return new NameCommandsBirthdate(id, name, commands, birthdate);
        }
        catch (Exception e) {
                System.out.println("Ошибка ввода. Действие отменено.\n" + e.getMessage());
                return null;
        }
    }

    /**
     * Ищет животное по введенному id
     * @param animalList список животных
     * @return Возвращает животное
     */
    public Animals findAnimalById (List<List<Animals>> animalList){
        try{
            int idFind = promptInt("Введите id животного: ");
            for (List<Animals> animals : animalList) {
                for (Animals animal : animals) {
                    if (animal.getId() == idFind) {
                        return animal;
                    }
                }
            }
            System.out.println("Животное не найдено");
            return null;
        }
        catch (Exception e) {
            System.out.println("Ошибка ввода. Действие отменено.\n" + e.getMessage());
            return null;
        }
    }

    /**
     * Удаляет животное по введенному id
     * @param animalList список животных
     */
    public Animals deleteAnimal (List<List<Animals>> animalList){
        try{
            int idFind = promptInt("Введите id животного: ");
            for (List<Animals> animals : animalList) {
                for (int j = 0; j < animals.size(); j++) {
                    if (animals.get(j).getId() == idFind) {
                        animals.remove(animals.get(j));
                        return null;
                    }
                }
            }
            System.out.println("Животное не найдено");
            return null;
        }
        catch (Exception e) {
            System.out.println("Ошибка ввода. Действие отменено.\n" + e.getMessage());
            return null;
        }
    }

    /**
     * Удаляет заданную команду у животного
     * @param animalList список животных
     */
    public Animals deleteCommand (List<List<Animals>> animalList){
        Animals findAnimal = findAnimalById(animalList);
        if (findAnimal != null){
            while (true){
                String cmd = prompt("\nВыберите команду:\n1 - Удалить команду\n2 - Завершить удаление команд\nВыберите действие:");
                if (cmd.equals("1")) {
                    String command = prompt("Введите команду, которую хотите удалить: ");

                    for (int  k = 0; k  <  findAnimal.getCommands().size(); k++){
                        if (findAnimal.getCommands().get(k).equals(command)){
                            findAnimal.getCommands().remove(k);
                            return null;
                        }
                    }
                    System.out.println("Команда не найдена.");
                }
                else if (cmd.equals("2")) {
                    break;
                }
                else{
                    System.out.println("Команда введена неверно");
                }
            }
        }
        return null;
    }

    /**
     * Добавляет команду животному
     * @param animalList список животных
     * @return
     */
    public Animals addCommand (List<List<Animals>> animalList){
        Animals findAnimal = findAnimalById(animalList);
        if (findAnimal != null){
            while (true){
                String cmd = prompt("\nВыберите команду:\n1 - Добавить команду\n2 - Завершить добавление команд\nВыберите действие:");
                System.out.println(cmd);
                if (cmd.equals("1")) {
                    String command = prompt("Введите команду: ");
                    if (!command.isEmpty()) {
                        findAnimal.getCommands().add(command);
                        System.out.println("Команда добавлена.");
                            }
                    else
                                System.out.println("Команда не может быть пустой.");
                        }

                        else if (cmd.equals("2")) {
                            break;
                        }
                        else{
                            System.out.println("Команда введена неверно");
                        }
                    }
                    return null;
                }
        return null;
    }




    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private int promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(in.nextLine());
    }
}
