package com.example.battle_graphics.fx;
import com.example.battle_graphics.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BattleArenaApp extends javafx.application.Application {
    private final double WIDTH = 900;
    private final double HEIGHT = 600;

    private Stage primaryStage;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        primaryStage.setTitle("Battle Arena");
        primaryStage.setScene(createTitleScene());
        primaryStage.show();
    }

    private Scene createTitleScene() {
        Label title = new Label("BATTLE ARENA");
        title.setFont(Font.font("Arial", 56));
        title.setTextFill(Color.web("#ffffff"));
        title.setStyle("-fx-font-weight: bold; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.6), 6,0,0,2);");

        Label subtitle = new Label("SHOOT AND RUN!");
        subtitle.setFont(Font.font("Arial", 18));
        subtitle.setTextFill(Color.web("#dddddd"));

        Button startBtn = new Button("Start");
        startBtn.setPrefWidth(180);
        startBtn.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold;");
        startBtn.setOnAction(e -> {
            System.out.println("Start (title) pressed");
            primaryStage.setScene(buildSelectionScene());
        });

        Button howToBtn = new Button("How to Play");
        howToBtn.setPrefWidth(180);
        howToBtn.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white; -fx-font-weight: bold;");
        howToBtn.setOnAction(e -> buildHowToPlay());

        Button exitBtn = new Button("Exit");
        exitBtn.setPrefWidth(180);
        exitBtn.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-weight: bold;");
        exitBtn.setOnAction(e -> primaryStage.close());

        VBox buttonBox = new VBox(12, startBtn, howToBtn, exitBtn);
        buttonBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(18);
        root.setPadding(new Insets(60));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: linear-gradient(#2c3e50, #1a252f);");
        root.getChildren().addAll(title, subtitle, buttonBox);

        return new Scene(root, WIDTH, HEIGHT);
    }

}
