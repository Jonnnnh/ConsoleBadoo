package org.example.consolegame.logic.service;

import org.example.consolegame.client.Person;
import org.example.consolegame.client.RelationshipType;

public interface IConnectionServiceImpl {
    String connectPeople(Person person1, Person person2, RelationshipType type);
}
