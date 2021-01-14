package main.java.app.managers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.java.app.controllers.PlaygameController;
import main.java.app.model.Game;

import java.io.IOException;

public class ViewManager {
    private static Stage primaryStage;
    private static BorderPane mainLayout;

    public static void init() {
        primaryStage = new Stage();
        primaryStage.setTitle("Card game \"PAN\"");
        primaryStage.setResizable(false);
        mainLayout = new BorderPane();
    }

    public static void showStartPage() {
        loadFXML("/fxml/Startpage.fxml");
        Scene scene = new Scene(mainLayout);
        primaryStage.setHeight(560);
        primaryStage.setWidth(726);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void showSetPlayers() {
        loadFXML("/fxml/Setplayers.fxml");
        primaryStage.setHeight(560);
        primaryStage.setWidth(726);
    }

    public static void showPlayGame(Game game) {

        PlaygameController play = (PlaygameController) loadFXML("/fxml/Playgame.fxml");
        play.setNames(game.getP1Turn(), game.getEndGame());
        primaryStage.setHeight(750);
        primaryStage.setWidth(1000);
        // show p1 deck with images
        for (int i = 0; i < game.getPlayer1().getDeck().getSize(); i++) {
            Image image = ImagesManager.getCardImage(game.getPlayer1().getDeck().getCardByIndex(i));
            if (i > 16)
                play.addCard(image, i, 50 + (16 * 40), 50 + (30 * (i - 16)));
            else
                play.addCard(image, i, 50 + (i * 40), 50);
        }
        // show p2 deck with images
        for (int i = 0; i < game.getPlayer2().getDeck().getSize(); i++) {
            Image image = ImagesManager.getCardImage(game.getPlayer2().getDeck().getCardByIndex(i));
            if (i > 16)
                play.addCard(image, i + game.getPlayer1().getDeck().getSize(), 50 + (16 * 40), 170 + (30 * (i - 16)));
            else
                play.addCard(image, i + game.getPlayer1().getDeck().getSize(), 50 + (i * 40), 170);
        }
        // show table deck with images
        for (int i = 0; i < game.getTable().getSize(); i++) {
            Image image = ImagesManager.getCardImage(game.getTable().getCardByIndex(i));
            if (i > 16)
                play.addCard(image, i + game.getPlayer1().getDeck().getSize() + game.getPlayer2().getDeck().getSize(), 50 + (16 * 40), 290 + (30 * (i - 16)));
            else
                play.addCard(image, i + game.getPlayer1().getDeck().getSize() + game.getPlayer2().getDeck().getSize(), 50 + (i * 40), 290);
        }
    }

    private static Object loadFXML(String name) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(main.java.app.App.class.getResource(name));
        try {
            mainLayout.setCenter(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return loader.getController();
    }
}
