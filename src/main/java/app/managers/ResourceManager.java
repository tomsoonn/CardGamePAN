package main.java.app.managers;

import javafx.scene.image.Image;

public class ResourceManager {
    private static Image[] cardsImages;

    public static void loadResources() { //load card images
        try {
            cardsImages = new Image[24];

            for (int i = 0; i < 24; i++) {
                cardsImages[i] = new Image(ResourceManager.class.getResourceAsStream("/cards/a" + (i + 1) + ".png"));
            }

        } catch (Exception e) {
            System.out.println("Error loading one of the resources.");
            e.printStackTrace();
        }
    }

    public static Image[] getCardsImages() {
        return cardsImages;
    }
}

