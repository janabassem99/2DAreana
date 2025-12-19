package com.example.battle_graphics;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Archer extends Fighter {

    public Archer(double x, double y) {
        super("base.Archer", 110, x, y, 4.0, true, 0, Color.LIGHTSKYBLUE, 110);
        addWeapon(new cannon());
        addWeapon(new Weapon("Arrow", 12, 7.0, 500L));
        addWeapon(new Weapon("Fire Arrow", 20, 6.0, 900L));
        addWeapon(new Weapon("Rapid Shot", 7, 10.0, 250L));
    }

    @Override
    public void createShape() {
        Shape s = SoldierShapeFactory.createSoldier(getFighterColor(), getxPosition(), getyPosition());
         this.fighterShape =s ;
        fighterShape.setScaleX(3.5);
        fighterShape.setScaleY(2.5);
    }
}
