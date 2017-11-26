package agendanew.persistence;

import agendanew.bussines.Person;

import java.util.ArrayList;
import java.util.List;

public class PhoneVO {

    private Integer id;
    private String phoneNumber;
    private Integer personId;


    private List<PhoneVO> phoneListInit = new ArrayList<>();

    public PhoneVO(Integer id, String phoneNumber, Integer personId) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.personId = personId;
    }

    public PhoneVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public List<PhoneVO> getPhoneListInit() {
        return phoneListInit;
    }

    public void setPhoneListInit(List<PhoneVO> phoneListInit) {
        this.phoneListInit = phoneListInit;
    }

    public Integer createPhone(PhoneVO phoneVO){

        PhoneDB db = new PhoneDB();
        Integer phoneId = db.createPhone(phoneVO);

        return phoneId;

    }

    public List<PhoneVO> findPhonesByPerson(Person person){

        PhoneDB db = new PhoneDB();
        db.createPhoneDB();

        List<PhoneVO> phoneVOList = db.findPhonesByPerson(person);

        return phoneVOList;
    }

    public List<PhoneVO> findPhonesByPersonId(Integer id){
        PhoneDB db = new PhoneDB();

        return db.findPhonesByPersonId(id);
    }
}
