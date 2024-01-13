package org.example.consolegame.logic.service;

import org.example.consolegame.client.Gender;
import org.example.consolegame.client.Person;
import org.example.consolegame.client.strategy.RecommendationStrategy;

import java.util.List;

public interface PersonService {
    Person createPerson(String firstName, String lastName, Integer age, Gender gender,
                        String location, String education, String profession, List<String> interests);

    List<Person> getRecommendations(Person person);

    List<Person> getAllPeople();

    String connectPeople(Person person1, Person person2);

    void setRecommendations(RecommendationStrategy recommendationStrategy);
}
