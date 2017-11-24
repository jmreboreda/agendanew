package agendanew.persistence;

import java.util.ArrayList;
import java.util.List;

public class PersonDB {

    private List<PersonVO> personsListInit = new ArrayList<>();

    public void createPersonDB() {

    PersonVO person1 = new PersonVO(1, "Bohr", "", "Niels");
    PersonVO person2 = new PersonVO(2, "Einstein", "", "Albert");
    PersonVO person3 = new PersonVO(3, "Feynman", "", "Richard P.");
    PersonVO person4 = new PersonVO(4, "Gell-Man", "", "Murray");
    PersonVO person5 = new PersonVO(5, "Higgs", "", "Peter W.");
    PersonVO person6 = new PersonVO(6, "Nambu", "", "Yoichiro");
    PersonVO person7 = new PersonVO(7, "Thorne", "", "Kip");

        personsListInit.add(person1);
        personsListInit.add(person2);
        personsListInit.add(person3);
        personsListInit.add(person4);
        personsListInit.add(person5);
        personsListInit.add(person6);
        personsListInit.add(person7);

    }

    public List<PersonVO> createPerson(PersonVO personVO){

        createPersonDB();

        personVO.setId(personsListInit.size() + 1);

        personsListInit.add(personVO);
        return personsListInit;

    }

    public List<PersonVO> findPersonByNamePattern(String pattern){

        List<PersonVO> personVOList = new ArrayList<>();

        for(PersonVO personVO : personsListInit){
            if(personVO.getLastName1().toLowerCase().contains(pattern.toLowerCase()) ||
                    personVO.getLastName2().toLowerCase().contains(pattern.toLowerCase()) ||
                    personVO.getName().toLowerCase().contains(pattern.toLowerCase())){
                personVOList.add(personVO);
            }
        }

        return personVOList;
    }
}
