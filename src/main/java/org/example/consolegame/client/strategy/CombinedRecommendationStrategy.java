package org.example.consolegame.client.strategy;

import org.example.consolegame.client.Person;

import java.util.List;

public class CombinedRecommendationStrategy implements RecommendationStrategy {
    private List<RecommendationStrategy> strategies;

    public CombinedRecommendationStrategy(List<RecommendationStrategy> strategies) {
        this.strategies = strategies;
    }
    @Override
    public List<Person> filter(List<Person> people, Person me) {
        for (RecommendationStrategy strategy : strategies) {
            people = strategy.filter(people, me);
        }
        return people;
    }
}
