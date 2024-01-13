package org.example.consolegame.logic;

import org.example.consolegame.client.Gender;
import org.example.consolegame.client.Person;
import org.example.consolegame.client.factory.PersonFactory;
import org.example.consolegame.logic.service.PersonService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Manager implements Managers {
    private final PersonService personService;
    private final PersonFactory personFactory;

    public Manager(PersonService personService, PersonFactory personFactory) {
        this.personService = personService;
        this.personFactory = personFactory;
    }

    private List<Person> personList = new ArrayList<>();

    @Override
    public void printMenu() {
        System.out.println("Выбери, что хотел бы сделать?");
        System.out.println("1 - Просмотреть свой профиль");
        System.out.println("2 - Изменить свой профиль");
        System.out.println("3 - Посмотреть рекомендации");
        System.out.println("4 - Проверить, подходит ли мне человек");
        System.out.println("5 - Добавить человека");
        System.out.println("0 - Выйти");
    }

    @Override
    public List<Person> getRecommendations(Person me) {
        return personService.getRecommendations(me);
    }

    @Override
    public String connectPeople(Person person1, Person person2) {
        return personService.connectPeople(person1, person2);
    }

    @Override
    public void connectMeWithSomebody(Scanner scanner, Person me) {
        System.out.print("Введите id человека: ");
        int id = scanner.nextInt();

        Person personToConnect = null;
        for (Person person : personList) {
            if (person.getId() == id) {
                personToConnect = person;
                break;
            }
        }

        if (personToConnect != null) {
            String result = connectPeople(me, personToConnect);
            System.out.println(result);
        } else {
            System.out.println("Человека с указанным id нет.");
        }
    }

    @Override
    public Person inputPersonData() {
        Scanner scanner = new Scanner(System.in);
        String name, surname;
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
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста, введите число для возраста.");
                scanner.next();
            }
        }

        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Твой гендер (1 - мужчина, 2 - женщина): ");
                byte genderInput = scanner.nextByte();
                gender = (genderInput == 1) ? Gender.MAN : Gender.WOMAN;
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста, введите 1 или 2 для выбора гендера.");
                scanner.next();
            }
        }
        System.out.println("Хотите ввести интересы? (1 - да, 2 - нет): ");
        String[] interests = null;
        if (scanner.nextByte() == 1) {
            System.out.print("Введите их через запятую без пробелов: ");
            scanner.nextLine();
            interests = scanner.nextLine().split(",");
        } else {
            return personFactory.createPerson(name, surname, age, gender);
        }
        return personFactory.createPerson(name, surname, age, gender, interests);
    }

    @Override
    public void addPerson(Person person) {
        personService.createPerson(person.getFirstName(), person.getLastName(), person.getAge(), person.getGender(), person.getInterests());
        personList.add(person);
    }
}
