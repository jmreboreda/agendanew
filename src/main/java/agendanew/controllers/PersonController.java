package agendanew.controllers;

import agendanew.bussines.Person;
import agendanew.managers.PersonManager;
import agendanew.persistence.PersonVO;

import java.util.ArrayList;
import java.util.List;

public class PersonController {

    PersonManager manager = new PersonManager();


    public PersonController() {
    }


    public List<Person> createPerson(Person person){

        List<Person> personList = manager.createPerson(person);

        return personList;

    }

    public List<Person> findPersonByNamePattern(String pattern){


        List<Person> personsList = manager.findPersonByNamePattern(pattern);

        return personsList;
    }
}
