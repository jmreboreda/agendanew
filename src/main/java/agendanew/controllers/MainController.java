package agendanew.controllers;

import agendanew.bussines.Person;
import agendanew.bussines.Phone;
import agendanew.components.ViewLoader;
import agendanew.components.personinput.PersonInput;
import agendanew.components.personsoutput.PersonsOutput;
import agendanew.components.personssearch.PersonsSearch;
import agendanew.components.phoneinput.PhoneInput;
import agendanew.components.phonesoutput.PhoneXCell;
import agendanew.components.phonesoutput.PhonesOutput;
import agendanew.events.*;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MainController extends HBox {

    private static final Logger logger = Logger.getLogger(MainController.class.getSimpleName());
    private static final String MAIN_FXML = "/agendanew/main.fxml";

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
    }

    private void onSearchPersons(SearchPersonsEvent searchPersonsEvent){
        String pattern = searchPersonsEvent.getPattern();
        if(pattern.isEmpty()){
            personsOutput.clear();
            phonesOutput.clear();
            phoneInput.setPhoneAddedButton(false);
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
            controller.createPhone(phone);
            List<Phone> phones = findPhonesByPersonId(phone.getPersonId());
            refreshPhones(phones);
        }
    }

    private void onRemovePhone(RemovePhoneEvent removePhoneEvent){
        Phone phone = removePhoneEvent.getPhone();
        PhoneController controller = new PhoneController();
        controller.removePhone(phone);
    }

    private void onRemovePerson(RemovePersonEvent removePersonEvent){
        Person person = removePersonEvent.getPerson();
        PersonController personController = new PersonController();
        personController.removePerson(person);

        PhoneController phoneController = new PhoneController();
        phoneController.removeAllPhonesOfPerson(person);
        //refreshPhones(new ArrayList<Phone>());
        phonesOutput.clear();
    }

    private List<Person> findPersonByNamePattern(String pattern){
        PersonController controller = new PersonController();
        List<Person> personList = controller.findPersonByNamePattern(pattern);

        return personList;
    }

    private List<Phone> findPhonesByPersonId(Integer id){
        PhoneController controller = new PhoneController();

        return controller.findPhonesByPersonId(id);
    }

    private List<Phone> retrievePhones(Person person){
        PhoneController controller = new PhoneController();

        return controller.findPhonesByPersonId(person.getId());
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

