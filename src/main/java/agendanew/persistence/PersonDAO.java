package agendanew.persistence;

import agendanew.databases.PersonDB;
import agendanew.domain.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    private Integer id;
    private String lastName1;
    private String lastName2;
    private String name;

    public PersonDAO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer create(PersonVO personVO){
        PersonDB db = new PersonDB();

        return db.create(personVO);
    }

    public List<Person> findAllFirstPersonList(){
        PersonDB db = new PersonDB();
        List<PersonVO> personVOList = db.findAllFirstPersonList();
        List<Person> personList = new ArrayList<>();
        for(PersonVO personVO : personVOList){
            Person person = new Person(
                    personVO.getId(),
                    personVO.getLastName1(),
                    personVO.getLastName2(),
                    personVO.getName());
            personList.add(person);
        }
        return personList;
    }

    public List<PersonVO> findPersonByNamePattern(String pattern){
        PersonDB db = new PersonDB();

        return db.findPersonByNamePattern(pattern);
    }

    public void remove(PersonVO personVO) {
        PersonDB db = new PersonDB();
        db.removePerson(personVO);
    }
}
