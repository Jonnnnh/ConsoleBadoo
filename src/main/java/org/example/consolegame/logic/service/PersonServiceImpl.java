package org.example.consolegame.logic.service;

import org.example.consolegame.client.Gender;
import org.example.consolegame.client.Person;
import org.example.consolegame.client.factory.PersonFactory;
import org.example.consolegame.client.strategy.RecommendationStrategy;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService {
    private List<Person> personList = new ArrayList<>();
    private final PersonFactory personFactory;
    private RecommendationStrategy recommendationStrategy;

    public PersonServiceImpl(PersonFactory personFactory, RecommendationStrategy recommendationStrategy) {
        this.personFactory = personFactory;
        this.recommendationStrategy = recommendationStrategy;
    }


    @Override
    public Person createPerson(String firstName, String lastName, Integer age, Gender gender, String[] interests) {
        Person newPerson = personFactory.createPerson(firstName, lastName, age, gender, interests);
        personList.add(newPerson);
        return newPerson;
    }

    @Override
    public List<Person> getRecommendations(Person person) {
        return recommendationStrategy.filter(personList, person);
    }

    @Override
    public String connectPeople(Person person1, Person person2) {
        if (person1.equals(person2)) {
            return "Нельзя соединить человека с самим собой";
        }
        if (person1.getGender() == person2.getGender()) {
            return "Однополые соединения не поддерживаются";
        }
        return "Есть коннект! Между " + person1.getFirstName() + " и " + person2.getFirstName() + "!";
    }
}