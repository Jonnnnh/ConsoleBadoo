package org.example.consolegame.client.strategy;

import org.example.consolegame.client.Person;

import java.util.List;
import java.util.stream.Collectors;

public class GenderBasedRecommendationStrategy implements RecommendationStrategy{

    @Override
    public List<Person> filter(List<Person> people, Person me) {
        return people.stream()
                .filter(person -> person.getGender() != me.getGender())
                .collect(Collectors.toList());
    }
}
