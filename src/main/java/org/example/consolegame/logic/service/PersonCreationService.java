package org.example.consolegame.logic.service;

import org.example.consolegame.client.Gender;
import org.example.consolegame.client.Person;
import org.example.consolegame.client.factory.PersonFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PersonCreationService implements IPersonCreationService {
    private final List<Person> personList = new ArrayList<>();
    private final PersonFactory personFactory;

    public PersonCreationService(PersonFactory personFactory) {
        this.personFactory = personFactory;
    }

    @Override
    public Person createPerson(String firstName, String lastName, Integer age, Gender gender,
                               String location, String education, String profession, List<String> interests) {
            Person newPerson = personFactory.createPerson(firstName, lastName, age, gender,
                    location, education, profession, interests);
            return newPerson;
    }

    @Override
    public List<Person> getAllPeople() {
        return new ArrayList<>(personList);
    }

    @Override
    public void addPerson(Person person) {
        if (personList.stream().noneMatch(p -> p.getId() == person.getId())) {
            personList.add(person);
        }
//        if (!personList.contains(person)) {
//            personList.add(person);
//        }
    }
}