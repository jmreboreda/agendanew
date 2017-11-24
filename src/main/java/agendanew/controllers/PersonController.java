package agendanew.controllers;

import agendanew.bussines.Person;
import agendanew.managers.PersonManager;
import agendanew.persistence.PersonVO;

import java.util.ArrayList;
import java.util.List;

public class PersonController {

    public PersonController() {
    }

    public List<Person> findPersonByNamePattern(String pattern){

        PersonManager manager = new PersonManager();
        List<Person> personsList = manager.findPersonByNamePattern(pattern);

        return personsList;
    }
}
