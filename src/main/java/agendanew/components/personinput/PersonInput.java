package agendanew.components.personinput;

import agendanew.bussines.Person;
import agendanew.components.ViewLoader;
import agendanew.controllers.PersonController;
import agendanew.events.SearchPersonsEvent;
import agendanew.managers.PersonManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.util.logging.Logger;

public class PersonInput extends GridPane{

    private static final Logger logger = Logger.getLogger(PersonInput.class.getSimpleName());
    private static final String PERSON_INPUT_FXML = "/agendanew/personinput.fxml";

    @FXML
    private TextField lastName1;
    @FXML
    private TextField lastName2;
    @FXML
    private TextField name;
    @FXML
    private Button addPersonButton;

    private String patternToRefreshPersons;
    private EventHandler<SearchPersonsEvent> searchPersonsEventEventHandler;

    public PersonInput() {
        ViewLoader.load(this, PERSON_INPUT_FXML);
        addPersonButton.setOnAction(this::onAddPerson);
    }

    private void onAddPerson(ActionEvent event){
        String message;
        Person person = buildPerson();

        PersonController controller = new PersonController();

        if(person == null){
            message = "none added person or incomplete data!";
        }else{
            Integer personId = controller.createPerson(person);

            message = person.getLastName1() + " " + person.getLastName2()
                    + ", " + person.getName() + " with id: " + personId;
            personInputClear();
        }
        logger.info("Added person: " + message);
        SearchPersonsEvent searchPersonsEvent= new SearchPersonsEvent(patternToRefreshPersons);
        searchPersonsEventEventHandler.handle(searchPersonsEvent);
    }

    public Person buildPerson() {
        if(lastName1.getText().isEmpty() ||
                lastName2.getText().isEmpty() ||
                name.getText().isEmpty()){
            return null;
        }
        return new Person(null, lastName1.getText(), lastName2.getText(), name.getText());
    }

    private void personInputClear(){
        lastName1.clear();
        lastName2.clear();
        name.clear();
    }

    public void setPatternToRefreshPersons(String pattern){
        this.patternToRefreshPersons = pattern;
    }

    public void setOnAddPerson(EventHandler<SearchPersonsEvent> searchPersonsEventEventHandler){
        this.searchPersonsEventEventHandler = searchPersonsEventEventHandler;
    }
}
