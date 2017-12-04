package agendanew.components.person.controllers;

import agendanew.domain.Person;
import agendanew.components.person.managers.PersonManager;

import java.util.List;

public class PersonController {

    PersonManager manager = new PersonManager();

    public PersonController() {
    }

    public List<Person> findAllPersons(){
        return manager.findAllPersons();
    }

    public Integer createPerson(Person person){
        return  manager.createPerson(person);
    }

    public void removePerson(Person person){
        manager.removePerson(person);
    }

    public List<Person> findPersonByNamePattern(String pattern){
        return manager.findPersonByNamePattern(pattern);
    }
}
