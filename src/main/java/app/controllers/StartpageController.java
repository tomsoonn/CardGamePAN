package main.java.app.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import main.java.app.App;

public class StartpageController {

    private App main;

    @FXML
    private void setPlayers() {
        main.showSetPlayers();
    }

    @FXML
    private void exitGame() {
        Platform.exit();
    }

}
