package sample.main;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import sample.ViewLoader;
import sample.events.SearchPersonsEvent;
import sample.personinput.PersonInput;
import sample.phoneinput.PhoneInput;
import sample.personsoutput.PersonsOutput;
import sample.personssearch.PersonsSearch;

import java.util.logging.Logger;

public class MainController extends HBox {

    private static final Logger logger = Logger.getLogger(MainController.class.getSimpleName());

    public final Parent parent;

    @FXML
    private PersonsSearch personsSearch;
    @FXML
    private PersonsOutput personsOutput;
    @FXML
    PersonInput personInput;
    @FXML
    private PhoneInput phoneInput;


    public MainController() {
        this.parent = ViewLoader.load(this, "main/main.fxml");

    }

    @FXML
    public void initialize() {

        final EventHandler<SearchPersonsEvent> handler = new EventHandler<SearchPersonsEvent>() {
            @Override
            public void handle(SearchPersonsEvent event) {
                String pattern = event.pattern;
                personsOutput.refresh(pattern);
            }
        };

        personsSearch.setOnPatternChanged(handler);
    }
}
