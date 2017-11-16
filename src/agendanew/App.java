package agendanew;

import agendanew.utilities.BorderedTitledPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import agendanew.main.MainController;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        final MainController mainController = new MainController();
        final Scene scene = new Scene(mainController.parent);
        scene.getStylesheets().add(getClass().getResource("utilities/bordered_titled_pane.css").toExternalForm());
        primaryStage.setTitle("Agenda telefónica");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

//    private GridPane buildCustomGridPane() throws IOException {
//
//        GridPane gridPane = new GridPane();
//
//        FXMLLoader loaderPersonListView = new FXMLLoader(getClass().getResource(PERSON_LIST_VIEW));
//        loaderPersonListView.setController(new MainController());
//        gridPane.add(loaderPersonListView.load(), 0,0);
//
//        return gridPane;
//    }

    public static void main(String[] args) {
        launch(args);
    }
}
