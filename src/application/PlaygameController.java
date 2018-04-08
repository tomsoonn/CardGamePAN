package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class PlaygameController {
	Main main;
	
	@FXML
	public Label name1;
	@FXML
	public Label name2;
	@FXML
	public Label turn;
	@FXML
	public AnchorPane right;
	
	@FXML
	public ImageView[] cards=new ImageView[25];
	
	public void setNames(Boolean p1Turn, Boolean endGame){
		if(SetplayersController.name1.length()>0){
			name1.setText(SetplayersController.name1+":");
			if(p1Turn){
				if(endGame)
					turn.setText(SetplayersController.name2 + " won! ;)");
				else
					turn.setText("Turn: "+SetplayersController.name1);
			}
			
		}
		else if(p1Turn){
			if(endGame)
				turn.setText("Player2 won! ;)");
			else
				turn.setText("Turn: Player1");
		}
		if(SetplayersController.name2.length()>0){
			name2.setText(SetplayersController.name2+":");
			if(!p1Turn){
				if(endGame)
					turn.setText(SetplayersController.name1 + " won! ;)");
				else
					turn.setText("Turn: "+SetplayersController.name2);
			}
		}
		else if(!p1Turn){
			if(endGame)
				turn.setText("Player1 won! ;)");
			else
				turn.setText("Turn: Player2");
		}
	}
	
	public void addCard(Image i,int a,int x, int y){
		cards[a]= new ImageView(i);
		right.getChildren().add(cards[a]);
		cards[a].setX(x);
		cards[a].setY(y);
		cards[a].setFitWidth(80);
		cards[a].setFitHeight(110);
		if(y==50){
			cards[a].setOnMouseClicked(e -> {
				main.giveCard1(a);
			});	
		}
		if(y==170){
			cards[a].setOnMouseClicked(e -> {
				main.giveCard1(a);
			});	
		}
		if(y>=290 && a==23){
			cards[a].setOnMouseClicked(e -> {
				main.takeCard();
			});
		}
			
	}
		
	public void exit(){
		Platform.exit();
	}
	
	public void again(){
		main.startGame();
	}
	
	public void newPlayers(){
		main.showSetPlayers();
	}
	
	//public void hideCard(int i){
	//	cards[i].setVisible(false);
	//}
	
	
}
