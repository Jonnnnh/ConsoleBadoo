package org.example.consolegame.logic.service;

import org.example.consolegame.client.Gender;
import org.example.consolegame.client.Person;

import java.util.List;

public interface PersonService {
    Person createPerson(String firstName, String lastName, Integer age, Gender gender, String[] interests);
    List<Person> getRecommendations(Person person);
    String connectPeople(Person person1, Person person2);
}
