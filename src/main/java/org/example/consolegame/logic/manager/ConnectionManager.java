package org.example.consolegame.logic.manager;

import org.example.consolegame.client.Person;
import org.example.consolegame.helpers.ConsoleColors;
import org.example.consolegame.logic.service.PersonService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectionManager implements IConnectionManager {
    private final PersonService personService;

    public ConnectionManager(PersonService personService) {
        this.personService = personService;
    }

    public String connectPeople(Person person1, Person person2) {
        return personService.connectPeople(person1, person2);
    }

    public void connectMeWithSomebody(Scanner scanner, Person me) {
        System.out.print("Введите id человека: ");
        int id = scanner.nextInt();

        List<Person> currentPersonList = personService.getAllPeople();

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
