package agendanew.components.personssearch;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import agendanew.ViewLoader;
import agendanew.events.SearchPersonsEvent;

import java.util.logging.Logger;

public class PersonsSearch extends AnchorPane {

    private static final Logger logger = Logger.getLogger(PersonsSearch.class.getSimpleName());

    @FXML
    private TextField personNamePattern;

    private EventHandler<SearchPersonsEvent> handler;

    public PersonsSearch() {

        ViewLoader.load(this, "components/personssearch/personssearch.fxml");
    }

    @FXML
    public void initialize() {
        personNamePattern.setOnKeyReleased(this::onPersonNamePatternChanged);
    }

    private void onPersonNamePatternChanged(KeyEvent keyEvent) {
        logger.info("Key released in personNamePattern! let's handle handler!");
        final String pattern = personNamePattern.getText();
        final SearchPersonsEvent searchPersonsEvent = new SearchPersonsEvent(pattern);
        handler.handle(searchPersonsEvent);
    }



    public void setHandlerOnNamePatternChanged(EventHandler<SearchPersonsEvent> handler) {
        this.handler = handler;
    }

}
