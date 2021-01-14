package main.java.app.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import main.java.app.App;

import java.io.IOException;

public class SetplayersController {
    static String name1;
    static String name2;

    @FXML
    public TextField player1;
    @FXML
    public TextField player2;
    App main;
    @FXML
    PlaygameController play;

    public static String getName1() {
        return name1;
    }

    public static String getName2() {
        return name2;
    }

    public void setNames() {
        name1 = player1.getText();
        name2 = player2.getText();
    }

    @FXML
    private void startGame() throws InterruptedException, IOException {
        setNames();

        main.startGame();

    }

}
