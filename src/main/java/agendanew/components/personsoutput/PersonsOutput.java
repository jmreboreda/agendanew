package agendanew.components.personsoutput;

import agendanew.bussines.Person;
import agendanew.events.PersonSelectedActionEvent;
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
    private EventHandler<PersonSelectedActionEvent> handlerStateOfPersonRemoveButton;

    @FXML
    private ListView<Person> personWhoMeetNamePattern;
    private ObservableList<Person> listPersonsWhoMatchPattern;



    public PersonsOutput() {
        ViewLoader.load(this, "/agendanew/personsoutput.fxml");
    }

    public void refreshPersons(String pattern) {


        if(pattern.isEmpty()){
            logger.info("ListView clearing ...");
            listPersonsWhoMatchPattern.clear();
        }
        else {
            logger.info("refreshing ListView ...");
            listPersonsWhoMatchPattern = retrievePersonsWhoMatchPattern(pattern);
        }
        ListView<Person> listViewWithDeleteButton = new ListView<>(listPersonsWhoMatchPattern);
        listViewWithDeleteButton.setCellFactory(param -> {
            return new GraphCell.XCell();
        });

        listViewWithDeleteButton.setMinWidth(295);
        listViewWithDeleteButton.setMaxHeight(375);
        this.getChildren().add(listViewWithDeleteButton);

        listViewWithDeleteButton.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> onSelectPerson(newValue));

    }

    private ObservableList<Person> retrievePersonsWhoMatchPattern(String pattern){

        Person person1 = new Person(1, "Bohr","","Niels");
        Person person2 = new Person(2, "Einstein","","Albert");
        Person person3 = new Person(3, "Feynman","","Richard P.");
        Person person4 = new Person(4, "Gell-Man","","Murray");
        Person person5 = new Person(5, "Higgs","","Peter W.");
        Person person6 = new Person(6, "Nambu","","Yoichiro");
        Person person7 = new Person(7, "Thorne","","Kip");

        List<Person> personsList = new ArrayList<>();
        personsList.add(person1);
        personsList.add(person2);
        personsList.add(person3);
        personsList.add(person4);
        personsList.add(person5);
        personsList.add(person6);
        personsList.add(person7);

        return FXCollections.observableList(personsList);
    }

    private void onSelectPerson(Person newValue){

        logger.info("Selected person changed to -> " + newValue);

        if(newValue != null) {
            showPhones(newValue.toString());
        }else
        {
            showPhones(null);
        }
    }

    private void showPhones(String newValue){

        List<String> phonesList = new ArrayList<>();

        if(newValue == null){
            phonesList.clear();
            PersonSelectedActionEvent personSelectedActionEvent = new PersonSelectedActionEvent(false);
            handlerStateOfPersonRemoveButton.handle(personSelectedActionEvent);
        }
        else {
            PersonSelectedActionEvent personSelectedActionEvent = new PersonSelectedActionEvent(true);
            handlerStateOfPersonRemoveButton.handle(personSelectedActionEvent);
            phonesList.add("652321612");
            phonesList.add("660250639");
            if(newValue.contains("Feynman") || newValue.contains("Bohr")){
                phonesList.add("617344492");
                phonesList.add("696486497");
            }
            if(newValue.contains("Einstein")){
                phonesList.add("to infinity and beyond ...");
            }
        }
        final ShowPhonesEvent showPhonesEvent = new ShowPhonesEvent(phonesList);
        handler.handle(showPhonesEvent);
    }

    public void setHandlerOnShowPhones(EventHandler<ShowPhonesEvent> handler){
        this.handler = handler;
    }

    public void setHandlerOnStateRemovePersonActivator(EventHandler<PersonSelectedActionEvent> handler){
        this.handlerStateOfPersonRemoveButton = handler;}

}
