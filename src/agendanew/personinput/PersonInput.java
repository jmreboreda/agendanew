package agendanew.personinput;

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
    private Button addPersonButton;


    public PersonInput() {
        ViewLoader.load(this, "personinput/personinput.fxml");
        addPersonButton.setOnMouseClicked(this::onAddPerson);
    }

    public void onAddPerson(MouseEvent event){
        logger.info("addPersonButton clicked ... ");
    }
}