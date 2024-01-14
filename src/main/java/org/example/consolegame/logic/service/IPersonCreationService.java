package org.example.consolegame.logic.service;

import org.example.consolegame.client.Gender;
import org.example.consolegame.client.Person;

import java.util.List;

public interface IPersonCreationService {
    Person createPerson(String firstName, String lastName, Integer age, Gender gender,
                        String location, String education, String profession, List<String> interests);

    List<Person> getAllPeople();
    void addPerson(Person person);
}
