package agendanew.domain;

public class Phone {

    private Integer id;
    private String phoneNumber;
    private Integer personId;

    public Phone(Integer id, String phoneNumber, Integer personId) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.personId = personId;
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
        return this.getPhoneNumber().substring(0,3)
                + " " + this.getPhoneNumber().substring(3,6)
                + " " + this.getPhoneNumber().substring(6,9);
    }
}
