package agendanew.phonesoutput;

import agendanew.ViewLoader;
import agendanew.events.ShowPhonesEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.util.List;
import java.util.logging.Logger;


public class PhonesOutput extends AnchorPane {

    private static final Logger logger = Logger.getLogger(PhonesOutput.class.getSimpleName());

    @FXML
    private TableView<String> phones;

    private EventHandler<ShowPhonesEvent> handler;

    public PhonesOutput() {
        ViewLoader.load(this, "phonesoutput/phonesoutput.fxml");
    }

    public void refreshPhones(List<String> phonesList) {
        if(phonesList.isEmpty()){
            logger.info("TableView phones clearing ...");
            phones.getItems().clear();
        }
        else {
            logger.info("refreshing TableView phones ...");
            ObservableList<String> phonesOL = FXCollections.observableList(phonesList);
            phones.setEditable(true);
            phones.setItems(phonesOL);
            logger.info("Teléfonos: " + phonesOL);
        }

    }
}
