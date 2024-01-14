package org.example.consolegame.client.strategy;

import org.example.consolegame.client.Person;

import java.util.List;
import java.util.stream.Collectors;

public class AgeBasedRecommendationStrategy implements RecommendationStrategy{
    private final int minAge;
    private final int maxAge;

    public AgeBasedRecommendationStrategy(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public List<Person> filter(List<Person> people, Person me) {
        return people.stream()
                .filter(person -> person.getAge() >= minAge && person.getAge() <= maxAge)
                .filter(person -> !person.equals(me))
                .collect(Collectors.toList());
    }
}
