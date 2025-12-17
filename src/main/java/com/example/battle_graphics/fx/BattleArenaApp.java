package com.example.battle_graphics.fx;
import com.example.battle_graphics.base.*;
import javafx.stage.Stage;

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

}
