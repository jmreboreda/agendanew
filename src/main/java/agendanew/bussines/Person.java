package agendanew.bussines;

public class Person {

    private Integer id;
    private String apellido1;
    private String apellido2;
    private String nombre;

    public Person(Integer id, String apellido1, String apellido2, String nombre) {
        this.id = id;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString(){

        return getApellido1() + " " + getApellido2() + ", " + getNombre();
    }
}
