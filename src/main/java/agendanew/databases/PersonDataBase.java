package agendanew.databases;

import agendanew.persistence.PersonVO;

import java.util.ArrayList;
import java.util.List;

public class PersonDataBase {

    private List<PersonVO> personsListInit = new ArrayList<>();

    public void createPersonDB() {
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

    public List<PersonVO> getPersonsListInit(){
        return personsListInit;
    }
}
