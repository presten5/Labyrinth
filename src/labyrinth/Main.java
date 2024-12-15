package labyrinth;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import labyrinth.view.introscreen.Introview;


public class Main extends Application {




@Override
public void start(Stage primaryStage){

    Introview introview = new Introview();
    Scene scene = new Scene(introview);
    BorderPane borderPane = new BorderPane();
    primaryStage.setScene(scene);
    scene.getStylesheets().add(getClass().getResource("/Stylesheet.css").toExternalForm());







    primaryStage.setTitle("introtest");
    primaryStage.show();
    primaryStage.setFullScreen(true);

}

public static void main(String[] args) {
    launch(args);
}
    }
