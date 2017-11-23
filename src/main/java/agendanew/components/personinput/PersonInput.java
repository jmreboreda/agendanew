package agendanew.components.personinput;

import agendanew.bussines.Person;
import agendanew.components.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.logging.Logger;

public class PersonInput extends GridPane{

    private static final Logger logger = Logger.getLogger(PersonInput.class.getSimpleName());

    @FXML
    private TextField lastName1;
    @FXML
    private TextField lastName2;
    @FXML
    private TextField name;
    @FXML
    private Button addPersonButton;


    public PersonInput() {
        ViewLoader.load(this, "/agendanew/personinput.fxml");
        addPersonButton.setOnAction(this::onAddPerson);
    }

    private void onAddPerson(ActionEvent event){

        String message;
        Person person = retrievePerson();
        if(person == null){
            message = "none or incomplete data!!";
        }else{
            message = person.getLastName1() + " " + person.getLastName2()
                    + ", " + person.getName();
            personInputClear();
        }
        logger.info("addPersonButton clicked with ... " + message);
    }

    public void onRemovePerson(MouseEvent event){
        logger.info("inputComponentOfRemovePerson clicked ...");

    }

    public Person retrievePerson() {

        if(lastName1.getText().isEmpty() || lastName2.getText().isEmpty() || name.getText().isEmpty()){
            return null;
        }

        return new Person(50, lastName1.getText(), lastName2.getText(), name.getText());
    }

    private void personInputClear(){
        lastName1.clear();
        lastName2.clear();
        name.clear();
    }

}
