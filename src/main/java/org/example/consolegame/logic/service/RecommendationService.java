package org.example.consolegame.logic.service;

import org.example.consolegame.client.Person;
import org.example.consolegame.client.strategy.RecommendationStrategy;

import java.util.List;

public class RecommendationService implements IRecommendationService{
    private RecommendationStrategy recommendationStrategy;

    public RecommendationService(RecommendationStrategy recommendationStrategy) {
        this.recommendationStrategy = recommendationStrategy;
    }

    public List<Person> getRecommendations(Person person, IPersonCreationService repository) {
        return recommendationStrategy.filter(repository.getAllPeople(), person);
    }

    public void setRecommendations(RecommendationStrategy recommendationStrategy) {
        this.recommendationStrategy = recommendationStrategy;
    }
}
