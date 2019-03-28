package application;

public class Game {
	Player player1;
	Player player2;
	Deck talia = new Deck();
	Boolean p1Turn;
	Boolean endGame;
	//Boolean hasMore;
	
	public Game(String p1, String p2){
		Deck deck = new Deck();
		Deck deck1 = new Deck();
		player1= new Player(p1,deck);
		player2= new Player(p2,deck1);
	};
	
	
	public Game(Player p1, Player p2){
		 this.player1=p1;
		 this.player2=p2;
	 }
	
	public void rozdaj(){
		Deck talia = new Deck();
		talia.createFull();
		for(int i=0;i<12;i++){
			this.player1.addCard(talia.popCard());
			this.player2.addCard(talia.popCard());
			
		}
		player1.sort();
		player2.sort();
		p1Turn=true;
		endGame=false;
		//kto ma 9 kier
		for(int i=player2.getDeck().getNum()-1;i>player2.getDeck().getNum()-5;i--)
			if(player2.getDeck().getCard(i).getValue()==0 && player2.getDeck().getCard(i).getColor()=="kier")
				p1Turn=false;
		
	}
	/*
	public void graj(){
		Card c= player1.giveCard(0);
		talia.add(c);
		int licznik = 0;
		while(licznik<50 && !player1.isEmpty() && !player2.isEmpty() && !talia.isEmpty()){
			Card x= player2.giveCard(0);
			if(x.getValue()<talia.getCard(talia.getNum()-1).getValue()) player1.addCard(x);
			else talia.add(x);
			Card y= player1.giveCard(0);
			if(y.getValue()<talia.getCard(talia.getNum()-1).getValue()) player2.addCard(y);
			else talia.add(y);
			licznik++;
			
		}	
	}
	*/
	public Boolean giveCard1(int a, Boolean p1Turn){ //ktora karta(z wyswietlonych), czyja kolej
	
		if(!talia.isEmpty()){	//dowolna wieksza karta
			if(p1Turn && a<player1.getDeck().getNum() && (player1.getDeck().getCard(a).getValue()>=talia.getCard(talia.getNum()-1).getValue())){
				Card c=player1.giveCard(a);
				talia.add(c);
				return true;
			}
			else if(!p1Turn && a>=player1.getDeck().getNum() && (player2.getDeck().getCard(a-player1.getDeck().getNum()).getValue()>=talia.getCard(talia.getNum()-1).getValue())){
				Card c=player2.giveCard(a-player1.getDeck().getNum());
				talia.add(c);
				return true;
			}
		}
		else{	//tylko 9 kier
			if(p1Turn && a<player1.getDeck().getNum() && (player1.getDeck().getCard(a).getValue()==0 && player1.getDeck().getCard(a).getColor()=="kier")){
				Card c=player1.giveCard(a);
				talia.add(c);
				return true;
			}
			else if(!p1Turn && a>=player1.getDeck().getNum() && (player2.getDeck().getCard(a-player1.getDeck().getNum()).getValue()==0 && player2.getDeck().getCard(a-player1.getDeck().getNum()).getColor()=="kier")){
				Card c=player2.giveCard(a-player1.getDeck().getNum());
				talia.add(c);
				return true;
			}
			
		}
		
		return false;
		
	}
	
	public void takeCard(Boolean p1Turn){	//czyja kolej
		if(talia.getNum()>1){
			if(p1Turn){
				Card c=talia.remove(talia.getNum()-1);
				player1.addCard(c);
				player1.sort();
			}
			else{
				Card c=talia.remove(talia.getNum()-1);
				player2.addCard(c);
				player2.sort();
			}
		}
	}
	
	public void Wyswietl(){
		this.player1.Wyswietl();
		System.out.println("       ");
		this.player2.Wyswietl();
		System.out.println("       ");
		this.talia.Wyswietl();
	}
	
	public void changePlayers(){
		p1Turn=!p1Turn;
	}
	
	public void endGame(){
		endGame=true;
	}
	
	/*
	public Boolean theSame34(Deck talia,int val){
		return talia.theSame34(val);
		
	}
		
	public static void main(String[] args){

		  Game gra = new Game("Tomek","Daniel");
		  gra.rozdaj();
		  gra.Wyswietl();

		  gra.graj();
		  gra.Wyswietl();
	}
	*/

}
