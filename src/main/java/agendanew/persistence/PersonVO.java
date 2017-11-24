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

        if(personsListInit.isEmpty()){
            createPersonVOList();
        }
    }

    public void createPerson(PersonVO personVO){

        personsListInit.add(personVO);

    }

    public List<PersonVO> findPersonByNamePattern(String pattern){

        List<PersonVO> personsVOList = new ArrayList<>();
        for(PersonVO personVO : personsListInit){
            if(personVO.getLastName1().toLowerCase().contains(pattern.toLowerCase()) ||
                    personVO.getLastName2().toLowerCase().contains(pattern.toLowerCase()) ||
                    personVO.getName().toLowerCase().contains(pattern.toLowerCase())){
                personsVOList.add(personVO);
            }
        }
        return personsVOList;
    }

    public void createPersonVOList(){

        PersonVO person1 = new PersonVO(1, "Bohr","","Niels");
        PersonVO person2 = new PersonVO(2, "Einstein","","Albert");
        PersonVO person3 = new PersonVO(3, "Feynman","","Richard P.");
        PersonVO person4 = new PersonVO(4, "Gell-Man","","Murray");
        PersonVO person5 = new PersonVO(5, "Higgs","","Peter W.");
        PersonVO person6 = new PersonVO(6, "Nambu","","Yoichiro");
        PersonVO person7 = new PersonVO(7, "Thorne","","Kip");

        personsListInit.add(person1);
        personsListInit.add(person2);
        personsListInit.add(person3);
        personsListInit.add(person4);
        personsListInit.add(person5);
        personsListInit.add(person6);
        personsListInit.add(person7);
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
}
