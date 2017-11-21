package agendanew;

import agendanew.utilities.BorderedTitledPane;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import agendanew.controllers.MainController;
import javafx.stage.StageStyle;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        final MainController mainController = new MainController();
        BorderedTitledPane btp = new BorderedTitledPane("Agenda telefónica", mainController);
        final Scene scene = new Scene(btp);
        scene.getStylesheets().add(getClass().getResource("utilities/bordered_titled_pane.css").toExternalForm());
        primaryStage.setTitle("Gestoría MOLDES - María Elena González Moldes");

        primaryStage.setMaxWidth(612);
        primaryStage.setMaxHeight(650);
        primaryStage.setMinWidth(612);
        primaryStage.setMinHeight(650);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
