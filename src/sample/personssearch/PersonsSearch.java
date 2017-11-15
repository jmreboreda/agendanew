package sample.personssearch;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import sample.ViewLoader;
import sample.events.SearchPersonsEvent;

import java.util.logging.Logger;

public class PersonsSearch extends AnchorPane {

    private static final Logger logger = Logger.getLogger(PersonsSearch.class.getSimpleName());

    @FXML
    private TextField personNamePattern;

    private EventHandler<SearchPersonsEvent> handler;

    public PersonsSearch() {
        ViewLoader.load(this, "personssearch/personssearch.fxml");
    }

    @FXML
    public void initialize() {
        personNamePattern.setOnKeyReleased(this::onPersonNamePatternChanged);
    }

    private void onPersonNamePatternChanged(KeyEvent keyEvent) {
        logger.info("click on lambda button! let's handle handler!");
        final String pattern = personNamePattern.getText();
        final SearchPersonsEvent searchPersonsEvent = new SearchPersonsEvent(pattern);
        handler.handle(searchPersonsEvent);
    }



    public void setOnPatternChanged(EventHandler<SearchPersonsEvent> handler) {
        this.handler = handler;
    }

}
