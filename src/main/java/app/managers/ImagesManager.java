package main.java.app.managers;

import javafx.scene.image.Image;
import main.java.app.model.Card;

public class ImagesManager {

    public static Image getCardImage(Card c) { //mapping from card to card image
        if (c.getColor().equals("trefl")) {
            if (c.getName().equals("dziewiec"))
                return ResourceManager.getCardsImages()[0];
            if (c.getName().equals("dziesiec"))
                return ResourceManager.getCardsImages()[4];
            if (c.getName().equals("as"))
                return ResourceManager.getCardsImages()[8];
            if (c.getName().equals("jopek"))
                return ResourceManager.getCardsImages()[12];
            if (c.getName().equals("krol"))
                return ResourceManager.getCardsImages()[16];
            if (c.getName().equals("dama"))
                return ResourceManager.getCardsImages()[20];
        }
        if (c.getColor().equals("karo")) {
            if (c.getName().equals("dziewiec"))
                return ResourceManager.getCardsImages()[1];
            if (c.getName().equals("dziesiec"))
                return ResourceManager.getCardsImages()[5];
            if (c.getName().equals("as"))
                return ResourceManager.getCardsImages()[9];
            if (c.getName().equals("jopek"))
                return ResourceManager.getCardsImages()[13];
            if (c.getName().equals("krol"))
                return ResourceManager.getCardsImages()[17];
            if (c.getName().equals("dama"))
                return ResourceManager.getCardsImages()[21];
        }
        if (c.getColor().equals("kier")) {
            if (c.getName().equals("dziewiec"))
                return ResourceManager.getCardsImages()[2];
            if (c.getName().equals("dziesiec"))
                return ResourceManager.getCardsImages()[6];
            if (c.getName().equals("as"))
                return ResourceManager.getCardsImages()[10];
            if (c.getName().equals("jopek"))
                return ResourceManager.getCardsImages()[14];
            if (c.getName().equals("krol"))
                return ResourceManager.getCardsImages()[18];
            if (c.getName().equals("dama"))
                return ResourceManager.getCardsImages()[22];
        }
        if (c.getColor().equals("pik")) {
            if (c.getName().equals("dziewiec"))
                return ResourceManager.getCardsImages()[3];
            if (c.getName().equals("dziesiec"))
                return ResourceManager.getCardsImages()[7];
            if (c.getName().equals("as"))
                return ResourceManager.getCardsImages()[11];
            if (c.getName().equals("jopek"))
                return ResourceManager.getCardsImages()[15];
            if (c.getName().equals("krol"))
                return ResourceManager.getCardsImages()[19];
            if (c.getName().equals("dama"))
                return ResourceManager.getCardsImages()[23];
        }
        return null;
    }
}
