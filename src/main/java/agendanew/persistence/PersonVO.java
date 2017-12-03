package agendanew.persistence;

public class PersonVO {

    private Integer id;
    private String lastName1;
    private String lastName2;
    private String name;

    public PersonVO(Integer id, String lastName1, String lastName2, String name) {
        this.id = id;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.name = name;
    }

    public PersonVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return this.getLastName1() + " " + this.getLastName2() + ", " + this.getName();
    }
}
