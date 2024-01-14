package org.example.consolegame.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Person {
    private int id = 0;
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final Gender gender;
    private String location;
    private String education;
    private String profession;
    private final List<String> interests;
    private List<Person> friends;

    public Person(int id, String firstName, String lastName, Integer age, Gender gender, String location, String education, String profession, List<String> interests) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.location = location;
        this.education = education;
        this.profession = profession;
        this.interests = interests;
        this.friends = new ArrayList<>();
    }

    public List<Person> getFriends() {
        return friends;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public List<String> getInterests() {
        return interests;
    }

    public String getProfileCard() {
        System.out.print("\n");
        String ansiGreen = "\u001B[32m";
        String ansiReset = "\u001B[0m";

        StringBuilder profile = new StringBuilder(ansiGreen);
        profile.append(firstName).append(" ").append(lastName).append(", ").append(age).append(", ").append(gender).append(", id = ").append(id);

        if (location != null && !location.isEmpty()) {
            profile.append(", Местоположение: ").append(location);
        }
        if (education != null && !education.isEmpty()) {
            profile.append(", Образование: ").append(education);
        }
        if (profession != null && !profession.isEmpty()) {
            profile.append(", Профессия: ").append(profession);
        }
        if (interests != null && !interests.isEmpty()) {
            profile.append(", Интересы: ").append(interests);
        }
        profile.append(ansiReset);
        return profile.toString();
    }

    public void addFriend(Person friend) {
        if (!this.friends.contains(friend) && !friend.equals(this)) {
            this.friends.add(friend);
            friend.addFriend(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(age, person.age) &&
                gender == person.gender &&
                Objects.equals(location, person.location) &&
                Objects.equals(education, person.education) &&
                Objects.equals(profession, person.profession) &&
                Objects.equals(interests, person.interests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, gender, location, education, profession, interests);
    }
}