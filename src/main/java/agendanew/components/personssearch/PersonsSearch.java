package agendanew.components.personssearch;

import agendanew.bussines.Person;
import agendanew.controllers.PersonController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import agendanew.components.ViewLoader;
import agendanew.events.SearchPersonsEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PersonsSearch extends AnchorPane {

    private static final Logger logger = Logger.getLogger(PersonsSearch.class.getSimpleName());

    @FXML
    private TextField personNamePattern;

    private EventHandler<SearchPersonsEvent> handler;

    public PersonsSearch() {

        ViewLoader.load(this, "/agendanew/personssearch.fxml");
    }

    @FXML
    public void initialize() {
        personNamePattern.setOnKeyReleased(this::onPersonNamePatternChanged);
    }

    private void onPersonNamePatternChanged(KeyEvent keyEvent) {

        logger.info("Key released in personNamePattern!");

        String pattern = personNamePattern.getText();
        List<Person> persons = new ArrayList<>();

        if(pattern.isEmpty()){
            persons.clear();
        }
        else {

            PersonController controller = new PersonController();
            persons = controller.findPersonByNamePattern(personNamePattern.getText());
        }
        final SearchPersonsEvent searchPersonsEvent = new SearchPersonsEvent(persons);
        handler.handle(searchPersonsEvent);
    }

    public void setHandlerOnNamePatternChanged(EventHandler<SearchPersonsEvent> handler) {
        this.handler = handler;
    }

}
