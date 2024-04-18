package eus.ehu.pokemonfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class MainUIController {

    @FXML
    private TextArea content;

    @FXML
    private ImageView icon;

    @FXML
    private TextField name;

    @FXML
    void actionGet(ActionEvent event) {

    }

    @FXML
    void initialize() {
        content.setText(Utils.readFile("2024-04-18T141621.200.json"));

    }

}
