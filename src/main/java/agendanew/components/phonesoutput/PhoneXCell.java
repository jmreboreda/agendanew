package agendanew.components.phonesoutput;

import agendanew.bussines.Person;
import agendanew.bussines.Phone;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

import java.beans.EventHandler;

public class PhoneXCell extends ListCell<Phone> {

    HBox hbox = new HBox();
    Label label = new Label("");
    Pane pane = new Pane();
    Label xLabel = new Label(" X ");

    public PhoneXCell() {
        super();
        hbox.getChildren().addAll(label, pane, xLabel);
        HBox.setHgrow(pane, Priority.ALWAYS);
        xLabel.setStyle("-fx-text-fill: #8b0000");
        xLabel.setTooltip(new Tooltip("Eliminar el teléfono para esta persona"));

        xLabel.setOnMouseClicked(e -> onRemovePhone());
    }

    @Override
    protected void updateItem(Phone item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);
        setGraphic(null);

        if (item != null && !empty) {
            label.setText(item.toString());
            setGraphic(hbox);
        }
    }

    private void onRemovePhone(){
        Phone phoneSelected = getListView().getSelectionModel().getSelectedItem();
        getListView().getItems().remove(getItem());
    }
}
