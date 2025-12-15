import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashSet;
import java.util.Set;
public class InputHandler {

    private final Set<KeyCode> activeKeys = new HashSet<>();
    private final Fighter player1;
    private final Fighter player2;
    private GameManager gameController;

    public InputHandler(Fighter p1, Fighter p2, GameManager controller) {
        this.player1 = p1;
        this.player2 = p2;
        this.gameController = controller;
    }

    public void handleKeyPressed(KeyEvent event) {
        activeKeys.add(event.getCode());
        if (event.getCode() == KeyCode.F) shoot(player1);
        else if (event.getCode() == KeyCode.Q) player1.switchWeapon();
        else if (event.getCode() == KeyCode.L) shoot(player2);
        else if (event.getCode() == KeyCode.E) player2.switchWeapon();
    }

    public void handleKeyReleased(KeyEvent event) {
        activeKeys.remove(event.getCode());
    }

    private void shoot(Fighter player) {
        if (gameController == null) return;
        Projectile p = player.shoot();
        if (p != null) {
            gameController.addProjectile(p);
        }
    }
}
