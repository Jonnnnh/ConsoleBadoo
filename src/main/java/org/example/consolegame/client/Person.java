package org.example.consolegame.client;

import java.util.Arrays;
import java.util.Objects;

public class Person {
    private int id = 0;
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final Gender gender;
    private String[] interests;

    public Person(int id, String firstName, String lastName, Integer age, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public Person(int id, String firstName, String lastName, Integer age, Gender gender, String[] interests) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.interests = interests;
    }

    public String getProfileCard() {
        String profile = firstName + " " + lastName + ", " + age + ", " + gender + ", id = " + id;

        if (interests != null && interests.length > 0) {
            profile += ", Интересы: " + Arrays.toString(interests);
        }

        return profile;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != getClass()) return false;

        Person person = (Person) obj;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(age, person.age) &&
                Objects.equals(gender, person.gender) &&
                Arrays.equals(interests, person.interests);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    public String[] getInterests() {
        return interests;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", interests=" + Arrays.toString(interests) +
                '}';
    }
}
