package eus.ehu.pokemonfx;

import eus.ehu.pokemonfx.domain.Pokemon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import com.google.gson.Gson;

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
        Gson gson = new Gson();
        String json = Utils.readFile("2024-04-18T160842.200.json");
        Pokemon pokemon = gson.fromJson(json, Pokemon.class);

        String url = pokemon.getSprite();
        icon.setImage(new Image(url));
        content.setText(Utils.readFile(pokemon.toString()));


    }

}
