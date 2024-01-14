package org.example.consolegame.logic.service;

import org.example.consolegame.client.Person;
import org.example.consolegame.helpers.ConsoleColors;

public class ConnectionServiceImpl implements IConnectionServiceImpl {
    @Override
    public String connectPeople(Person person1, Person person2) {
        if (person1.equals(person2)) {
            return ConsoleColors.RED + "Нельзя соединить человека с самим собой" + ConsoleColors.RESET;
        }
        if (person1.getGender() == person2.getGender()) {
            return ConsoleColors.RED + "Однополые соединения не поддерживаются" + ConsoleColors.RESET;
        }
        person1.addFriend(person2); // TODO: реализовать разные связи
        return ConsoleColors.GREEN + "Есть коннект! Между " + person1.getFirstName() + " и " + person2.getFirstName() + "!" + ConsoleColors.RESET;
    }
}
