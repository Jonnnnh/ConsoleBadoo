package org.example.consolegame.helpers;

import org.example.consolegame.client.Person;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputNormalizer {
    private static final Map<String, String> locationSynonyms = new HashMap<>();

    static {
        locationSynonyms.put("москва", "Москва");
        locationSynonyms.put("мск", "Москва");
        locationSynonyms.put("санкт-петербург", "Санкт-Петербург");
        locationSynonyms.put("спб", "Санкт-Петербург");
        locationSynonyms.put("питер", "Санкт-Петербург");
        locationSynonyms.put("воронеж", "Воронеж");
        locationSynonyms.put("вр", "воронеж");
        locationSynonyms.put("Воронеж", "воронеж");
    }

    public static String normalizeLocation(String input) {
        return locationSynonyms.getOrDefault(input.toLowerCase(), input);
    }

    public static String normalizeString(String input) {
        if (input == null) {
            return null;
        }
        return input.toLowerCase().trim();
    }
    public static boolean hasMatchingInterests(Person person, List<String> userInterests) {
        for (String userInterest : userInterests) {
            String normalizedUserInterest = InputNormalizer.normalizeString(userInterest);
            for (String personInterest : person.getInterests()) {
                String normalizedPersonInterest = InputNormalizer.normalizeString(personInterest);
                if (normalizedUserInterest.equals(normalizedPersonInterest)) {
                    return true;
                }
            }
        }
        return false;
    }
}

