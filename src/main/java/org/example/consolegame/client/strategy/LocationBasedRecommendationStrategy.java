package org.example.consolegame.client.strategy;

import org.example.consolegame.client.Person;

import java.util.List;
import java.util.stream.Collectors;

public class LocationBasedRecommendationStrategy implements RecommendationStrategy {
    private final String location;

    public LocationBasedRecommendationStrategy(String location) {
        this.location = location;
    }

    @Override
    public List<Person> filter(List<Person> people, Person me) {
        return people.stream()
                .filter(person -> person.getLocation().equals(location))
                .collect(Collectors.toList());
    }
}
