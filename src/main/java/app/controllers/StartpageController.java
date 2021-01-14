package main.java.app.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import main.java.app.App;

public class StartpageController {

    @FXML
    private void setPlayers() {
        App.showSetPlayers();
    }

    @FXML
    private void exitGame() {
        Platform.exit();
    }

}
