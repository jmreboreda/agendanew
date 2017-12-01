package agendanew.persistence;

import agendanew.domain.Person;
import agendanew.utilities.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PhoneDB {

    private static List<PhoneVO> phonesListInit = new ArrayList<>();

    public PhoneDB() {
        createPhoneDB();
    }

    public void createPhoneDB() {
        if(phonesListInit.isEmpty()) {
            PhoneVO phone1 = new PhoneVO(1, "986228131", 1);
            PhoneVO phone2 = new PhoneVO(2, "617344492", 2);
            PhoneVO phone3 = new PhoneVO(3, "666999666", 3);
            PhoneVO phone4 = new PhoneVO(4, "660250639", 4);
            PhoneVO phone5 = new PhoneVO(5, "501501501", 5);
            PhoneVO phone6 = new PhoneVO(6, "696486497", 6);
            PhoneVO phone7 = new PhoneVO(7, "652321612", 7);
            PhoneVO phone8 = new PhoneVO(8, "652321612", 8);
            PhoneVO phone9 = new PhoneVO(9, "696486497", 8);
            phonesListInit.add(phone1);
            phonesListInit.add(phone2);
            phonesListInit.add(phone3);
            phonesListInit.add(phone4);
            phonesListInit.add(phone5);
            phonesListInit.add(phone6);
            phonesListInit.add(phone7);
            phonesListInit.add(phone8);
            phonesListInit.add(phone9);
        }
    }

    public Integer createPhone(PhoneVO phoneVO){
        if(existPhone(phoneVO)){
            return null;
        }
        phoneVO.setId(phonesListInit.size());
        phonesListInit.add(phoneVO);

        return phonesListInit.size();
    }

    public List<PhoneVO> findPhonesByPersonId(Integer id){
        List<PhoneVO> phoneVOList = new ArrayList<>();
        for(PhoneVO phoneVO : phonesListInit){
            if(Objects.equals(phoneVO.getPersonId(), id)){
                phoneVOList.add(phoneVO);
            }
        }
        return phoneVOList;
    }

    public void removePhone(PhoneVO phoneVO){
        for(PhoneVO phVO : phonesListInit ){
            if(Objects.equals(phVO.getPhoneNumber(), phoneVO.getPhoneNumber()) &&
                    Objects.equals(phVO.getPersonId(), phoneVO.getPersonId())){
                phonesListInit.remove(phVO);
                break;
            }
        }
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
