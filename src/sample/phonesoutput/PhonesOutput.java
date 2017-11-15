package sample.phonesoutput;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import sample.ViewLoader;

public class PhonesOutput extends AnchorPane {

    @FXML
    private TableView phones;

    public PhonesOutput() {
        ViewLoader.load(this, "phonesoutput/phonesoutput.fxml");

    }
}
