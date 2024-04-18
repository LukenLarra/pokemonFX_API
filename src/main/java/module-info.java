module eus.ehu.pokemonfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens eus.ehu.pokemonfx to javafx.fxml;
    exports eus.ehu.pokemonfx;
}