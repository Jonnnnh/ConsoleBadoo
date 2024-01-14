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
        if (isUniquePerson(firstName, lastName, age, gender, location, education, profession, interests)) {
            Person newPerson = personFactory.createPerson(firstName, lastName, age, gender,
                    location, education, profession, interests);
            addPerson(newPerson);
            return newPerson;
        } else {
            System.out.println("Такой пользователь уже существует.");
            return null;
        }
    }

    @Override
    public List<Person> getAllPeople() {
        return new ArrayList<>(personList);
    }

    @Override
    public void addPerson(Person person) {
        if (!personList.contains(person)) {
            personList.add(person);
        }
    }

    // TODO: печатается, хотя данные у игроков не все одинаковые, и все равно добавляет
    private boolean isUniquePerson(String firstName, String lastName, Integer age, Gender gender,
                                   String location, String education, String profession, List<String> interests) {
        return personList.stream().noneMatch(person ->
                Objects.equals(person.getFirstName(), firstName) &&
                        Objects.equals(person.getLastName(), lastName) &&
                        Objects.equals(person.getAge(), age) &&
                        person.getGender() == gender &&
                        Objects.equals(person.getLocation(), location) &&
                        Objects.equals(person.getEducation(), education) &&
                        Objects.equals(person.getProfession(), profession) &&
                        Objects.equals(person.getInterests(), interests));
    }
}