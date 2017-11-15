package sample.phoneinput;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import sample.ViewLoader;

import java.util.logging.Logger;

public class PhoneInput extends HBox {

    private static final Logger logger = Logger.getLogger(PhoneInput.class.getSimpleName());


    @FXML
    private TextField numPhone;
    @FXML
    private Button addPhone;

    public PhoneInput() {
        ViewLoader.load(this, "phoneinput/phoneinput.fxml");
        addPhone.setOnMouseClicked(this::onAddPhone);

    }

    private void onAddPhone(MouseEvent event){
        String number = "none!!";
        if(!numPhone.getText().isEmpty()){
            number = numPhone.getText();
        }
        logger.info("AddPhone button clicked ... and the phone number to add is: " + number);

    }
}
