package labyrinth;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import labyrinth.view.Introview;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Introview intro = new Introview();

        Scene scene = new Scene(intro);
        BorderPane borderPane = new BorderPane();
        primaryStage.setScene(scene);

        primaryStage.setTitle("Labyrinth");
        primaryStage.show();
        primaryStage.setFullScreen(true);






    }

    public static void main(String[] args) {
        launch(args);

    }
}

