package com.example.battle_graphics.fx;
import com.example.battle_graphics.*;
import javafx.scene.control.ComboBox;
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
    private void buildHowToPlay(){
        Label header = new Label("How to Play");
        header.setFont(Font.font("Arial", 28));
        header.setTextFill(Color.WHITE);

        Label lines = new Label(
                "Player 1: Move with WASD, Shoot = F, Switch Weapon = Q\n" +
                        "Player 2: Move with Arrow Keys, Shoot = L, Switch Weapon = E\n\n" +
                        "Each fighter has multiple weapons — switch to find the best one.\n" +
                        "First player to reduce the opponent's health to 0 wins."
        );
        lines.setFont(Font.font("Arial", 14));
        lines.setTextFill(Color.web("#e9e9e9"));

        Button back = new Button("Back");
        back.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold;");
        back.setOnAction(e -> primaryStage.setScene(createTitleScene()));

        VBox box = new VBox(12, header, lines, back);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(24));
        box.setStyle("-fx-background-color: rgba(20,20,20,0.6); -fx-background-radius: 8;");

        VBox root = new VBox(10, box);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(40));
        root.setStyle("-fx-background-color: linear-gradient(#2c3e50, #1a252f);");

        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));}

    private Scene buildSelectionScene() {

        ComboBox<String> p1Select = new ComboBox<>();
        p1Select.getItems().addAll("Warrior", "Mage", "Archer");
        p1Select.setValue("Warrior");

        ComboBox<String> p2Select = new ComboBox<>();
        p2Select.getItems().addAll("Warrior", "Mage", "Archer");
        p2Select.setValue("Archer");

        Label titleLabel = new Label("🎮 Select Fighters");
        titleLabel.setFont(Font.font("Arial", 22));
        titleLabel.setTextFill(Color.web("#ffffff"));

        Label p1Label = new Label("Player 1:");
        p1Label.setTextFill(Color.web("#ffffff"));
        Label p2Label = new Label("Player 2:");
        p2Label.setTextFill(Color.web("#ffffff"));

        Button startButton = new Button("Start Battle");
        startButton.setStyle("-fx-background-color: #e67e22; -fx-text-fill: white; -fx-font-weight: bold;");

        startButton.setOnAction(e -> {
            System.out.println("Start Battle pressed (selection)");
            Fighter p1 = createFighter(p1Select.getValue(), 100, HEIGHT / 2);
            Fighter p2 = createFighter(p2Select.getValue(), WIDTH - 150, HEIGHT / 2);


            p2.setFacingRight(false);

            primaryStage.setScene(createGameScene(p1, p2));
        });
    1