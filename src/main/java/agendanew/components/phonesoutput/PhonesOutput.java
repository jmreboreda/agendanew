package agendanew.components.phonesoutput;

import agendanew.bussines.Person;
import agendanew.bussines.Phone;
import agendanew.components.ViewLoader;
import agendanew.controllers.PhoneController;
import agendanew.events.RemovePhoneEvent;
import agendanew.events.SelectPersonEvent;
import agendanew.events.ShowPhonesEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
            ObservableList<Phone> listPersonsWhoMatchPattern = FXCollections.observableList(phonesList);

            phones = new ListView<>(listPersonsWhoMatchPattern);
            phones.setCellFactory((ListView<Phone> param) -> {
                return new PhoneXCell();
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

    public void clear(){
        if(!phones.getItems().isEmpty()) {
            phones.getItems().clear();
        }
    }
}
