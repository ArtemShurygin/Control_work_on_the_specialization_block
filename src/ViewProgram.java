import java.util.ArrayList;
import java.util.List;
import java.util.*;

import Animals.*;

public class ViewProgram {


    public void run() {

        Methods m = new Methods();


        LinkedList<Animals> dogs = new LinkedList<Animals>();
        LinkedList<Animals> cats = new LinkedList<Animals>();
        LinkedList<Animals>  hamsters = new LinkedList<Animals>();

        LinkedList<Animals> horses = new LinkedList<Animals>();
        LinkedList<Animals> camels = new LinkedList<Animals>();
        LinkedList<Animals>  donkeys = new LinkedList<Animals>();


        List<List<Animals>> animalList = new ArrayList<List<Animals>>();
        animalList.add(dogs);
        animalList.add(cats);
        animalList.add(hamsters);
        animalList.add(horses);
        animalList.add(camels);
        animalList.add(donkeys);


        // Добавление животных для быстрой проверки
        // ADD
        dogs.add( new Dog(0, "dog1", new ArrayList<String>(Arrays.asList("Сидеть","Кушать","Лежать")),"20.12.2022"));
        dogs.add(new Dog(1, "dog2", new ArrayList<String>(Arrays.asList("Сидеть")),"21.12.2022"));
        dogs.add(new Dog(2, "dog3", new ArrayList<String>(Arrays.asList()),"21.12.2022"));
        dogs.add(new Dog(3, "dog4", new ArrayList<String>(Arrays.asList("Сидеть","Кушать","Лежать")),"21.12.2022"));
        cats.add(new Cat(4, "cat1", new ArrayList<String>(Arrays.asList("Сидеть","Кушать","Лежать")),"22.12.2022"));
        cats.add(new Cat(5, "cat2", new ArrayList<String>(Arrays.asList("Сидеть","Кушать","Лежать")),"23.12.2022"));
        hamsters.add(new Hamster(6, "hamster1", new ArrayList<String>(Arrays.asList("Кушать","Ко мне")),"24.12.2022"));
        horses.add(new Horse(7, "horse1", new ArrayList<String>(Arrays.asList("Кушать","Ко мне")),"25.12.2022"));
        camels.add(new Camel(8, "camel1", new ArrayList<String>(Arrays.asList("Кушать","Ко мне")),"26.12.2022"));
        donkeys.add(new Donkey(9, "donkey1", new ArrayList<String>(Arrays.asList("Кушать","Ко мне")),"27.12.2022"));

        m.updateCounter(10);
        // ADD

        while (true) {
            String cmd = prompt("\nВыберите команду:\n1 - Показать список животных\n2 - Завести животное" +
                    "\n3 - Удалить животное \n4 - Обучить животное новым командам\n5 - Удалить команду животного" +
                    "\n6 - Завершить программу\n\nВведите команду: ");

            switch (cmd) {
                case "1":
                    System.out.println("Показать список животных");
                    String  cmd1= prompt("\n1 - Все животные\n2 - Собаки\n3 - Кошки\n4 - Хомяки\n5 - Лошади" +
                            "\n6 - Верблюды\n7 - Ослы\n8 - Назад\n\nВведите команду: ");
                    switch (cmd1) {
                        case "1":
                            m.showAllAnimals(animalList);
                            break;
                        case "2":
                            m.showAnimals(dogs);
                            break;
                        case "3":
                            m.showAnimals(cats);
                            break;
                        case "4":
                            m.showAnimals(hamsters);
                            break;
                        case "5":
                            m.showAnimals(horses);
                            break;
                        case "6":
                            m.showAnimals(camels);
                            break;
                        case "7":
                            m.showAnimals(donkeys);
                            break;
                        case "8":
                            break;
                        default:
                            System.out.println("Команда введена неверно.");
                    }
                    break;
                case "2":
                    System.out.println("Завести животное");
                    String  cmd2= prompt("\nВыберите животное:\n1 - Собака\n2 - Кошка\n3 - Хомяк\n4 - Лошадь" +
                            "\n5 - Верблюд\n6 - Осел\n7 - Назад\n\nВведите команду: ");
                    switch (cmd2) {
                        case "1":
                            m.addDog(dogs);
                            break;
                        case "2":
                            m.addCat(cats);
                            break;
                        case "3":
                            m.addHamster(hamsters);
                            break;
                        case "4":
                            m.addHorse(horses);
                            break;
                        case "5":
                            m.addCamel(camels);
                            break;
                        case "6":
                            m.addDonkey(donkeys);
                            break;
                        case "7":
                            break;
                        default:
                            System.out.println("Команда введена неверно.");
                    }
                    break;
                case "3":
                    System.out.println("Удалить животное");
                    m.deleteAnimal(animalList);
                    break;
                case "4":
                    System.out.println("Обучить животное новым командам");
                    m.addCommand(animalList);
                    break;
                case "5":
                    System.out.println("Удалить команду животного");
                    m.deleteCommand(animalList);
                    break;
                case "6":
                    System.out.println("Программа завершена.");
                    System.exit(0);

                default:
                    System.out.println("Команда введена неверно.");
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
