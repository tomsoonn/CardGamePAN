package application;

import javafx.scene.image.Image;

public class Resources {

	Image[] imgsCards;
	
	public void loadResourses() {
		try {

            imgsCards = new Image[24];
            
            for (int i = 0; i < 24; i++) {
                
                   imgsCards[i] = new Image(Resources.class.getResourceAsStream("cards/a" + (i + 1) + ".png"));
                
            }

        } catch (Exception e) {
        	System.out.println("error loading one of the resourses");
        	e.printStackTrace();
        }
    }
}

