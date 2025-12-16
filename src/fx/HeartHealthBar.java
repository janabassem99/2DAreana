package fx;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;


public class HeartHealthBar extends StackPane {

    private final SVGPath outline;
    private final SVGPath fillShape;
    private final Rectangle clipRect;

    private static final double BASE_W = 60.0;
    private static final double BASE_H = 60.0;

    private double progress = 1.0;

    public HeartHealthBar(Color fillColor) {
        String heartPath =
                "M30 52 L12 36 C4 28 4 18 12 12 C18 7 26 8 30 14 C34 8 42 7 48 12 C56 18 56 28 48 36 L30 52 Z";
        outline = new SVGPath();
        outline.setContent(heartPath);
        outline.setFill(Color.TRANSPARENT);
        outline.setStroke(Color.DARKRED);
        outline.setStrokeWidth(1.8);}}