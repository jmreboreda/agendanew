package agendanew.managers;

import agendanew.bussines.Person;
import agendanew.persistence.PersonVO;

import java.util.ArrayList;
import java.util.List;



public class PersonManager {

    private List<Person> personsListInit = new ArrayList<>();

    public PersonManager() {
    }

    public List<Person> createPerson(Person person){

        PersonVO personVO = new PersonVO();
        personVO.setLastName1(person.getLastName1());
        personVO.setLastName2(person.getLastName2());
        personVO.setName(person.getName());

        List<PersonVO> personVOList = personVO.createPerson(personVO);

        List<Person> personList = new ArrayList<>();
        for(PersonVO pVO : personVOList){
            Person p = new Person(pVO.getId(), pVO.getLastName1(), pVO.getLastName2(), pVO.getName());
            personList.add(p);
        }

        return personList;

    }

    public List<Person> findPersonByNamePattern(String pattern){

        PersonVO personVO = new PersonVO();
        List<PersonVO> personVOList = personVO.findPersonByNamePattern(pattern);

        List<Person> personList = new ArrayList<>();
        for(PersonVO pVO : personVOList){
            Person p = new Person(pVO.getId(), pVO.getLastName1(), pVO.getLastName2(), pVO.getName());
            personList.add(p);
        }

        return personList;
    }
}
