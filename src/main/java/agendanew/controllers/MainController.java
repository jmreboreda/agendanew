package agendanew.controllers;

import agendanew.bussines.Person;
import agendanew.bussines.Phone;
import agendanew.components.ViewLoader;
import agendanew.components.personinput.PersonInput;
import agendanew.components.personsoutput.PersonsOutput;
import agendanew.components.personssearch.PersonsSearch;
import agendanew.components.phoneinput.PhoneInput;
import agendanew.components.phonesoutput.PhonesOutput;
import agendanew.events.SelectPersonEvent;
import agendanew.events.SearchPersonsEvent;
import agendanew.events.ShowPhonesEvent;
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
        personsSearch.setOnSearchPersons(this::onSearchPersons);
        personsOutput.setOnSelectPerson(this::onSelectPerson);
    }

    private void onSearchPersons(SearchPersonsEvent searchPersonsEvent){
        final String pattern = searchPersonsEvent.getPattern();
        if(pattern.isEmpty()){
            personsOutput.clear();
            phonesOutput.clear();
            return;
        }
        final List<Person> persons = findPersonByNamePattern(pattern);
        refreshPersons(persons);
    }

    private void onSelectPerson(SelectPersonEvent selectPersonEvent){
        final Person selectedPerson = selectPersonEvent.getPerson();
        if(selectedPerson != null) {
            final List<Phone> phones = retrievePhones(selectedPerson);
            refreshPhones(phones);
        }
    }

    private void onShowPhones(ShowPhonesEvent showPhonesEvent){
        List<Phone> phones = showPhonesEvent.getPhones();
        refreshPhones(phones);
    }

    private List<Person> findPersonByNamePattern(String pattern){
        PersonController controller = new PersonController();
        List<Person> personList = controller.findPersonByNamePattern(pattern);

        return personList;
    }

    private List<Phone> retrievePhones(Person person){
        PhoneController controller = new PhoneController();

        return controller.findPhoneByPerson(person);
    }

    private void refreshPersons(List<Person> persons) {
        if(persons.isEmpty()){
            personsOutput.clear();
        }
        personsOutput.refresh(persons);
        phonesOutput.clear();
    }

    private void refreshPhones(List<Phone> phones){
        if(phones.isEmpty()){
            phonesOutput.clear();
        }
        phonesOutput.refresh(phones);
    }


}

