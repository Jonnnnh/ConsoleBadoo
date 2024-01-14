package org.example.consolegame.logic.facade;

import org.example.consolegame.client.Gender;
import org.example.consolegame.client.Person;
import org.example.consolegame.client.RelationshipType;
import org.example.consolegame.client.strategy.RecommendationStrategy;
import org.example.consolegame.logic.service.IConnectionServiceImpl;
import org.example.consolegame.logic.service.IPersonCreationService;
import org.example.consolegame.logic.service.RecommendationService;

import java.util.List;

public class PersonManagementFacade {
    private final IPersonCreationService personCreationService;
    private final RecommendationService recommendationService;
    private final IConnectionServiceImpl connectionService;

    public PersonManagementFacade(
            IPersonCreationService personCreationService,
            RecommendationService recommendationService,
            IConnectionServiceImpl connectionService) {
        this.personCreationService = personCreationService;
        this.recommendationService = recommendationService;
        this.connectionService = connectionService;
    }

    public Person createPerson(String firstName, String lastName, Integer age, Gender gender,
                               String location, String education, String profession, List<String> interests) {
        return personCreationService.createPerson(firstName, lastName, age, gender, location, education, profession, interests);
    }

    public List<Person> getRecommendations(Person person) {
        return recommendationService.getRecommendations(person, personCreationService);
    }

    public void setRecommendations(RecommendationStrategy strategy) {
        recommendationService.setRecommendations(strategy);
    }

    public String connectPeople(Person person1, Person person2, RelationshipType type) {
        return connectionService.connectPeople(person1, person2, type);
    }

    public List<Person> getAllPeople() {
        return personCreationService.getAllPeople();
    }

    public void addPerson(Person person) {
        personCreationService.addPerson(person);
    }
}
