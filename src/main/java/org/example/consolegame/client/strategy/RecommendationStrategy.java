package org.example.consolegame.client.strategy;

import org.example.consolegame.client.Person;

import java.util.List;

public interface RecommendationStrategy {
    List<Person> filter(List<Person> people, Person me);
}
