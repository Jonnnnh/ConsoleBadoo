package org.example.consolegame.logic.service;

import org.example.consolegame.client.Person;
import org.example.consolegame.client.strategy.RecommendationStrategy;

import java.util.List;

public interface IRecommendationService {
    List<Person> getRecommendations(Person person, IPersonCreationService personService);

    void setRecommendations(RecommendationStrategy recommendationStrategy);
}
