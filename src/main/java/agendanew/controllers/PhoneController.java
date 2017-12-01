package agendanew.controllers;

import agendanew.domain.Person;
import agendanew.domain.Phone;
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

    public void removeAllPhonesOfPerson(Person person){
        PhoneManager manager = new PhoneManager();
        manager.removeAllPhonesOfPerson(person);
    }



    public void removePhone(Phone phone){
        PhoneManager manager = new PhoneManager();
        manager.removePhone(phone);
    }

    public List<Phone> findPhonesByPersonId(Integer id){
        PhoneManager manager = new PhoneManager();

        return manager.findPhonesByPersonId(id);
    }
}
