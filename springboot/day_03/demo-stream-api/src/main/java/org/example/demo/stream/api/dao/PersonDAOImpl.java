package org.example.demo.stream.api.dao;

import org.example.demo.stream.api.model.Person;

import java.util.List;
import java.util.Map;

public class PersonDAOImpl implements PersonDAO{
    @Override
    public void printListPeople(List<Person> persons) {

    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public List<Person> sortPeopleByFullName() {
        return null;
    }

    @Override
    public List<Person> sortPeopleByFullNameReversed() {
        return null;
    }

    @Override
    public List<String> getSortedJobs() {
        return null;
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
}
