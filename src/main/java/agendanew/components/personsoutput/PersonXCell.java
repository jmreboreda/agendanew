package agendanew.components.personsoutput;

import agendanew.domain.Person;
import agendanew.components.personsoutput.events.RemovePersonEvent;
import agendanew.utilities.Message;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class PersonXCell extends ListCell<Person> {

    private EventHandler<RemovePersonEvent> removePersonEventEventHandler;

        HBox hbox = new HBox();
        Label label = new Label("");
        Pane pane = new Pane();
        Label xLabel = new Label(" X ");

        public PersonXCell() {
            super();

            hbox.getChildren().addAll(label, pane, xLabel);
            HBox.setHgrow(pane, Priority.ALWAYS);
            xLabel.setStyle("-fx-text-fill: #8b0000");
            xLabel.setTooltip(new Tooltip("Eliminar la persona (y sus teléfonos asociados)"));

            xLabel.setOnMouseClicked(e -> onRemovePerson());
        }

        @Override
        protected void updateItem(Person item, boolean empty) {
            super.updateItem(item, empty);
            setText(null);
            setGraphic(null);

            if (item != null && !empty) {
                label.setText(item.toString());
                setGraphic(hbox);
            }
        }

    private void onRemovePerson(){
        Message message = new Message();
        Person personSelected = getListView().getSelectionModel().getSelectedItem();
        if (message.confirmationMessage("Mensaje del sistema","¿ Desea eliminar a " + personSelected.toString() + " ?")) {
            RemovePersonEvent removePersonEvent = new RemovePersonEvent(personSelected);
            removePersonEventEventHandler.handle(removePersonEvent);
            getListView().getItems().remove(getItem());
        }
    }

    public void setRemovePersonEventHandler(EventHandler<RemovePersonEvent> removePersonEventHandler){
        this.removePersonEventEventHandler = removePersonEventHandler;
    }
}
