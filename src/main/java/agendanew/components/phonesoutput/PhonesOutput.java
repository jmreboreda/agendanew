package agendanew.components.phonesoutput;

import agendanew.components.ViewLoader;
import agendanew.events.PhoneSelectedActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.util.List;
import java.util.logging.Logger;


public class PhonesOutput extends AnchorPane {

    private static final Logger logger = Logger.getLogger(PhonesOutput.class.getSimpleName());

    @FXML
    private ListView<String> phones;

    private EventHandler<PhoneSelectedActionEvent> handlerStateOfPhoneRemoveButton;

    public PhonesOutput() {

        ViewLoader.load(this, "/agendanew/phonesoutput.fxml");
    }

    @FXML
    public void initialize() {

        phones.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> onSelectedPhone(newValue));
    }

    private void onSelectedPhone(String newValue){
        logger.info("Selected phone is ... " + newValue);
        Boolean enableRemovePhoneInputActuator = false;
        if(newValue == null){
            PhoneSelectedActionEvent phoneSelectedActionEvent = new PhoneSelectedActionEvent(enableRemovePhoneInputActuator);
            handlerStateOfPhoneRemoveButton.handle(phoneSelectedActionEvent);
        }else{
            enableRemovePhoneInputActuator = true;
            PhoneSelectedActionEvent phoneSelectedActionEvent = new PhoneSelectedActionEvent(enableRemovePhoneInputActuator);
            handlerStateOfPhoneRemoveButton.handle(phoneSelectedActionEvent);
        }

    }

    public void refreshPhones(List<String> phonesList) {
        if(phonesList.isEmpty()){
            logger.info("ListView phones clearing ...");
            phones.getItems().clear();
        }
        else {
            logger.info("Refreshing ListView phones ...");
            ObservableList<String> phonesOL = FXCollections.observableList(phonesList);
            phones.setItems(phonesOL);
        }
    }

    public void setHandlerStateOfPhoneRemoveActivator(EventHandler<PhoneSelectedActionEvent> handler){
        this.handlerStateOfPhoneRemoveButton = handler;
    }
}
