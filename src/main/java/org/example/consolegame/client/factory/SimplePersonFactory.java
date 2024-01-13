package org.example.consolegame.client.factory;

import org.example.consolegame.client.Gender;
import org.example.consolegame.client.Person;

public class SimplePersonFactory  implements PersonFactory {
    private static int currentId = 1;
    @Override
    public Person createPerson(String firstName, String lastName, Integer age, Gender gender) {
        return new Person(currentId++, firstName, lastName, age, gender);
    }

    @Override
    public Person createPerson(String firstName, String lastName, Integer age, Gender gender, String[] interests) {
        return new Person(currentId++, firstName, lastName, age, gender, interests);
    }
}
