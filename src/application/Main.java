package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private static Stage primaryStage;
	private static BorderPane mainLayout;
	static Resources res;
	static Game game;
	
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Gra karciana \"PAN\"");
		showStartpage();
		this.primaryStage.setResizable(false);
		
		
	}
	
	private void showStartpage() { //wyswietla strone startowa
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Startpage.fxml"));
			BorderPane root = loader.load();
			mainLayout = root;
			Scene scene = new Scene(mainLayout);
			primaryStage.setHeight(560);
			primaryStage.setWidth(726);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void showSetPlayers() { //wyswietla panel z imionami
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Setplayers.fxml"));
			BorderPane root = loader.load();
			primaryStage.setHeight(560);
			primaryStage.setWidth(726);
			mainLayout.setCenter(root);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void showPlayGame() { //wyswietla stan gry
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Playgame.fxml"));
			BorderPane root = loader.load();
			PlaygameController play=loader.getController();
			play.setNames(game.p1Turn, game.endGame);
			mainLayout.setCenter(root);
			primaryStage.setHeight(750);
			primaryStage.setWidth(1000);
			for(int i=0;i<game.player1.getDeck().getNum();i++){
				Image image=getCardImage(game.player1.getDeck().getCard(i));
				if(i>16)
					play.addCard(image, i,50+(16*40), 50+(30*(i-16)));
				else
					play.addCard(image, i,50+(i*40), 50);
			}
			for(int i=0;i<game.player2.getDeck().getNum();i++){
				Image image=getCardImage(game.player2.getDeck().getCard(i));
				if(i>16)
					play.addCard(image, i+game.player1.getDeck().getNum(),50+(16*40), 170+(30*(i-16)));
				else
					play.addCard(image, i+game.player1.getDeck().getNum(),50+(i*40), 170);
			}
			for(int i=0;i<game.talia.getNum();i++){
				Image image=getCardImage(game.talia.getCard(i));
				if(i>16)
					play.addCard(image, i+game.player1.getDeck().getNum()+game.player2.getDeck().getNum(),50+(16*40), 290+(30*(i-16)));
				else
					play.addCard(image, i+game.player1.getDeck().getNum()+game.player2.getDeck().getNum(),50+(i*40), 290);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Image getCardImage(Card c){ //pobiera odpowiednie zdjecie karty
		if(c.getColor()=="trefl"){
			if(c.getName()=="dziewiec")
				return res.imgsCards[0];
			if(c.getName()=="dziesiec")
				return res.imgsCards[4];
			if(c.getName()=="as")
				return res.imgsCards[8];
			if(c.getName()=="jopek")
				return res.imgsCards[12];
			if(c.getName()=="krol")
				return res.imgsCards[16];
			if(c.getName()=="dama")
				return res.imgsCards[20];
		}
		if(c.getColor()=="karo"){
			if(c.getName()=="dziewiec")
				return res.imgsCards[1];
			if(c.getName()=="dziesiec")
				return res.imgsCards[5];
			if(c.getName()=="as")
				return res.imgsCards[9];
			if(c.getName()=="jopek")
				return res.imgsCards[13];
			if(c.getName()=="krol")
				return res.imgsCards[17];
			if(c.getName()=="dama")
				return res.imgsCards[21];
		}
		if(c.getColor()=="kier"){
			if(c.getName()=="dziewiec")
				return res.imgsCards[2];
			if(c.getName()=="dziesiec")
				return res.imgsCards[6];
			if(c.getName()=="as")
				return res.imgsCards[10];
			if(c.getName()=="jopek")
				return res.imgsCards[14];
			if(c.getName()=="krol")
				return res.imgsCards[18];
			if(c.getName()=="dama")
				return res.imgsCards[22];
		}
		if(c.getColor()=="pik"){
			if(c.getName()=="dziewiec")
				return res.imgsCards[3];
			if(c.getName()=="dziesiec")
				return res.imgsCards[7];
			if(c.getName()=="as")
				return res.imgsCards[11];
			if(c.getName()=="jopek")
				return res.imgsCards[15];
			if(c.getName()=="krol")
				return res.imgsCards[19];
			if(c.getName()=="dama")
				return res.imgsCards[23];
		}
		return null;
		
	}
	
	public static void startGame() {
		game=new Game(SetplayersController.name1,SetplayersController.name2); //nowa gra
		game.rozdaj();														  //rozdanie kart
		//game.Wyswietl();	
		//game.graj();
		res=new Resources();												  //ladowanie zdjec
		res.loadResourses();
		showPlayGame();
		//while(!(game.player1.isEmpty() || game.player2.isEmpty())){
			
		//}	
	}
	
	public static void giveCard1(int x){	//wylozenie karty
		if(!game.endGame && game.giveCard1(x,game.p1Turn))
			game.changePlayers();
		if(game.player1.isEmpty() || game.player2.isEmpty()){
			game.endGame();
		}
		showPlayGame();
		
	}
	
	public static void takeCard(){	//wziecie karty
		if(!game.endGame && game.talia.getNum()>1){
			game.takeCard(game.p1Turn);
			game.takeCard(game.p1Turn);
			game.takeCard(game.p1Turn);
			game.changePlayers();
			showPlayGame();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
