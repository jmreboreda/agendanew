package agendanew.controllers;

import agendanew.bussines.Person;
import agendanew.components.ViewLoader;
import agendanew.components.personinput.PersonInput;
import agendanew.components.personsoutput.PersonsOutput;
import agendanew.components.personssearch.PersonsSearch;
import agendanew.components.phoneinput.PhoneInput;
import agendanew.components.phonesoutput.PhonesOutput;
import agendanew.events.PersonSelectedActionEvent;
import agendanew.events.PhoneSelectedActionEvent;
import agendanew.events.SearchPersonsEvent;
import agendanew.events.ShowPhonesEvent;
import agendanew.persistence.PersonDB;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
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
        this.parent = ViewLoader.load(this, "/agendanew/main.fxml");
    }

    @FXML
    public void initialize() {

        final EventHandler<SearchPersonsEvent> searchPersonsEventHandler = new EventHandler<SearchPersonsEvent>() {
            @Override
            public void handle(SearchPersonsEvent event) {
                List<Person> persons = event.getPersons();
                personsOutput.refreshPersons(persons);
            }
        };

        personsSearch.setHandlerOnNamePatternChanged(searchPersonsEventHandler);


        final EventHandler<ShowPhonesEvent> handler2 = new EventHandler<ShowPhonesEvent>() {
            @Override
            public void handle(ShowPhonesEvent event) {
                List<String> phones = event.getPhones();
                phonesOutput.refreshPhones(phones);
            }
        };

        personsOutput.setHandlerOnShowPhones(handler2);

        final EventHandler<PersonSelectedActionEvent> handler3 = new EventHandler<PersonSelectedActionEvent>() {
            @Override
            public void handle(PersonSelectedActionEvent event) {
                Boolean state = event.getState();
                phoneInput.setStateOfActivatorOfAddPhone(state);
            }
        };

        personsOutput.setHandlerOnAddNewPhone(handler3);

        final EventHandler<PhoneSelectedActionEvent> handler4 = new EventHandler<PhoneSelectedActionEvent>() {
            @Override
            public void handle(PhoneSelectedActionEvent event) {
                Boolean state = event.getState();
                phoneInput.setPhoneRemoveActivator(state);
            }
        };

        phonesOutput.setHandlerStateOfPhoneRemoveActivator(handler4);
    }
}

