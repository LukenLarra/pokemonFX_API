package eus.ehu.pokemonfx;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import eus.ehu.pokemonfx.domain.Pokemon;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import com.google.gson.Gson;

import java.io.IOException;

public class MainUIController {

    @FXML
    private ImageView icon;

    @FXML
    private TextField name;

    @FXML
    private Label heightLbl;

    @FXML
    private Label idLbl;

    @FXML
    private Label nameLbl;

    @FXML
    private Label weightLbl;

    @FXML
    private Label errorMsg;

    private int currentId = 1;

    private int maxId = 10277;

    @FXML
    void actionGet(ActionEvent event) {
        searchPokemon();
    }

    @FXML
    void nextPokemon(ActionEvent event) {
        if (currentId == maxId) currentId = 1;
        else currentId++;
        searchPokemon();
    }

    @FXML
    void previousPokemon(ActionEvent event) {
        if (currentId == 1) currentId = maxId;
        else currentId--;
        searchPokemon();
    }

    @FXML
    void searchPokemon() {
        Gson gson = new Gson();
        String json;
        try {
            if (!name.getText().isEmpty()){
                json = Utils.query("https://pokeapi.co/api/v2/pokemon/" + name.getText());
            }else {
                if (currentId == 1026) currentId = 10001;
                if (currentId == 10000) currentId = 1025;
                json = Utils.query("https://pokeapi.co/api/v2/pokemon/" + currentId);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Pokemon pokemon = null;
        try {
            pokemon = gson.fromJson(json, Pokemon.class);
        } catch (JsonSyntaxException error) {
            errorMsg.setText("Pokemon not found, type another name");
            name.clear();
            PauseTransition visiblePause = new PauseTransition(javafx.util.Duration.seconds(3));
            visiblePause.setOnFinished(e -> errorMsg.setText(""));
            visiblePause.play();
            throw new RuntimeException(error);
        }

        String url = pokemon.getSprite();
        icon.setImage(new Image(url));
        nameLbl.setText(pokemon.getName());
        heightLbl.setText(pokemon.getHeight() +" cm");
        weightLbl.setText(pokemon.getWeight() +" kg");
        idLbl.setText(String.valueOf(pokemon.getId()));
        currentId = pokemon.getId();
        name.clear();
    }

    @FXML
    void initialize() {
        searchPokemon();


    }

}
