package agendanew.components;

import agendanew.components.person.controllers.PersonController;
import agendanew.components.phone.controllers.PhoneController;
import agendanew.domain.Person;
import agendanew.domain.Phone;
import agendanew.components.person.personinput.PersonInput;
import agendanew.components.person.personsoutput.events.RemovePersonEvent;
import agendanew.components.person.personsoutput.events.SelectPersonEvent;
import agendanew.components.person.personssearch.events.SearchPersonsEvent;
import agendanew.components.phone.phoneinput.events.RemovePhoneEvent;
import agendanew.components.phone.phoneinput.events.SavePhoneEvent;
import agendanew.components.person.personsoutput.PersonsOutput;
import agendanew.components.person.personssearch.PersonsSearch;
import agendanew.components.phone.phoneinput.PhoneInput;
import agendanew.components.phone.phonesoutput.PhoneXCell;
import agendanew.components.phone.phonesoutput.PhonesOutput;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MainController extends HBox {

    private static final Logger logger = Logger.getLogger(MainController.class.getSimpleName());
    private static final String MAIN_FXML = "/agendanew_fxml/main.fxml";

    private PersonController personController = new PersonController();
    private PhoneController phoneController = new PhoneController();

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

    private PhoneXCell phoneXCell = new PhoneXCell();

    private Phone phoneToRemove;

    public MainController() {
        this.setPadding(new Insets(15,10,5,10));
        this.parent = ViewLoader.load(this, MAIN_FXML);
    }

    @FXML
    public void initialize() {
        personsSearch.setOnSearchPersons(this::onSearchPersons);
        personsOutput.setOnSelectPerson(this::onSelectPerson);
        personsOutput.setOnRemovePerson(this::onRemovePerson);
        personInput.setOnAddPerson(this::onSearchPersons);
        phoneInput.setOnSavePhone(this::onSavePhone);
        phonesOutput.setOnRemovePhone(this::onRemovePhone);
        showInitialListOfPerson();
    }

    private void showInitialListOfPerson(){
        personController = new PersonController();
        refreshPersons(personController.findAllPersons());
    }

    private void onSearchPersons(SearchPersonsEvent searchPersonsEvent){
        String pattern = searchPersonsEvent.getPattern();
        if(pattern == null){
            pattern = "";
        }
        if(pattern.isEmpty()){
            personsOutput.clear();
            phonesOutput.clear();
            phoneInput.setPhoneAddedButton(false);
            showInitialListOfPerson();
            return;
        }
        List<Person> persons = findPersonByNamePattern(pattern);
        refreshPersons(persons);
        personInput.setPatternToRefreshPersons(pattern);
    }

    private void onSelectPerson(SelectPersonEvent selectPersonEvent){
        Person selectedPerson = selectPersonEvent.getPerson();
        if(selectedPerson != null) {
            List<Phone> phones = retrievePhones(selectedPerson);
            refreshPhones(phones);
            phoneInput.setPhoneAddedButton(true);
            phoneInput.setPersonIdToSavePhone(selectedPerson.getId());
        }
    }

    private void onSavePhone(SavePhoneEvent savePhoneEvent){
        Phone phone = savePhoneEvent.getPhone();
        if(!phone.getPhoneNumber().isEmpty()) {
            PhoneController controller = new PhoneController();
            controller.create(phone);
            List<Phone> phones = findPhonesByPersonId(phone.getPersonId());
            refreshPhones(phones);
        }
    }

    private void onRemovePhone(RemovePhoneEvent removePhoneEvent){
        Phone phone = removePhoneEvent.getPhone();
        phoneController.removePhone(phone);
    }

    private void onRemovePerson(RemovePersonEvent removePersonEvent){
        Person person = removePersonEvent.getPerson();
        personController.removePerson(person);

        phoneController.removeAllPhonesOfPerson(person.getId());
        phonesOutput.clear();
    }

    private List<Person> findPersonByNamePattern(String pattern){
        return personController.findPersonByNamePattern(pattern);
    }

    private List<Phone> findPhonesByPersonId(Integer id){
        return phoneController.findPhonesByPersonId(id);
    }

    private List<Phone> retrievePhones(Person person){
        return phoneController.findPhonesByPersonId(person.getId());
    }

    private void refreshPersons(List<Person> persons) {
        if(persons.isEmpty()){
            personsOutput.clear();
        }
        List<Person> orderedPersonsList = persons
                .stream()
                .sorted(Comparator.comparing(Person::getLastName1)).collect(Collectors.toList());
        personsOutput.refresh(orderedPersonsList);
        phonesOutput.clear();
    }

    private void refreshPhones(List<Phone> phones){
        if(phones.isEmpty()){
            phonesOutput.clear();
        }
        phonesOutput.refresh(phones);
    }
}

