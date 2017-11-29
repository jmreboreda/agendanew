package agendanew.components.phonesoutput;

import agendanew.bussines.Phone;
import agendanew.events.RemovePhoneEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class PhoneXCell extends ListCell<Phone> {

    private EventHandler<RemovePhoneEvent> removePhoneEventEventHandler;

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
        RemovePhoneEvent removePhoneEvent = new RemovePhoneEvent(phoneSelected);
        removePhoneEventEventHandler.handle(removePhoneEvent);
        getListView().getItems().remove(getItem());
    }

    public void setRemovePhoneEventHandler(EventHandler<RemovePhoneEvent> removePhoneEventHandler){
        this.removePhoneEventEventHandler = removePhoneEventHandler;
    }
}