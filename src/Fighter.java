import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.List;

abstract public class Fighter {

    private String name;
    private int health;
    private int maxHp;
    private double speed;
    protected double xPosition, yPosition;
    protected boolean facingRight;
    protected Shape fighterShape;
    private Color fighterColor;
    private List<Weapon> weapons = new ArrayList<>();
    private int currentWeaponIndex = 0;
    protected long lastShoot;

    public Fighter() {
    }

    public Fighter(String name, int health, double x, double y, double speed, boolean facingRight, long lastShoot, Color color, int maxHp) {
        this.name = name;
        this.health = health;
        this.xPosition = x;
        this.yPosition = y;
        this.speed = speed;
        this.facingRight = facingRight;
        this.lastShoot = lastShoot;
        this.fighterColor = color;
        this.fighterShape = null;
        this.maxHp = maxHp;
    }

    public int getHealth() {
        return health;
    }

    public Color getFighterColor() {
        return fighterColor;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public abstract void createShape();

    public double getX() {
        return xPosition;
    }

    public double getY() {
        return yPosition;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void decreaseHealth(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }


    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

}