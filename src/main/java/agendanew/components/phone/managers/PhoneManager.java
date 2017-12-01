package agendanew.components.phone.managers;

import agendanew.domain.Person;
import agendanew.domain.Phone;
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

    public void removePhone(Phone phone){
        PhoneVO phoneVO = new PhoneVO();
        phoneVO.setId(phone.getId());
        phoneVO.setPhoneNumber(phone.getPhoneNumber());
        phoneVO.setPersonId(phone.getPersonId());

        phoneVO.removePhone(phoneVO);
    }

    public void removeAllPhonesOfPerson(Person person){
        PhoneVO phoneVO = new PhoneVO();
        phoneVO.removeAllPhonesOfPerson(person);
    }
}
