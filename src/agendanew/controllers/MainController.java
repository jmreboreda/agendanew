package agendanew.controllers;

import agendanew.events.RemovePersonStateEvent;
import agendanew.events.ShowPhonesEvent;
import agendanew.components.phonesoutput.PhonesOutput;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import agendanew.ViewLoader;
import agendanew.events.SearchPersonsEvent;
import agendanew.components.personinput.PersonInput;
import agendanew.components.phoneinput.PhoneInput;
import agendanew.components.personsoutput.PersonsOutput;
import agendanew.components.personssearch.PersonsSearch;

import java.util.List;
import java.util.logging.Logger;

public class MainController extends HBox {

    private static final Logger logger = Logger.getLogger(MainController.class.getSimpleName());

    private static final String SCHEDULE = "Agenda telefónica";

    public final Parent parent;

    @FXML
    private PersonsSearch personsSearch;
    @FXML
    private PersonsOutput personsOutput;
    @FXML
    private PersonInput personInput;
    @FXML
    private PhonesOutput phonesOutput;
    @FXML
    private PhoneInput phoneInput;


    public MainController() {
        this.setPadding(new Insets(15,10,5,10));
        this.parent = ViewLoader.load(this, "main.fxml");
    }

    @FXML
    public void initialize() {

        final EventHandler<SearchPersonsEvent> handler = new EventHandler<SearchPersonsEvent>() {
            @Override
            public void handle(SearchPersonsEvent event) {
                String pattern = event.pattern;
                personsOutput.refreshPersons(pattern);
            }
        };

        personsSearch.setHandlerOnNamePatternChanged(handler);


        final EventHandler<ShowPhonesEvent> handler2 = new EventHandler<ShowPhonesEvent>() {
            @Override
            public void handle(ShowPhonesEvent event) {
                List<String> phones = event.getPhones();
                phonesOutput.refreshPhones(phones);
            }
        };

        personsOutput.setHandlerOnShowPhones(handler2);

        final EventHandler<RemovePersonStateEvent> handler3 = new EventHandler<RemovePersonStateEvent>() {
            @Override
            public void handle(RemovePersonStateEvent event) {
                Boolean state = event.getState();
                personInput.refreshRemovePersonButtonState(state);
            }
        };

        personsOutput.setHandlerOnStateRemovePersonButton(handler3);
    }
}
