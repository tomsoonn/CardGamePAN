package application;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class SetplayersController {
	Main main;
	static String name1;
	static String name2;
	@FXML PlaygameController play;
	
	@FXML
	public TextField player1;
	@FXML
	public TextField player2;
	
	public void setNames(){
		name1=player1.getText();
		name2=player2.getText();
	}
	
	@FXML
	private void startGame() throws InterruptedException, IOException {
		setNames();
        
		main.startGame();
		
	}
	
}
