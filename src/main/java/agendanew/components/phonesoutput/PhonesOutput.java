package agendanew.components.phonesoutput;

import agendanew.bussines.Phone;
import agendanew.components.ViewLoader;
import agendanew.events.PhoneSelectedActionEvent;
import agendanew.events.SelectPersonEvent;
import agendanew.events.ShowPhonesEvent;
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
    private static final String PHONES_OUTPUT_FXML = "/agendanew/phonesoutput.fxml";


    @FXML
    private ListView<Phone> phones;

    private EventHandler<SelectPersonEvent> selectPersonEventHandler;

    private EventHandler<ShowPhonesEvent> showPhonesEventEventHandler;
    private EventHandler<PhoneSelectedActionEvent> handlerStateOfPhoneRemoveButton;

    public PhonesOutput() {
        ViewLoader.load(this, PHONES_OUTPUT_FXML);
    }

    @FXML
    public void initialize() {
        phones.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> onSelectedPhone(newValue));
    }

    private void onSelectedPhone(Phone newValue){
        logger.info("Selected phone is ... " + newValue);
//        Boolean enableRemovePhoneInputActuator = false;
//        if(newValue == null){
//            PhoneSelectedActionEvent phoneSelectedActionEvent = new PhoneSelectedActionEvent(enableRemovePhoneInputActuator);
//            handlerStateOfPhoneRemoveButton.handle(phoneSelectedActionEvent);
//        }else{
//            enableRemovePhoneInputActuator = true;
//            PhoneSelectedActionEvent phoneSelectedActionEvent = new PhoneSelectedActionEvent(enableRemovePhoneInputActuator);
//            handlerStateOfPhoneRemoveButton.handle(phoneSelectedActionEvent);
//        }
    }

    public void refresh(List<Phone> phones) {
        if(phones.isEmpty()){
            logger.info("ListView phones clearing ...");
            this.phones.getItems().clear();
        }
        else {
            logger.info("Refreshing ListView phones ...");
            ObservableList<Phone> phonesOL = FXCollections.observableList(phones);
            this.phones.setItems(phonesOL);
        }
    }

    public void setOnSelectPerson(EventHandler<SelectPersonEvent> selectPersonEventHandler){
        this.selectPersonEventHandler = selectPersonEventHandler;
    }

    public void setOnShowPhones(EventHandler<ShowPhonesEvent> handler){
        this.showPhonesEventEventHandler = handler;
    }

    public void clear(){
        phones.getItems().clear();
    }

    public void setHandlerStateOfPhoneRemoveActivator(EventHandler<PhoneSelectedActionEvent> handler){
        this.handlerStateOfPhoneRemoveButton = handler;
    }
}
