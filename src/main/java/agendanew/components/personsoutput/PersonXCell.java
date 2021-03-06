package agendanew.components.personsoutput;

import agendanew.bussines.Person;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.event.ActionEvent;

public class PersonXCell extends ListCell<Person> {

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
            Person person = getListView().getSelectionModel().getSelectedItem();
            getListView().getItems().remove(getItem());
        }
}
