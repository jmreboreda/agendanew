package agendanew.persistence;

import java.util.ArrayList;
import java.util.List;

public class PersonVO {

    private Integer id;
    private String lastName1;
    private String lastName2;
    private String name;

    private List<PersonVO> personsListInit = new ArrayList<>();

    public PersonVO(Integer id, String lastName1, String lastName2, String name) {
        this.id = id;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.name = name;
    }

    public PersonVO() {
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

    public List<PersonVO> getPersonsListInit() {
        return personsListInit;
    }

    public void setPersonsListInit(List<PersonVO> personsListInit) {
        this.personsListInit = personsListInit;
    }

    public Integer createPerson(PersonVO personVO){

        PersonDB db = new PersonDB();
        Integer personId = db.createPerson(personVO);

        return personId;

    }

    public List<PersonVO> findPersonByNamePattern(String pattern){

        PersonDB db = new PersonDB();
        db.createPersonDB();

        List<PersonVO> personVOList = db.findPersonByNamePattern(pattern);

        return personVOList;
    }
}
