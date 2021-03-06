package agendanew.components.phoneinput;

import agendanew.bussines.Phone;
import agendanew.events.SavePhoneEvent;
import agendanew.events.SelectPersonEvent;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import agendanew.components.ViewLoader;
import java.util.logging.Logger;

public class PhoneInput extends GridPane {

    private static final Logger logger = Logger.getLogger(PhoneInput.class.getSimpleName());
    private static final String PHONE_INPUT_FXML = "/agendanew/phoneinput.fxml";

    @FXML
    private TextField phoneNumberTextField;
    @FXML
    private Button phoneAddButton;
    @FXML
    private Button phoneRemoveButton;
    @FXML
    private Button exitButton;

    private Integer personIdToSavePhone;
    private EventHandler<SavePhoneEvent> savePhoneEventEventHandler;

    public PhoneInput() {
        ViewLoader.load(this, PHONE_INPUT_FXML);

        phoneAddButton.setOnMouseClicked(this::onAddPhone);
        exitButton.setOnMouseClicked(this::onExit);
    }

    private void onAddPhone(MouseEvent event){
        Phone phone = new Phone(null, phoneNumberTextField.getText(), getPersonIdToSavePhone());
        SavePhoneEvent savePhoneEvent = new SavePhoneEvent(phone);
        savePhoneEventEventHandler.handle(savePhoneEvent);
        phoneNumberTextField.clear();
    }

    public void setPersonIdToSavePhone(Integer id){
        this.personIdToSavePhone = id;
    }

    private Integer getPersonIdToSavePhone(){
        return this.personIdToSavePhone;
    }

    public void setPhoneAddedButton(Boolean state){
        phoneAddButton.setDisable(!state);
    }

    public void setOnSavePhone(EventHandler<SavePhoneEvent> savePhoneEventEventHandler){
        this.savePhoneEventEventHandler = savePhoneEventEventHandler;
    }

    private void onExit(MouseEvent event){
        Platform.exit();
        System.exit(0);
    }
}
