package agendanew.main;

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

        Pane pane = new Pane();
        BorderedTitledPane btp = new BorderedTitledPane("Datos del personal", pane);
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 12, 15, 12));

        vbox.getChildren().add(personsSearch);
        vbox.getChildren().add(personsOutput);
        btp.getChildren().add(vbox);
        this.getChildren().add(btp);


        final EventHandler<SearchPersonsEvent> handler = new EventHandler<SearchPersonsEvent>() {
            @Override
            public void handle(SearchPersonsEvent event) {
                String pattern = event.pattern;
                personsOutput.refresh(pattern);
            }
        };

        personsSearch.setHandlerOnNamePatternChanged(handler);
    }
}
