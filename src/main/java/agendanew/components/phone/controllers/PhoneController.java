package agendanew.components.phone.controllers;

import agendanew.domain.Person;
import agendanew.domain.Phone;
import agendanew.components.phone.managers.PhoneManager;

import java.util.List;

public class PhoneController {

    PhoneManager manager = new PhoneManager();

    public PhoneController() {
    }

    public Integer create(Phone phone){
        return manager.create(phone);
    }

    public void removeAllPhonesOfPerson(Integer personId){
        manager.removeAllPhonesOfPerson(personId);
    }



    public void removePhone(Phone phone){
        manager.removePhone(phone);
    }

    public List<Phone> findPhonesByPersonId(Integer id){
        return manager.findPhonesByPersonId(id);
    }
}
