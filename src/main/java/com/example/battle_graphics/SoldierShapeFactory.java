package com.example.battle_graphics;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;

public  final class SoldierShapeFactory {
    private SoldierShapeFactory(){}
    public static Shape createSoldier(Color color, double x, double y) {
        SVGPath s = new SVGPath();
        s.setContent(
                "M10 2 " + "C12 2 14 4 14 6 " +
                        "C14 8 12 10 10 10 " +
                        "C8 10 6 8 6 6 " +
                        "C6 4 8 2 10 2 Z " +"M3 12 L17 12 L17 22 L13 22 L13 30 L11 30 L11 22 L7 22 L7 30 L5 30 L5 22 L3 22 Z" // torso+arms+legs block
        );
        s.setFill(color);
        s.setStroke(Color.BLACK);
        s.setTranslateX(x);
        s.setTranslateY(y);

        return s;
    }

    }
