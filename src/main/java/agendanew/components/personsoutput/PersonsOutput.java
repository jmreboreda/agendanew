package agendanew.components.personsoutput;

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
    private ListView<String> personWhoMeetNamePattern;
    private ObservableList<String> listPersonsWhoMatchPattern;



    public PersonsOutput() {
        ViewLoader.load(this, "/agendanew/personsoutput.fxml");
    }

    @FXML
    public void initialize() {

//        personWhoMeetNamePattern.getSelectionModel().selectedItemProperty()
//                .addListener((observable, oldValue, newValue) -> onSelectPerson(newValue));
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
        ListView<String> lv = new ListView<>(listPersonsWhoMatchPattern);
        lv.setCellFactory(param -> {
            return new GraphCell.XCell();
        });

        lv.setMinWidth(300);
        lv.setMaxHeight(375);
        this.getChildren().add(lv);

        lv.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> onSelectPerson(newValue));




        //personWhoMeetNamePattern.setItems(lv.getItems());
    }

    private ObservableList<String> retrievePersonsWhoMatchPattern(String pattern){

        List<String> personsList = new ArrayList<>();
        personsList.add("Bohr, Niels");
        personsList.add("Einstein, Albert");
        personsList.add("Feynman, Richard P.");
        personsList.add("Gell-Mann, Murray");
        personsList.add("Higgs, Peter W.");
        personsList.add("Nambu, Yoichiro ");
        personsList.add("Thorne, Kip");

        return FXCollections.observableList(personsList);
    }

    private void onSelectPerson(String newValue){

        logger.info("Selected person changed to -> " + newValue);
        showPhones(newValue);

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
