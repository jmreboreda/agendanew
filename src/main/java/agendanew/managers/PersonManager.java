package agendanew.managers;

import agendanew.bussines.Person;
import agendanew.persistence.PersonVO;

import java.util.ArrayList;
import java.util.List;



public class PersonManager {

    private List<Person> personsListInit = new ArrayList<>();

    public PersonManager() {
    }

    public void createPerson(Person person){

        PersonVO personVO = new PersonVO();
        personVO.setLastName1(person.getLastName1());
        personVO.setLastName2(person.getLastName2());
        personVO.setName(person.getName());

        personVO.createPerson(personVO);

    }

    public List<Person> findPersonByNamePattern(String pattern){

        PersonVO personVO = new PersonVO();
        List<PersonVO> personVOList = personVO.findPersonByNamePattern(pattern);

        List<Person> personsList = new ArrayList<>();
        for(PersonVO pVO :personVOList){
            Person person = new Person(pVO.getId(), pVO.getLastName1(), pVO.getLastName2(), pVO.getName());
            personsList.add(person);
        }

        return personsList;
    }
}
