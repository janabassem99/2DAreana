import javafx.scene.input.KeyCode;
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
}
