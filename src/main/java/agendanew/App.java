package agendanew;

import agendanew.components.BorderedTitledPane;
import agendanew.utilities.EmailSenderService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import agendanew.components.MainController;

public class App extends Application {

    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        App.primaryStage = primaryStage;
        final MainController mainController = new MainController();
        BorderedTitledPane btp = new BorderedTitledPane("Agenda telefónica", mainController);
        final Scene scene = new Scene(btp);
        scene.getStylesheets().add(getClass().getResource("/stylesheets/bordered_titled_pane.css").toExternalForm());
        primaryStage.setTitle("Gestoría MOLDES - María Elena González Moldes");

        primaryStage.setMaxWidth(610);
        primaryStage.setMaxHeight(625);
        primaryStage.setMinWidth(610);
        primaryStage.setMinHeight(625);

//        EmailSenderService sender = new EmailSenderService();
//        sender.sendEmail("jm@gm.com","[De GM] - Nueva prueba","Esto es el texto del correo-e");

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static Stage getStage(){
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
