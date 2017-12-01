package agendanew.controllers;

import agendanew.domain.Person;
import agendanew.managers.PersonManager;

import java.util.List;

public class PersonController {

    PersonManager manager = new PersonManager();

    public PersonController() {
    }

    public Integer createPerson(Person person){
        Integer personId = manager.createPerson(person);

        return personId;
    }

    public void removePerson(Person person){
        PersonManager manager = new PersonManager();
        manager.removePerson(person);
    }

    public List<Person> findPersonByNamePattern(String pattern){
        List<Person> personsList = manager.findPersonByNamePattern(pattern);

        return personsList;
    }
}
