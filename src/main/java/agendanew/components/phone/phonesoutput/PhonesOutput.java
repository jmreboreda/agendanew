package agendanew.components.phone.phonesoutput;

import agendanew.domain.Phone;
import agendanew.components.ViewLoader;
import agendanew.components.phone.phoneinput.events.RemovePhoneEvent;
import agendanew.components.person.personsoutput.events.SelectPersonEvent;
import agendanew.components.phone.phonesoutput.events.ShowPhonesEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class PhonesOutput extends AnchorPane {

    private static final Logger logger = Logger.getLogger(PhonesOutput.class.getSimpleName());
    private static final String PHONES_OUTPUT_FXML = "/agendanew/phonesoutput.fxml";

    @FXML
    private TextField phonesTFLabel;
    @FXML
    private ListView<Phone> phones;

    private EventHandler<SelectPersonEvent> selectPersonEventHandler;

    private EventHandler<ShowPhonesEvent> showPhonesEventEventHandler;

    private EventHandler<RemovePhoneEvent> removePhoneEventEventHandler;

    public PhonesOutput() {
        ViewLoader.load(this, PHONES_OUTPUT_FXML);
    }

    @FXML
    public void initialize() {
        phonesTFLabel.setStyle("-fx-background-color: lightgray;");
    }

    public void refresh(List<Phone> phonesList) {
        if(phonesList.isEmpty()){
            logger.info("ListView phones clearing ...");
            this.phones.getItems().clear();
        }
        else {
            phonesList = format(phonesList);
            ObservableList<Phone> listPersonsWhoMatchPattern = FXCollections.observableList(phonesList);

            phones = new ListView<>(listPersonsWhoMatchPattern);
            phones.setCellFactory((ListView<Phone> param) -> {
                PhoneXCell phoneXCell = new PhoneXCell();
                phoneXCell.setRemovePhoneEventHandler(this.removePhoneEventEventHandler);
                return phoneXCell;
            });

            phones.getSelectionModel().selectedItemProperty()
                    .addListener((observable, oldValue, newValue) -> onSelectedPhone(newValue));

            phones.relocate(0,26);
            phones.setMinWidth(175);
            phones.setMaxHeight(USE_COMPUTED_SIZE);
            this.getChildren().add(phones);
        }
    }

    private void onSelectedPhone(Phone newValue){
        logger.info("Selected phone is ... " + newValue);
    }

    public void setOnRemovePhone(EventHandler<RemovePhoneEvent> removePhoneEventEventHandler){
        this.removePhoneEventEventHandler = removePhoneEventEventHandler;

    }

    private List<Phone> format(List<Phone> phones){

        List<Phone> phoneList = new ArrayList<>();
        for(Phone phone : phones){
            String formattedStringPhone = phone.getPhoneNumber().substring(0,3) + " " + phone.getPhoneNumber().substring(3,6) + " " + phone.getPhoneNumber().substring(6,9);
            Phone phoneFormatted = new Phone(phone.getId(), formattedStringPhone, phone.getPersonId());
            phoneList.add(phoneFormatted);
        }
        return phoneList;
    }

    public void clear(){
        if(!phones.getItems().isEmpty()) {
            phones.getItems().clear();
        }
    }
}
