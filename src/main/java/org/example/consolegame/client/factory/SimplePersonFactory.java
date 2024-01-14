package org.example.consolegame.client.factory;

import org.example.consolegame.client.Gender;
import org.example.consolegame.client.Person;

import java.awt.*;
import java.util.List;

public class SimplePersonFactory  implements PersonFactory {
    private static int currentId = 1;
    @Override
    public Person createPerson(String firstName, String lastName, Integer age, Gender gender,
                               String location, String education, String profession, List<String> interests) {
        System.out.println("Creating person with ID: " + currentId);
        return new Person(currentId++, firstName, lastName, age, gender, location, education, profession, interests);
    }
}
