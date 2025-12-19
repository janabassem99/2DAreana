package com.example.battle_graphics;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
public class Warrior extends Fighter {
    public Warrior(double x, double y) {
        super("base.Warrior", 150, x, y, 3, true, 0, Color.HOTPINK, 150);
        addWeapon(new Pistol());
        addWeapon(new Weapon("Sword Slash", 15, 5.0, 700L));
        addWeapon(new Weapon("Heavy Axe", 30, 3.0, 1500L));
    }
    @Override
    public void createShape() {
        Shape s = SoldierShapeFactory.createSoldier(getFighterColor(), getxPosition(), getyPosition());
        s=this.getFighterShape() ;
        getFighterShape().setScaleX(3.5);
        getFighterShape().setScaleY(2.5);
    }
}
