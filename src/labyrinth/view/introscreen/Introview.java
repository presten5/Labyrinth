package labyrinth.view.introscreen;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Introview extends BorderPane {

    private Button exitbutton;
    private Button playbutton;
    private Button rules;
    private Background background;
    private Label title;

    public Introview() {

        initialiseNodes();
        layoutNodes();
        setBackground();


    }

    private void setBackground() {
        BackgroundImage bgImage = new BackgroundImage(
                new Image("intro.jpg"),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true)
        );
        background = new Background(bgImage);
        this.setBackground(background);
    }


    void initialiseNodes() {
        exitbutton = new Button("Exit");
        playbutton = new Button("Play");
        rules = new Button("Rules");
        this.setBackground(background);
        exitbutton.setOnAction(e -> System.exit(0));
        title = new Label("Labyrinth");
    }

    public void layoutNodes() {
        exitbutton.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
        exitbutton.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setCenter(exitbutton);

        this.playbutton.setStyle("-fx-font-size: 20; -fx-pref-width: 150;");
        this.playbutton.setBorder(Border.stroke(Color.GRAY));
        this.exitbutton.setStyle("-fx-font-size: 20; -fx-pref-width: 150;");
        this.rules.setStyle("-fx-font-size: 20; -fx-pref-width: 143;");
        this.exitbutton.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        this.playbutton.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        this.rules.setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
        HBox centerBox = new HBox(60);
        centerBox.setAlignment(Pos.CENTER);
        centerBox.getChildren().addAll(playbutton, rules, exitbutton, title);
        exitbutton.getStyleClass().add("my-button");
        playbutton.getStyleClass().add("my-button");
        rules.getStyleClass().add("my-button");

        this.setCenter(centerBox);
        BorderPane.setAlignment(centerBox, Pos.CENTER);


    }

    public Button getPlaybutton() {
        return playbutton;
    }

    public void setPlaybutton(Button playbutton) {
        this.playbutton = playbutton;
    }

    public Button getExitbutton() {
        return exitbutton;
    }

    public void setExitbutton(Button exitbutton) {
        this.exitbutton = exitbutton;
    }

    public Button getRules() {
        return rules;
    }

    public void setRules(Button rules) {
        this.rules = rules;
    }

}

