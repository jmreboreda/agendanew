package agendanew.personsoutput;

import agendanew.events.SearchPersonsEvent;
import agendanew.events.ShowPhonesEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import agendanew.ViewLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PersonsOutput extends AnchorPane {

    private static final Logger logger = Logger.getLogger(PersonsOutput.class.getSimpleName());

    private EventHandler<ShowPhonesEvent> handler;

    @FXML
    private ListView<String> personWhoMeetNamePattern;
    private ObservableList<String> listPersonsWhoMatchPattern;



    public PersonsOutput() {
        ViewLoader.load(this, "personsoutput/personsoutput.fxml");
    }

    @FXML
    public void initialize() {

        personWhoMeetNamePattern.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> showPhonesOnSelectPerson(newValue));
    }

    public void refresh(String pattern) {
        if(pattern.isEmpty()){
            logger.info("ListView clearing ...");
            listPersonsWhoMatchPattern.clear();
        }
        else {
            logger.info("refreshing ListView ...");
            listPersonsWhoMatchPattern = retrievePersonsWhoMatchPattern(pattern);
        }
        personWhoMeetNamePattern.setItems(listPersonsWhoMatchPattern);
    }

    private ObservableList<String> retrievePersonsWhoMatchPattern(String pattern){

        List<String> personsList = new ArrayList<>();
        personsList.add("Bohr, Niels");
        personsList.add("Einstein, Albert");
        personsList.add("Feynman, Richard P.");
        personsList.add("Gell-Mann, Murray");

        return FXCollections.observableList(personsList);
    }

    private void showPhonesOnSelectPerson(String newValue){

        logger.info("Selected person changed to -> " + newValue);

        List<String> phonesList = new ArrayList<>();
        if(newValue == null){
            phonesList.clear();
        }
        else {
            phonesList.add("652321612");
            phonesList.add("660250639");
        }
        final ShowPhonesEvent showPhonesEvent = new ShowPhonesEvent(phonesList);
        handler.handle(showPhonesEvent);

    }

    public void setHandlerOnShowPhones(EventHandler<ShowPhonesEvent> handler){
        this.handler = handler;
    }

}
