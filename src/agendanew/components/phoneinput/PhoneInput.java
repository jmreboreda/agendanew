package agendanew.components.phoneinput;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import agendanew.ViewLoader;

import java.util.logging.Logger;

public class PhoneInput extends GridPane {

    private static final Logger logger = Logger.getLogger(PhoneInput.class.getSimpleName());


    @FXML
    private TextField phoneNumber;
    @FXML
    private Button phoneAddButton;
    @FXML
    private Button inputComponentOfRemovePhone;
    @FXML
    private Button exitButton;

    public PhoneInput() {
        ViewLoader.load(this, "components/phoneinput/phoneinput.fxml");

        phoneAddButton.setOnMouseClicked(this::onAddPhone);
        exitButton.setOnMouseClicked(this::onExit);

    }

    private void onAddPhone(MouseEvent event){
        String number = "none!!";
        if(!phoneNumber.getText().isEmpty()){
            number = phoneNumber.getText();
        }
        logger.info("phoneAddButton clicked ... and the phone number to add is: " + number);

    }

    public void setAddPhoneButtonState(Boolean state){
        phoneAddButton.disableProperty().setValue(!state);
    }

    public void setInputComponentOfRemovePhone(Boolean state){
        inputComponentOfRemovePhone.disableProperty().setValue(!state);
    }



    private void onExit(MouseEvent event){
        Platform.exit();
        System.exit(0);
    }
}
