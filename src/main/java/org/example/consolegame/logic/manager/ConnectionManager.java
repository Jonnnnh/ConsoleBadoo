package org.example.consolegame.logic.manager;

import org.example.consolegame.client.Person;
import org.example.consolegame.client.RelationshipType;
import org.example.consolegame.helpers.ConsoleColors;
import org.example.consolegame.logic.facade.PersonManagementFacade;
import org.example.consolegame.logic.service.IPersonCreationService;

import java.util.List;
import java.util.Scanner;

public class ConnectionManager implements IConnectionManager {
    private final PersonManagementFacade facade;

    public ConnectionManager(PersonManagementFacade facade) {
        this.facade = facade;
    }

    public String connectPeople(Person person1, Person person2, RelationshipType type) {
        return facade.connectPeople(person1, person2, type);
    }

    public void connectMeWithSomebody(Scanner scanner, Person me) {
        System.out.print("Введите id человека: ");
        int id = scanner.nextInt();

        List<Person> allPeople = facade.getAllPeople();

        Person personToConnect = allPeople.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);

        System.out.println("Выберите тип связи: 1 - Дружба, 2 - Романтика, 3 - Не подходит");
        int relationChoice = scanner.nextInt();
        RelationshipType type = switch (relationChoice) {
            case 1 -> RelationshipType.FRIENDSHIP;
            case 2 -> RelationshipType.ROMANTIC;
            default -> RelationshipType.NOT_COMPATIBLE;
        };

        if (personToConnect != null) {
            String result = connectPeople(me, personToConnect, type);
            System.out.println(result);
        } else {
            System.out.println(ConsoleColors.RED + "Человека с указанным id нет" + ConsoleColors.RESET);
        }
    }
}
