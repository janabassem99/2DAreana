module com.example.battle_graphics {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    opens com.example.battle_graphics to javafx.graphics;
    exports com.example.battle_graphics;
    exports com.example.battle_graphics.fx;
    opens com.example.battle_graphics.fx to javafx.graphics;
}