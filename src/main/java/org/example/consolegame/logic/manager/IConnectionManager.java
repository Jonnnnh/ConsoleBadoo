package org.example.consolegame.logic.manager;

import org.example.consolegame.client.Person;

import java.util.Scanner;

public interface IConnectionManager {
    String connectPeople(Person person1, Person person2);
    void connectMeWithSomebody(Scanner scanner, Person me);
}
