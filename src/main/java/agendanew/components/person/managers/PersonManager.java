package agendanew.components.person.managers;

import agendanew.domain.Person;
import agendanew.persistence.PersonVO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class PersonManager {

    private static List<PersonVO> personsListInit = new ArrayList<>();
    private static Integer personId;

    public PersonManager() {
        createPersonDB();
    }

    public List<Person> findAllPersons(){
        List<Person> personList = new ArrayList<>();
        for(PersonVO personVO : personsListInit){
            Person person = new Person(personVO.getId(),
                    personVO.getLastName1(),
                    personVO.getLastName2(),
                    personVO.getName());
            personList.add(person);
        }
        return personList;
    }

    public Integer create(Person person){
        PersonVO personVO = new PersonVO();
        personVO.setLastName1(person.getLastName1());
        personVO.setLastName2(person.getLastName2());
        personVO.setName(person.getName());

        personId++;
        personVO.setId(personId);
        personsListInit.add(personVO);

        return personId;
    }

    public void remove(Person person){
        PersonVO personVO = new PersonVO();
        personVO.setId(person.getId());
        personVO.setLastName1(person.getLastName1());
        personVO.setLastName2(person.getLastName2());
        personVO.setName(person.getName());

        for(PersonVO pVO : personsListInit){
            if(Objects.equals(pVO.getId(), personVO.getId())){
                personsListInit.remove(pVO);
                break;
            }
        }
    }

    public List<Person> findPersonByNamePattern(String pattern){
        List<Person> personList = new ArrayList<>();
        for(PersonVO personVO : personsListInit){
            if(personVO.getLastName1().toLowerCase().contains(pattern.toLowerCase()) ||
                    personVO.getLastName2().toLowerCase().contains(pattern.toLowerCase()) ||
                    personVO.getName().toLowerCase().contains(pattern.toLowerCase())){
                Person person = new Person(personVO.getId(),
                        personVO.getLastName1(),
                        personVO.getLastName2(),
                        personVO.getName());
                personList.add(person);
            }
        }
        return personList;
    }

    public List<PersonVO> createPersonDB() {
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
            personId = personsListInit.size();
        }
        return personsListInit;
    }
}
