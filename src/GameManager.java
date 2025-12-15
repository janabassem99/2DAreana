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
import javafx.scene.effect.DropShadow;

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