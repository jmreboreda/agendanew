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
    private Button phoneAddActivator;
    @FXML
    private Button phoneRemoveActivator;
    @FXML
    private Button exitButton;

    public PhoneInput() {
        ViewLoader.load(this, "/agendanew/phoneinput.fxml");

        phoneAddActivator.setOnMouseClicked(this::onAddPhone);
        exitButton.setOnMouseClicked(this::onExit);

    }

    private void onAddPhone(MouseEvent event){
        String number = "none!!";
        if(!phoneNumber.getText().isEmpty()){
            number = phoneNumber.getText();
        }
        logger.info("phoneAddActivator clicked ... and the phone number to add is: " + number);

    }

    public void setStateOfActivatorOfAddPhone(Boolean state){
        phoneAddActivator.disableProperty().setValue(!state);
    }

    public void setPhoneRemoveActivator(Boolean state){
        phoneRemoveActivator.disableProperty().setValue(!state);
    }

    private void onExit(MouseEvent event){
        Platform.exit();
        System.exit(0);
    }
}
