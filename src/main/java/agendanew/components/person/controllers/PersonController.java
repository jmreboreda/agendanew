package agendanew.components.person.controllers;

import agendanew.domain.Person;
import agendanew.components.person.managers.PersonManager;

import java.util.List;

public class PersonController {

    PersonManager manager = new PersonManager();

    public PersonController() {
    }

    public List<Person> findAllPersons(){
        return new PersonManager().findAllPersons();
    }

    public Integer createPerson(Person person){
        Integer personId = manager.create(person);

        return personId;
    }

    public void removePerson(Person person){
        PersonManager manager = new PersonManager();
        manager.remove(person);
    }

    public List<Person> findPersonByNamePattern(String pattern){
        List<Person> personsList = manager.findPersonByNamePattern(pattern);

        return personsList;
    }
}
