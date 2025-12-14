import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class Projectile{

    private double x, y;
    private double speed;
    private int damage;
    private boolean directionRight;
    private boolean active = true;
    private Rectangle shape;
    private Fighter owner;

    public Projectile(double x, double y, double speed, int damage, boolean directionRight, Fighter owner) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.damage = damage;
        this.directionRight = directionRight;
        this.owner = owner;

        shape = new Rectangle(12, 4, Color.BLACK);
        shape.setX(x);
        shape.setY(y);
    }
}

