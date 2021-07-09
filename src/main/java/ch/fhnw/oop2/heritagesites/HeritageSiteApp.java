package ch.fhnw.oop2.heritagesites;

import ch.fhnw.oop2.heritagesites.presentationModel.ApplicationPM;
import ch.fhnw.oop2.heritagesites.view.ApplicationUI;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HeritageSiteApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        ApplicationPM applicationPM = new ApplicationPM();

        Parent rootPanel = new ApplicationUI();

        Scene scene = new Scene(rootPanel);

        primaryStage.titleProperty().bind(applicationPM.applicationTitleProperty());
        primaryStage.setScene(scene);
        primaryStage.setMinHeight(600);
        primaryStage.setMinWidth(1000);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
