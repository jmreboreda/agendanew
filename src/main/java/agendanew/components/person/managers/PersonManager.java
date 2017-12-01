package agendanew.components.person.managers;

import agendanew.domain.Person;
import agendanew.persistence.PersonDAO;
import agendanew.persistence.PersonVO;

import java.util.ArrayList;
import java.util.List;



public class PersonManager {

    private List<Person> personsListInit = new ArrayList<>();

    public PersonManager() {
    }

    public List<Person> findAllFirstPersonList(){
        PersonDAO personDAO = new PersonDAO();

        return personDAO.findAllFirstPersonList();
    }

    public Integer createPerson(Person person){
        PersonVO personVO = new PersonVO();
        personVO.setLastName1(person.getLastName1());
        personVO.setLastName2(person.getLastName2());
        personVO.setName(person.getName());

        PersonDAO personDAO = new PersonDAO();
        Integer personId = personDAO.create(personVO);

        return personId;
    }

    public void removePerson(Person person){
        PersonVO personVO = new PersonVO();
        personVO.setId(person.getId());
        personVO.setLastName1(person.getLastName1());
        personVO.setLastName2(person.getLastName2());
        personVO.setName(person.getName());

        PersonDAO personDAO = new PersonDAO();
        personDAO.remove(personVO);
    }

    public List<Person> findPersonByNamePattern(String pattern){
        PersonDAO personDAO = new PersonDAO();
        List<PersonVO> personVOList = personDAO.findPersonByNamePattern(pattern);

        List<Person> personList = new ArrayList<>();
        for(PersonVO pVO : personVOList){
            Person person = new Person(pVO.getId(), pVO.getLastName1(), pVO.getLastName2(), pVO.getName());
            personList.add(person);
        }
        return personList;
    }
}
