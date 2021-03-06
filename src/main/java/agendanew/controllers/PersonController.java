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

    public Integer createPerson(Person person){
        Integer personId = manager.createPerson(person);

        return personId;
    }

    public List<Person> findPersonByNamePattern(String pattern){
        List<Person> personsList = manager.findPersonByNamePattern(pattern);

        return personsList;
    }
}
