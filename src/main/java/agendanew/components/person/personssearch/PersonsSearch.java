package agendanew.components.person.personssearch;

import agendanew.components.ViewLoader;
import agendanew.components.person.personssearch.events.SearchPersonsEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import java.util.logging.Logger;


public class PersonsSearch extends AnchorPane {

    private static final Logger logger = Logger.getLogger(PersonsSearch.class.getSimpleName());
    private static final String PERSONS_SEARCH_FXML = "/agendanew/personssearch.fxml";
    private EventHandler<SearchPersonsEvent> onNamePatternChangedEventHandler;

    @FXML
    private TextField personNamePattern;

    public PersonsSearch() {
        ViewLoader.load(this, PERSONS_SEARCH_FXML);
    }

    @FXML
    public void initialize() {
        personNamePattern.setOnKeyReleased(this::onPersonNamePatternChanged);
    }

    private void onPersonNamePatternChanged(KeyEvent keyEvent) {
        String pattern = personNamePattern.getText();
        final SearchPersonsEvent searchPersonsEvent = new SearchPersonsEvent(pattern);
        onNamePatternChangedEventHandler.handle(searchPersonsEvent);
    }

    public void setOnSearchPersons(EventHandler<SearchPersonsEvent> handler) {
        this.onNamePatternChangedEventHandler = handler;
    }
}
