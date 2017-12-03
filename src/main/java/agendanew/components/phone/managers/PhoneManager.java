package agendanew.components.phone.managers;

import agendanew.domain.Person;
import agendanew.domain.Phone;
import agendanew.persistence.PhoneVO;
import agendanew.utilities.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class PhoneManager {

    private List<Person> personsListInit = new ArrayList<>();
    private static List<PhoneVO> phonesListInit = new ArrayList<>();
    private static Integer phoneId;

    public PhoneManager() {
        createPhoneDB();
    }

    public void createPhoneDB() {
        if(phonesListInit.isEmpty()) {
            phonesListInit.add(new PhoneVO(1, "986228131", 1));
            phonesListInit.add(new PhoneVO(2, "617344492", 2));
            phonesListInit.add(new PhoneVO(3, "666999666", 3));
            phonesListInit.add(new PhoneVO(4, "660250639", 4));
            phonesListInit.add(new PhoneVO(5, "501501501", 5));
            phonesListInit.add(new PhoneVO(6, "696486497", 6));
            phonesListInit.add(new PhoneVO(7, "652321612", 7));
            phonesListInit.add(new PhoneVO(8, "652321612", 8));
            phonesListInit.add(new PhoneVO(9, "696486497", 8));
            phonesListInit.add(new PhoneVO(10, "986999666", 9));
            phoneId = phonesListInit.size();
        }
    }

    public Integer create(Phone phone){
        phoneId++;
        PhoneVO phoneVO = new PhoneVO();
        phoneVO.setId(phoneId);
        phoneVO.setPhoneNumber(phone.getPhoneNumber());
        phoneVO.setPersonId(phone.getPersonId());
        if(!existPhone(phoneVO)){
            phonesListInit.add(phoneVO);
            return phoneId;
        }
        return null;
    }

    public List<Phone> findPhonesByPersonId(Integer id){
        List<Phone> phoneList = new ArrayList<>();
        for(PhoneVO phoneVO : phonesListInit){
            if(Objects.equals(phoneVO.getPersonId(), id)){
                phoneList.add(new Phone(phoneVO.getId(),
                        phoneVO.getPhoneNumber(),
                        phoneVO.getPersonId()));
            }
        }
        return phoneList;
    }

    public void removePhone(Phone phone){
//        phonesListInit.remove(phoneVO);
        for(PhoneVO phVO : phonesListInit ){
            if(Objects.equals(phVO.getPhoneNumber(), phone.getPhoneNumber()) &&
                    Objects.equals(phVO.getPersonId(), phone.getPersonId())){
                phonesListInit.remove(phVO);
                break;
            }
        }
//        PhoneVO phVO = findPhone(phoneVO);
//        phonesListInit.remove(phVO);
    }

    public void removeAllPhonesOfPerson(Person person){
        for(PhoneVO phoneVO : phonesListInit){
            if(Objects.equals(phoneVO.getPersonId(), person.getId())){
                phoneVO.setPersonId(-1);
            }
        }
    }

    private Boolean existPhone(PhoneVO phoneVO){
        for(PhoneVO phVO : phonesListInit){
            if(Objects.equals(phVO.getPhoneNumber(), phoneVO.getPhoneNumber()) &&
                    Objects.equals(phVO.getPersonId(), phoneVO.getPersonId())){
                Message message = new Message();
                message.warningMessage("Información del sistema","El teléfono " + phoneVO.getPhoneNumber() + " ya existe.");
                return true;
            }
        }
        return false;
    }
}
