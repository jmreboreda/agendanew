package agendanew.persistence;

public class PhoneVO {

    private Integer id;
    private String phoneNumber;
    private Integer personId;

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

    @Override
    public String toString(){
        return "Id: " + this.getId() + " - phoneNumber: " + this.getPhoneNumber() + " - PersonId: " + this.getPersonId();
    }
}
