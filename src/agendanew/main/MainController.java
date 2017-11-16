package agendanew.main;

import agendanew.phonesoutput.PhonesOutput;
import agendanew.utilities.BorderedTitledPane;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import agendanew.ViewLoader;
import agendanew.events.SearchPersonsEvent;
import agendanew.personinput.PersonInput;
import agendanew.phoneinput.PhoneInput;
import agendanew.personsoutput.PersonsOutput;
import agendanew.personssearch.PersonsSearch;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.logging.Logger;

public class MainController extends HBox {

    private static final Logger logger = Logger.getLogger(MainController.class.getSimpleName());

    private static final String PERSONS = "Personas: apellidos y nombre";
    private static final String PHONES = "Teléfonos: número y tipo";

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
        this.parent = ViewLoader.load(this, "main/main.fxml");

    }

    @FXML
    public void initialize() {

        showUI();

        final EventHandler<SearchPersonsEvent> handler = new EventHandler<SearchPersonsEvent>() {
            @Override
            public void handle(SearchPersonsEvent event) {
                String pattern = event.pattern;
                personsOutput.refresh(pattern);
            }
        };

        personsSearch.setHandlerOnNamePatternChanged(handler);
    }

    private void showUI(){

        /* Persons */
        Pane panePersons = new Pane();
        BorderedTitledPane btpPersons = new BorderedTitledPane(PERSONS, panePersons);

        VBox vboxPersons = new VBox();
        vboxPersons.setPadding(new Insets(15, 12, 15, 12));
        vboxPersons.getChildren().add(personsSearch);
        vboxPersons.getChildren().add(personsOutput);
        vboxPersons.getChildren().add(personInput);
        btpPersons.getChildren().add(vboxPersons);
        this.getChildren().add(btpPersons);

        /* Phones */
        Pane panePhones = new Pane();
        BorderedTitledPane btpPhones = new BorderedTitledPane(PHONES, panePhones);

        VBox vboxPhones = new VBox();
        vboxPhones.setPadding(new Insets(15, 12, 15, 12));
        vboxPhones.getChildren().add(phonesOutput);
        vboxPhones.getChildren().add(phoneInput);
        btpPhones.getChildren().add(vboxPhones);
        this.getChildren().add(btpPhones);
    }
}
