package labyrinth.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Introview extends BorderPane {

    Button buttonPlay;
    Button buttonRules;

    Button buttonExit;


    public Introview() {
      initializeNodes();
      layoutNodes();


    }

    public void initializeNodes() {

        buttonExit = new Button("Exit");
        buttonRules = new Button("Rules");
        buttonPlay = new Button("Play");
        buttonExit.setOnAction(e -> {
            System.exit(0);
        });





    }

    public void layoutNodes(){
        this.buttonPlay.setStyle("-fx-font-size: 20; -fx-pref-width: 150;");
        this.buttonExit.setStyle("-fx-font-size: 20; -fx-pref-width: 150;");
        this.buttonRules.setStyle("-fx-font-size: 20; -fx-pref-width: 143;");
        VBox centerBox = new VBox(20);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.getChildren().addAll(buttonPlay, buttonRules, buttonExit);
        this.setCenter(centerBox);
        BorderPane.setAlignment(centerBox, Pos.CENTER);




    }








}

