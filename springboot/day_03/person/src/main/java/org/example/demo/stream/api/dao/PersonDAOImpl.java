package org.example.demo.stream.api.dao;

import org.example.demo.stream.api.database.PersonDB;
import org.example.demo.stream.api.model.Person;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PersonDAOImpl implements PersonDAO {
    @Override
    public void printListPeople(List<Person> persons) {
        persons.forEach(System.out::println);
    }

    @Override
    public List<Person> getAll() {
        return PersonDB.people;
    }

    @Override
    public List<Person> sortPeopleByFullName() {
        return PersonDB.people.stream()
                .sorted(Comparator.comparing(Person::getFullname))
                .toList();
    }

    @Override
    public List<Person> sortPeopleByFullNameReversed() {
        return PersonDB.people.stream()
                .sorted(Comparator.comparing(Person::getFullname).reversed())
                .toList();
    }

    @Override
    public List<String> getSortedJobs() {
        return PersonDB.people.stream()
                .map(Person::getJob)
                .distinct()
                .sorted()
                .toList();
    }

    @Override
    public List<String> getSortedCities() {
        return null;
    }

    @Override
    public List<String> femaleNames() {
        return null;
    }

    @Override
    public Person highestEarner() {
        return null;
    }

    @Override
    public List<Person> bornAfter1990() {
        return null;
    }

    @Override
    public double averageSalary() {
        return 0;
    }

    @Override
    public double averageAge() {
        return 0;
    }

    @Override
    public List<Person> nameContains(String keyword) {
        return null;
    }

    @Override
    public List<Person> sortedByAgeForMale() {
        return null;
    }

    @Override
    public Person longestName() {
        return null;
    }

    @Override
    public List<Person> aboveAverageSalary() {
        return null;
    }

    @Override
    public Map<String, List<Person>> groupPeopleByCity() {
        return null;
    }

    @Override
    public Map<String, Integer> groupJobByCount() {
        return null;
    }

    @Override
    public List<Person> inSalaryRange(int start, int end) {
        return null;
    }

    @Override
    public List<Person> startsWith(String prefix) {
        return null;
    }

    @Override
    public List<Person> sortByBirthYearDescending() {
        return null;
    }

    @Override
    public List<Person> top5HighestPaid() {
        return null;
    }

    @Override
    public List<Person> inAgeRange(int start, int end) {
        return null;
    }
}
