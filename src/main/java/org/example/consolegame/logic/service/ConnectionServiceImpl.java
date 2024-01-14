package org.example.consolegame.logic.service;

import org.example.consolegame.client.Person;
import org.example.consolegame.client.RelationshipType;
import org.example.consolegame.helpers.ConsoleColors;

public class ConnectionServiceImpl implements IConnectionServiceImpl {
    @Override
    public String connectPeople(Person person1, Person person2, RelationshipType type) {
        if (person1.equals(person2)) {
            return ConsoleColors.RED + "Нельзя соединить человека с самим собой" + ConsoleColors.RESET;
        }

        if (type == RelationshipType.ROMANTIC && person1.getGender() == person2.getGender()) {
            return ConsoleColors.RED + "Однополые романтические соединения не поддерживаются" + ConsoleColors.RESET;
        }

        person1.addRelationship(person2, type);
        return generateConnectionMessage(person1, person2, type);
    }

    private String generateConnectionMessage(Person person1, Person person2, RelationshipType type) {
        switch (type) {
            case FRIENDSHIP:
                return ConsoleColors.GREEN + "Дружеская связь установлена между " + person1.getFirstName() + " и " + person2.getFirstName() + ConsoleColors.RESET;
            case ROMANTIC:
                return ConsoleColors.MAGENTA + "Романтическая связь установлена между " + person1.getFirstName() + " и " + person2.getFirstName() + ConsoleColors.RESET;
            case NOT_COMPATIBLE:
                return ConsoleColors.YELLOW + person1.getFirstName() + " и " + person2.getFirstName() + " не подходят друг другу" + ConsoleColors.RESET;
            default:
                return ConsoleColors.RED + "Неизвестный тип связи" + ConsoleColors.RESET;
        }
    }
}
