package org.example.consolegame.client.strategy;

import org.example.consolegame.client.Person;
import org.example.consolegame.helpers.InputNormalizer;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InterestBasedRecommendationStrategy implements RecommendationStrategy {
    private final List<String> interests;

    public InterestBasedRecommendationStrategy(List<String> interests) {
        this.interests = interests.stream()
                .map(InputNormalizer::normalizeString)
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> filter(List<Person> people, Person me) {
        return people.stream()
                .filter(person -> InputNormalizer.hasMatchingInterests(person, this.interests))
                .collect(Collectors.toList());
    }
}
