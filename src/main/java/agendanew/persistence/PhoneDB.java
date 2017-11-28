package agendanew.persistence;

import agendanew.bussines.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        phoneVO.setId(phonesListInit.size() + 1);
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

    public void removePhoneToPerson(PhoneVO phoneVO, PersonVO personVO){
        for(PhoneVO phVO : phonesListInit ){
            if(phVO.getPersonId() == personVO.getId() &&
                    phVO.getPhoneNumber() == phoneVO.getPhoneNumber()){
                phonesListInit.remove(phVO);
            }
        }

    }
}
