package application;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class StartpageController {
	
	private Main main;
	@FXML
	private void setPlayers() {
		main.showSetPlayers();
	}
	@FXML
	private void exitGame() {
		Platform.exit();
	}
	
}
