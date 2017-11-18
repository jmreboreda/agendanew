package agendanew.components.phoneinput;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import agendanew.ViewLoader;

import java.util.logging.Logger;

public class PhoneInput extends HBox {

    private static final Logger logger = Logger.getLogger(PhoneInput.class.getSimpleName());


    @FXML
    private TextField phoneNumber;
    @FXML
    private Button phoneAddButton;

    public PhoneInput() {
        ViewLoader.load(this, "components/phoneinput/phoneinput.fxml");
        phoneAddButton.setOnMouseClicked(this::onAddPhone);

    }

    private void onAddPhone(MouseEvent event){
        String number = "none!!";
        if(!phoneNumber.getText().isEmpty()){
            number = phoneNumber.getText();
        }
        logger.info("phoneAddButton clicked ... and the phone number to add is: " + number);

    }
}
