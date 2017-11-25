package agendanew.controllers;

import agendanew.bussines.Person;
import agendanew.bussines.Phone;
import agendanew.managers.PersonManager;
import agendanew.managers.PhoneManager;

import java.util.List;

public class PhoneController {

    PhoneManager manager = new PhoneManager();


    public PhoneController() {
    }


    public Integer createPhone(Phone phone){
        Integer phoneId = manager.createPhone(phone);

        return phoneId;
    }

    public List<Phone> findPhoneByPerson(Person person){
        List<Phone> phonesList = manager.findPhonesByPerson(person);

        return phonesList;
    }
}
