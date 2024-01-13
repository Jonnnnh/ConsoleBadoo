package org.example.consolegame.client.factory;

import org.example.consolegame.client.Gender;
import org.example.consolegame.client.Person;

public interface PersonFactory {
    Person createPerson(String firstName, String lastName, Integer age, Gender gender);
    Person createPerson(String firstName, String lastName, Integer age, Gender gender, String[] interests);
}
