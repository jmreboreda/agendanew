package agendanew.components.personsoutput;

import agendanew.bussines.Person;
import agendanew.controllers.PersonController;
import agendanew.events.PersonSelectedActionEvent;
import agendanew.events.ShowPhonesEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import agendanew.components.ViewLoader;
import agendanew.managers.PersonManager;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PersonsOutput extends AnchorPane {

    private static final Logger logger = Logger.getLogger(PersonsOutput.class.getSimpleName());

    private EventHandler<ShowPhonesEvent> showPhonesEventEventHandler;
    private EventHandler<PersonSelectedActionEvent> handlerStateOfAddPhoneButton;
    @FXML
    private ListView<Person> personWhoMeetNamePattern;
    //private ObservableList<Person> listPersonsWhoMatchPattern;

    public PersonsOutput() {
        ViewLoader.load(this, "/agendanew/personsoutput.fxml");
    }

    public void refreshPersons(List<Person> persons) {

        ObservableList<Person> listPersonsWhoMatchPattern = FXCollections.observableList(persons);

        ListView<Person> listViewWithDeleteLabel = new ListView<>(listPersonsWhoMatchPattern);
        listViewWithDeleteLabel.setCellFactory(param -> {
            return new PersonXCell();
        });

        listViewWithDeleteLabel.setMinWidth(295);
        listViewWithDeleteLabel.setMaxHeight(375);
        this.getChildren().add(listViewWithDeleteLabel);

        listViewWithDeleteLabel.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> onSelectPerson(newValue));

    }

    private ObservableList<Person> retrievePersonsWhoMatchPattern(String pattern){

     PersonController controller = new PersonController();
     List<Person> personList = controller.findPersonByNamePattern(pattern);

     return FXCollections.observableList(personList);

    }

    private void onSelectPerson(Person newValue){

        logger.info("Selected person changed to -> " + newValue);

        if(newValue != null) {
            showPhones(newValue.toString());

            PersonSelectedActionEvent event = new PersonSelectedActionEvent(true);
            handlerStateOfAddPhoneButton.handle(event);
        }else
        {
            showPhones(null);

            PersonSelectedActionEvent event = new PersonSelectedActionEvent(false);
            handlerStateOfAddPhoneButton.handle(event);
        }

    }

    private void showPhones(String newValue){

        List<String> phonesList = new ArrayList<>();

        if(newValue == null){
            phonesList.clear();
        }
        else {
            phonesList.add("652321612");
            phonesList.add("660250639");
            if(newValue.contains("Feynman") || newValue.contains("Bohr")){
                phonesList.add("617344492");
                phonesList.add("696486497");
            }
            if(newValue.contains("Einstein")){
                phonesList.add("666999666");
            }
        }
        final ShowPhonesEvent showPhonesEvent = new ShowPhonesEvent(phonesList);
        showPhonesEventEventHandler.handle(showPhonesEvent);
    }

    public void setHandlerOnShowPhones(EventHandler<ShowPhonesEvent> handler){
        this.showPhonesEventEventHandler = handler;
    }

    public void setHandlerOnAddNewPhone(EventHandler<PersonSelectedActionEvent> handler){
        this.handlerStateOfAddPhoneButton = handler;
    }
}
