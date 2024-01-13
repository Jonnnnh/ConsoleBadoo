package org.example.consolegame.logic;

import org.example.consolegame.client.Person;

import java.util.List;
import java.util.Scanner;

public interface Managers {
    void printMenu();

    Person inputPersonData();

    List<Person> getRecommendations(Person me);

    String connectPeople(Person person1, Person person2);

    void connectMeWithSomebody(Scanner scanner, Person me);

    void addPerson(Person person);
}
