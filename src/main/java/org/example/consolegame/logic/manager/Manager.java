package org.example.consolegame.logic.manager;

import org.example.consolegame.client.Gender;
import org.example.consolegame.client.Person;
import org.example.consolegame.client.factory.PersonFactory;
import org.example.consolegame.client.strategy.*;
import org.example.consolegame.helpers.ConsoleColors;
import org.example.consolegame.helpers.InputNormalizer;
import org.example.consolegame.logic.service.PersonService;

import java.util.*;

public class Manager implements PersonManager {
    private final PersonService personService;
    private final PersonFactory personFactory;
    private final List<Person> personList = new ArrayList<>();

    public Manager(PersonService personService, PersonFactory personFactory) {
        this.personService = personService;
        this.personFactory = personFactory;
    }

    @Override
    public List<Person> getRecommendations(Person me) {
        return personService.getRecommendations(me);
    }

    @Override
    public void addPerson(Person person) {
        personService.createPerson(person.getFirstName(), person.getLastName(), person.getAge(), person.getGender(), person.getLocation(),
                person.getEducation(), person.getProfession(), person.getInterests());
        personList.add(person);
    }

    @Override
    public void printMenu() {
        System.out.print("\n");
        ConsoleColors.printHeader("Главное Меню");
        ConsoleColors.printText("1 - Просмотреть свой профиль");
        ConsoleColors.printText("2 - Изменить свой профиль");
        ConsoleColors.printText("3 - Посмотреть рекомендации");
        ConsoleColors.printText("4 - Проверить, подходит ли мне человек");
        ConsoleColors.printText("5 - Добавить человека");
        ConsoleColors.printText("0 - Выйти");
        System.out.print("\n");
    }

    @Override
    public Person inputPersonData() {
        Scanner scanner = new Scanner(System.in);
        String name, surname, location, education, profession;
        int age = 0;
        Gender gender = null;

        System.out.print("Имя: ");
        name = scanner.nextLine();

        System.out.print("Фамилия: ");
        surname = scanner.nextLine();

        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Возраст: ");
                age = scanner.nextInt();
                scanner.nextLine();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println(ConsoleColors.RED + "Пожалуйста, введите число для возраста" + ConsoleColors.RESET);
                scanner.nextLine();
            }
        }

        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Твой гендер (1 - мужчина, 2 - женщина): ");
                byte genderInput = scanner.nextByte();
                scanner.nextLine();
                gender = (genderInput == 1) ? Gender.MAN : Gender.WOMAN;
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println(ConsoleColors.RED + "Пожалуйста, введите 1 или 2 для выбора гендера" + ConsoleColors.RESET);
                scanner.nextLine();
            }
        }
        System.out.print("Местоположение: ");
        location = scanner.nextLine();

        System.out.print("Образование: ");
        education = scanner.nextLine();

        System.out.print("Профессия: ");
        profession = scanner.nextLine();

        System.out.println("Хотите ввести интересы? (1 - да, 2 - нет): ");
        List<String> interests = new ArrayList<>();
        if (scanner.nextByte() == 1) {
            scanner.nextLine();
            System.out.print("Введите интересы через запятую: ");
            String interestsInput = scanner.nextLine();
            interests = Arrays.asList(interestsInput.split(","));
        }
        return personFactory.createPerson(name, surname, age, gender, location, education, profession, interests);
    }

    @Override
    public void selectRecommendation(Person me) {
        Scanner scanner = new Scanner(System.in);
        ConsoleColors.printText("Выберите стратегию рекомендаций:");
        ConsoleColors.printText("1 - По полу");
        ConsoleColors.printText("2 - По возрасту");
        ConsoleColors.printText("3 - По интересам");
        ConsoleColors.printText("4 - По местоположению");
        int choice = scanner.nextInt();
        RecommendationStrategy strategy;

        switch (choice) {
            case 1:
                strategy = new GenderBasedRecommendationStrategy();
                break;
            case 2:
                System.out.print("Введите минимальный возраст: ");
                int minAge = scanner.nextInt();
                System.out.print("Введите максимальный возраст: ");
                int maxAge = scanner.nextInt();
                strategy = new AgeBasedRecommendationStrategy(minAge, maxAge);
                break;
            case 3:
                System.out.print("Введите интересы: ");
                scanner.nextLine();
                List<String> interests = Arrays.asList(scanner.nextLine().split(","));
                strategy = new InterestBasedRecommendationStrategy(interests);
                break;
            case 4:
                System.out.print("Введите местоположение: ");
                scanner.nextLine();
                String locationInput = scanner.nextLine();
                String normalizedLocation = InputNormalizer.normalizeLocation(locationInput);
                strategy = new LocationBasedRecommendationStrategy(normalizedLocation);
                break;
            default:
                strategy = new GenderBasedRecommendationStrategy();
        }
        personService.setRecommendations(strategy);

        List<Person> recommendations = personService.getRecommendations(me);
        if (recommendations.isEmpty()) {
            System.out.println(ConsoleColors.RED + "Нет людей, соответствующих выбранным критериям." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.GREEN + "Стратегия рекомендаций успешно установлена." + ConsoleColors.RESET);
        }
    }
}
