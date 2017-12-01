package agendanew.databases;

import agendanew.domain.Person;
import agendanew.persistence.PersonVO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDB {

    private static List<PersonVO> personsListInit = new ArrayList<>();

    public PersonDB() {
        createPersonDB();
    }

    public void createPersonDB() {
        if(personsListInit.isEmpty()) {
            PersonVO person1 = new PersonVO(1, "Fernández", "Fernández", "Álvaro");
            PersonVO person2 = new PersonVO(2, "Reboreda", "Ferrín", "Paula");
            PersonVO person3 = new PersonVO(3, "Higgs", "López", "Peter W.");
            PersonVO person4 = new PersonVO(4, "Reboreda", "Ferrín", "Guillermo");
            PersonVO person5 = new PersonVO(5, "Nambu", "Sol", "Yoichiro");
            PersonVO person6 = new PersonVO(6, "Iglesias", "Entenza", "Graciela");
            PersonVO person7 = new PersonVO(7, "Reboreda", "Barcia", "José Manuel");
            PersonVO person8 = new PersonVO(8, "Reboreda", "Iglesias", "Carla");
            PersonVO person9 = new PersonVO(9, "Abal", "Cernuda", "Evaristo");
            personsListInit.add(person1);
            personsListInit.add(person2);
            personsListInit.add(person3);
            personsListInit.add(person4);
            personsListInit.add(person5);
            personsListInit.add(person6);
            personsListInit.add(person7);
            personsListInit.add(person8);
            personsListInit.add(person9);
        }
    }

    public List<PersonVO> findAllFirstPersonList(){
        List<PersonVO> orderedFirstPersonsList = personsListInit
                .stream()
                .sorted(Comparator.comparing(PersonVO::getLastName1)).collect(Collectors.toList());

        return orderedFirstPersonsList;
    }

    public Integer createPerson(PersonVO personVO){
        personVO.setId(personsListInit.size());
        personsListInit.add(personVO);

        return personsListInit.size();
    }

    public void removePerson(PersonVO personVO) {
        for(PersonVO pVO : personsListInit){
            if(pVO.getId() == personVO.getId()){
                personsListInit.remove(pVO);
                break;
            }
        }
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

        List<PersonVO> orderedPersonVOList = personVOList
                .stream()
                .sorted(Comparator.comparing(PersonVO::getLastName1)).collect(Collectors.toList());

        return orderedPersonVOList;
    }
}
