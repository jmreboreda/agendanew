package agendanew.components.personinput;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import agendanew.ViewLoader;

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
    private Button personAddButton;
    @FXML
    private Button personRemoveButton;


    public PersonInput() {
        ViewLoader.load(this, "components/personinput/personinput.fxml");
        personAddButton.setOnMouseClicked(this::onAddPerson);
        personRemoveButton.setOnMouseClicked(this::onRemovePerson);
    }

    public void onAddPerson(MouseEvent event){
        logger.info("personAddButton clicked ... ");
    }

    public void onRemovePerson(MouseEvent event){
        logger.info("personRemoveButton clicked ...");

    }
    public void refreshRemovePersonButtonState(Boolean state){
        personRemoveButton.disableProperty().setValue(!state);
    }
}
