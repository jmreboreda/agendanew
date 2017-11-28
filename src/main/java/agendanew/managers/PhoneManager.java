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

    public List<Phone> findPhonesByPersonId(Integer id){
        PhoneVO phoneVO = new PhoneVO();
        List<PhoneVO> phoneVOList = phoneVO.findPhonesByPersonId(id);

        List<Phone> phoneList = new ArrayList<>();
        for(PhoneVO phVO : phoneVOList){
            Phone phone = new Phone(phVO.getId(), phVO.getPhoneNumber(), phVO.getPersonId());
            phoneList.add(phone);
        }
        return phoneList;
    }

    public void removePhoneToPerson(Phone phone, Person person){
        PhoneVO phoneVO = new PhoneVO();
        phoneVO.setId(phone.getId());
        phoneVO.setPhoneNumber(phone.getPhoneNumber());
        phoneVO.setPersonId(phone.getPersonId());

        PersonVO personVO = new PersonVO();
        personVO.setId(person.getId());
        personVO.setLastName1(person.getLastName1());
        personVO.setLastName2(person.getLastName2());
        personVO.setName(person.getName());

        phoneVO.removePhoneToPerson(phoneVO, personVO);
    }
}
