package agendanew;

import agendanew.utilities.BorderedTitledPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import agendanew.controllers.MainController;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        final MainController mainController = new MainController();
        BorderedTitledPane btp = new BorderedTitledPane("Agenda telefónica", mainController);
        final Scene scene = new Scene(btp);
        scene.getStylesheets().add(getClass().getResource("utilities/bordered_titled_pane.css").toExternalForm());
        primaryStage.setTitle("Gestoría MOLDES - María Elena González Moldes");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
