package org.example.consolegame.logic.manager;

import org.example.consolegame.client.Person;
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

    public String connectPeople(Person person1, Person person2) {
        return facade.connectPeople(person1, person2);
    }

    public void connectMeWithSomebody(Scanner scanner, Person me) {
        System.out.print("Введите id человека: ");
        int id = scanner.nextInt();

        List<Person> currentPersonList = facade.getAllPeople();

        Person personToConnect = currentPersonList.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);

        if (personToConnect != null) {
            String result = connectPeople(me, personToConnect);
            System.out.println(result);
        } else {
            System.out.println(ConsoleColors.RED + "Человека с указанным id нет" + ConsoleColors.RESET);
        }
    }
}
