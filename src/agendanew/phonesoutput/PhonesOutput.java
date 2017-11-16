package agendanew.phonesoutput;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import agendanew.ViewLoader;

public class PhonesOutput extends AnchorPane {

    @FXML
    private TableView phones;

    public PhonesOutput() {
        ViewLoader.load(this, "phonesoutput/phonesoutput.fxml");

    }
}
