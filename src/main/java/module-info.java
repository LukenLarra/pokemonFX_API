module eus.ehu.pokemonfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires okhttp3;


    
    opens eus.ehu.pokemonfx to javafx.fxml;
    exports eus.ehu.pokemonfx;

    opens eus.ehu.pokemonfx.domain to com.google.gson;
}