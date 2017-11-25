package agendanew.managers;

import agendanew.bussines.Person;
import agendanew.bussines.Phone;
import agendanew.persistence.PersonVO;
import agendanew.persistence.PhoneVO;

import java.util.ArrayList;
import java.util.List;


public class PhoneManager {

    private List<Person> personsListInit = new ArrayList<>();

    public PhoneManager() {
    }

    public Integer createPhone(Phone phone){

        PhoneVO phoneVO = new PhoneVO();
        phoneVO.setId(null);
        phoneVO.setPhoneNumber(phone.getPhoneNumber());
        phoneVO.setPersonId(phone.getPersonId());

        return phoneVO.createPhone(phoneVO);
    }

    public List<Phone> findPhonesByPerson(Person person){

        PhoneVO phoneVO = new PhoneVO();
        List<PhoneVO> phoneVOList = phoneVO.findPhonesByPerson(person);

        List<Phone> phoneList = new ArrayList<>();
        for(PhoneVO phVO : phoneVOList){
            Phone ph = new Phone(phVO.getId(),phVO.getPhoneNumber(),phVO.getPersonId());
            phoneList.add(ph);
        }
        return phoneList;
    }
}
