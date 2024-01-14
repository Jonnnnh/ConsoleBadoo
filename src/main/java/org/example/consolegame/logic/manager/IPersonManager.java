package org.example.consolegame.logic.manager;

import org.example.consolegame.client.Person;

import java.util.List;

public interface IPersonManager {
    void printMenu();

    Person inputPersonData();

    List<Person> getRecommendations(Person me);

    void addPerson(Person person);

    void selectRecommendation(Person me);
}
