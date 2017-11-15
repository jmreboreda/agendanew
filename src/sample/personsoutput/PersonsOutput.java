package sample.personsoutput;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import sample.ViewLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PersonsOutput extends AnchorPane {

    private static final Logger logger = Logger.getLogger(PersonsOutput.class.getSimpleName());

    @FXML
    private ListView personWhoMeetNamePattern;

    private ObservableList<String> listPersonsWithPattern;

    public PersonsOutput() {
        ViewLoader.load(this, "personsoutput/personsoutput.fxml");
    }

    public void refresh(String pattern) {
        if(pattern.isEmpty()){
            logger.info("ListView clearing ...");
            listPersonsWithPattern.clear();
        }
        else {
            logger.info("refreshing ListView ...");
            listPersonsWithPattern = retrievePersonsWithPattern(pattern);
        }
        personWhoMeetNamePattern.setItems(listPersonsWithPattern);
    }

    private ObservableList<String> retrievePersonsWithPattern(String pattern){

        List<String> personsList = new ArrayList<>();
        personsList.add("Einstein, Albert");
        personsList.add("Feynman, Richard P.");
        personsList.add("Gell-Mann, Murray");

        return FXCollections.observableList(personsList);
    }


}
