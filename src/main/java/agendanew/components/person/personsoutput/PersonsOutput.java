package agendanew.components.person.personsoutput;

import agendanew.domain.Person;
import agendanew.components.person.personsoutput.events.RemovePersonEvent;
import agendanew.components.person.personsoutput.events.SelectPersonEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import agendanew.components.ViewLoader;

import java.util.List;
import java.util.logging.Logger;

public class PersonsOutput extends AnchorPane {

    private static final Logger logger = Logger.getLogger(PersonsOutput.class.getSimpleName());
    private static final String PERSONS_OUTPUT_FXML = "/agendanew_fxml/personsoutput.fxml";

    private EventHandler<SelectPersonEvent> selectPersonEventEventHandler;
    @FXML
    private ListView<Person> personWhoMeetNamePattern;

    private EventHandler<RemovePersonEvent> removePersonEventEventHandler;

    public PersonsOutput() {
        ViewLoader.load(this, PERSONS_OUTPUT_FXML);
    }

    public void refresh(List<Person> persons) {
        ObservableList<Person> listPersonsWhoMatchPattern = FXCollections.observableList(persons);

        personWhoMeetNamePattern = new ListView<>(listPersonsWhoMatchPattern);
        personWhoMeetNamePattern.setCellFactory(param -> {
            PersonXCell personXCell = new PersonXCell();
            personXCell.setRemovePersonEventHandler(this.removePersonEventEventHandler);
            return personXCell;
        });

        personWhoMeetNamePattern.setMinWidth(295);
        personWhoMeetNamePattern.setMaxHeight(USE_COMPUTED_SIZE);
        this.getChildren().add(personWhoMeetNamePattern);

        personWhoMeetNamePattern.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newPersonValue) -> onSelectPerson(newPersonValue));
    }

    public void clear(){
        if(!personWhoMeetNamePattern.getItems().isEmpty()){
            personWhoMeetNamePattern.getItems().clear();
        }
    }

    private void onSelectPerson(Person person){
        logger.info("Selected person changed to -> " + person);
        SelectPersonEvent selectPersonEvent = new SelectPersonEvent(person);
        selectPersonEventEventHandler.handle(selectPersonEvent);
    }

    public void setOnSelectPerson(EventHandler<SelectPersonEvent> selectPersonEventEventHandler){
        this.selectPersonEventEventHandler = selectPersonEventEventHandler;
    }

    public void setOnRemovePerson(EventHandler<RemovePersonEvent> removePersonEventEventHandler){
        this.removePersonEventEventHandler = removePersonEventEventHandler;
    }

    public Person getSelectedPerson() {
        return personWhoMeetNamePattern.getSelectionModel().getSelectedItem();
    }
}
