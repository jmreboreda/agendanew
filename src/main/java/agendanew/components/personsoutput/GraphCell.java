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

public class GraphCell {

    static class XCell extends ListCell<Person> {
        HBox hbox = new HBox();
        Label label = new Label("");
        Pane pane = new Pane();
        Button button = new Button("[X]");

        public XCell() {
            super();

            hbox.getChildren().addAll(label, pane, button);
            HBox.setHgrow(pane, Priority.ALWAYS);
            button.setStyle("-fx-text-fill: #8b0000");
            button.setTooltip(new Tooltip("Eliminar la persona"));

            button.setOnAction(this::onRemovePerson);
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


        private void onRemovePerson(ActionEvent event){

            getListView().getItems().remove(getItem());
        }
    }
}
