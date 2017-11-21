package agendanew.components.personinput;

import agendanew.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class PersonInput extends GridPane{

    private static final Logger logger = Logger.getLogger(PersonInput.class.getSimpleName());

    @FXML
    private TextField apellido1;
    @FXML
    private TextField apellido2;
    @FXML
    private TextField nombre;
    @FXML
    private Button inputComponentOfAddPerson;
    @FXML
    private Button inputComponentOfRemovePerson;


    public PersonInput() {
        ViewLoader.load(this, "/agendanew/personinput.fxml");
        inputComponentOfAddPerson.setOnAction(this::onAddPerson);
        inputComponentOfRemovePerson.setOnMouseClicked(this::onRemovePerson);
    }

    private void onAddPerson(ActionEvent event){

        String message;
        Map<String, String> personInputMap = retrieveDataOfPersonInput();
        if(personInputMap.isEmpty()){
            message = "none or incomplete data!!";
        }else{
            message = personInputMap.get("apellido1") + " " + personInputMap.get("apellido2")
                    + ", " + personInputMap.get("nombre");
            personInputClear();
        }
        logger.info("inputComponentOfAddPerson clicked with ... " + message);
    }

    public void onRemovePerson(MouseEvent event){
        logger.info("inputComponentOfRemovePerson clicked ...");

    }
    public void setStateOfActivatorOfRemovePerson(Boolean state){
        inputComponentOfRemovePerson.disableProperty().setValue(!state);
    }

    public Map<String,String> retrieveDataOfPersonInput() {

        Map<String, String> personInputMap = new HashMap<>();
        if (!apellido1.getText().isEmpty() &&
                !apellido2.getText().isEmpty() && !nombre.getText().isEmpty()) {

                personInputMap.put("apellido1", apellido1.getText());
                personInputMap.put("apellido2", apellido2.getText());
                personInputMap.put("nombre", nombre.getText());
            }
            return personInputMap;
    }

    private void personInputClear(){
        apellido1.clear();
        apellido2.clear();
        nombre.clear();
    }

}
