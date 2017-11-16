package agendanew.personsoutput;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import agendanew.ViewLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PersonsOutput extends AnchorPane {

    private static final Logger logger = Logger.getLogger(PersonsOutput.class.getSimpleName());

    @FXML
    private ListView<String> personWhoMeetNamePattern;

    private ObservableList<String> listPersonsWhoMatchPattern;



    public PersonsOutput() {
        ViewLoader.load(this, "personsoutput/personsoutput.fxml");
    }

    public void refresh(String pattern) {
        if(pattern.isEmpty()){
            logger.info("ListView clearing ...");
            listPersonsWhoMatchPattern.clear();
        }
        else {
            logger.info("refreshing ListView ...");
            listPersonsWhoMatchPattern = retrievePersonsWhoMatchPattern(pattern);
        }
        personWhoMeetNamePattern.setItems(listPersonsWhoMatchPattern);
    }

    private ObservableList<String> retrievePersonsWhoMatchPattern(String pattern){

        List<String> personsList = new ArrayList<>();
        personsList.add("Bohr, Niels");
        personsList.add("Einstein, Albert");
        personsList.add("Feynman, Richard P.");
        personsList.add("Gell-Mann, Murray");

        return FXCollections.observableList(personsList);
    }

//    personWhoMeetNamePattern
//            .getSelectionModel().selectedItemProperty()
//    .addListener(new ChangeListener<String>() {
//        @Override
//        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//            System.out.println("ListView selection changed from oldValue = "
//                    + oldValue + " to newValue = " + newValue);
//        }
//    });


}
