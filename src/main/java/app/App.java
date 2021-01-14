package main.java.app;

import javafx.application.Application;
import javafx.stage.Stage;
import main.java.app.controllers.SetplayersController;
import main.java.app.managers.ResourceManager;
import main.java.app.managers.ViewManager;
import main.java.app.model.Game;


public class App extends Application {
    static Game game;

    public static void startGame() {
        ResourceManager.loadResources();
        game = new Game(SetplayersController.getName1(), SetplayersController.getName2());
        game.dealCards();
        game.setEndGame(false);
        showPlayGame(game);
    }

    public static void giveCard(int x) {
        game.giveCard(x);
        showPlayGame(game);
    }

    public static void takeCard() {
        game.takeCardsFromTable();
        showPlayGame(game);
    }

    private static void showStartPage() {
        ViewManager.showStartPage();
    }

    public static void showSetPlayers() {
        ViewManager.showSetPlayers();
    }

    private static void showPlayGame(Game game) {
        ViewManager.showPlayGame(game);
    }

    public static void startApp() {
        launch();
    }

    @Override
    public void start(Stage stage) {
        ViewManager.init();
        showStartPage();
    }
}
