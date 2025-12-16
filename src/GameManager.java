import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;
public class GameManager {

    private Fighter player1;
    private Fighter player2;
    private Pane gamePane;
    private List<Projectile> projectiles;
    private InputHandler input;
    private AnimationTimer gameLoop;
    private final HeartHealthBar hp1;
    private final HeartHealthBar hp2;
    private final double arenawidth;
    private final double arenaheight;
    private boolean gameOver = false;
    private final Runnable onPlayAgain;

    public GameManager(Fighter p1, Fighter p2, Pane pane, InputHandler handler, HeartHealthBar hp1, HeartHealthBar hp2, double arenawidth, double arenaheight, Runnable onPlayAgain) {
        this.player1 = p1;
        this.player2 = p2;
        this.gamePane = pane;
        this.input = handler;
        this.hp1 = hp1;
        this.hp2 = hp2;
        this.arenawidth = arenawidth;
        this.arenaheight = arenaheight;
        this.projectiles = new ArrayList<>();
        this.onPlayAgain = onPlayAgain;
    }
    if (player1.getFighterShape() != null){
        player1.getFighterShape().setTranslateX(player1.getX());
        player1.getFighterShape().setTranslateY(player1.getY());
    }
        if (player2.getFighterShape() != null){
        player2.getFighterShape().setTranslateX(player2.getX());
        player2.getFighterShape().setTranslateY(player2.getY());
    }
        gamePane.getChildren().addAll(player1.getFighterShape(), player2.getFighterShape());

        hp1.setDisplaySize(48, 48);
        hp1.setLayoutX(20);
        hp1.setLayoutY(16);
        hp1.setProgress((double) player1.getHealth() / player1.getMaxHp());

        hp2.setDisplaySize(48, 48);
        hp2.setLayoutX(arenawidth - 68);
        hp2.setLayoutY(16);
        hp2.setProgress((double) player2.getHealth() / player2.getMaxHp());
        gamePane.getChildren().addAll(hp1, hp2);

    startLoop();
        if (this.input != null) {
        this.input.setGameController(this);
    }
public Pane getGamePane() {
        return gamePane;
    }

    public InputHandler getInput() {
        return input;
    }

    public double getArenawidth() {
        return arenawidth;
    }

    public double getArenaheight() {
        return arenaheight;
    }

    private void startLoop() {
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        gameLoop.start();
    }

    private void update() {
        if (gameOver) return;

        input.handleMovement();
        updateProjectiles();
        checkCollisions();
        updateHealthBars();
        checkWinner();
    }
}
