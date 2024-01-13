package org.example.consolegame.client.factory;

import org.example.consolegame.client.Gender;
import org.example.consolegame.client.Person;

import java.util.List;

public interface PersonFactory {
    Person createPerson(String firstName, String lastName, Integer age, Gender gender,
                        String location, String education, String profession, List<String> interests);
}
